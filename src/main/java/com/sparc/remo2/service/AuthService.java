package com.sparc.remo2.service;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.sparc.remo2.request.LoginRequest;
import com.sparc.remo2.request.SignupRequest;

public interface AuthService {

	ResponseEntity<?> signIn(@Valid LoginRequest loginRequest);

	boolean existsByUsername(String username);

	String createUser(SignupRequest signUpRequest);

	String createMobileUser(SignupRequest signUpRequest);

	ResponseEntity<?> signInMobile(String mobile,String pw);

	boolean existsByMobile(String mobile);

	boolean existsByMobileUsername(String username);

}
