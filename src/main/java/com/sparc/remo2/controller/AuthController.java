package com.sparc.remo2.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sparc.remo2.request.LoginRequest;
import com.sparc.remo2.request.SignupRequest;
import com.sparc.remo2.response.MessageResponse;
import com.sparc.remo2.service.AuthService;

@RestController
@RequestMapping(path = "/api/v1/auth")
public class AuthController {
	
	@Autowired
	AuthService authService;
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) 
	{
		return authService.signIn(loginRequest);
	}
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {
		if (authService.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
		}else {
		return ResponseEntity.ok(new MessageResponse(authService.createUser(signUpRequest)));
	   }
    }
	@PostMapping("/mobileusersignup")
	public ResponseEntity<?> mobileusersignup(@RequestBody SignupRequest signUpRequest) {
		if (authService.existsByMobile(signUpRequest.getUsername())) {
			if (authService.existsByMobileUsername(signUpRequest.getUsername())) {
				return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
			}else {
			return ResponseEntity.ok(new MessageResponse(authService.createMobileUser(signUpRequest)));
		   }
		}
		else {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: you are not authorized.please contact admin!"));
		} 
    }
	@PostMapping("/mobileusersignin")
	public ResponseEntity<?> authenticateMobileUser(@Valid @RequestBody LoginRequest loginRequest) 
	{
		return authService.signInMobile(loginRequest.getLogin_id(),loginRequest.getPassword());
	}

}
