package com.sparc.remo2.service.impl;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.validation.Valid;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import com.sparc.remo2.entity.AuthorityDO;
import com.sparc.remo2.entity.EmployeeAuth;
import com.sparc.remo2.repository.AuthRepository;
import com.sparc.remo2.repository.EmployeeAuthRepository;
import com.sparc.remo2.repository.EmployeeRepository;
import com.sparc.remo2.request.LoginRequest;
import com.sparc.remo2.request.SignupRequest;
import com.sparc.remo2.response.AssignResponse;
import com.sparc.remo2.response.JwtResponse;
import com.sparc.remo2.response.MessageResponse;
import com.sparc.remo2.security.jwt.JwtUtils;
import com.sparc.remo2.security.service.UserDetailsImpl;
import com.sparc.remo2.service.AuthService;
import com.sparc.remo2.service.MasterService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private AuthRepository authRepository;
	
	@Autowired
	private EmployeeAuthRepository empAuthRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private MasterService masterService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@Value("${example.app.jwtSecret}")
	private String key;

	@Value("${example.app.jwtExpirationMs}")
	private int jwtExpirationMs;
	
	@Override
	public ResponseEntity<?> signIn(@Valid LoginRequest loginRequest) 
	{
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.getLogin_id(), loginRequest.getPassword());
		Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(),"","","","","","Admin"));
	}

	@Override
	public boolean existsByUsername(String username) {
		 return authRepository.existsByUsername(username);
	}
	@Override
	public boolean existsByMobile(String mobile) {
		return employeeRepository.existsByPhone(mobile);
	}
	@Override
	public boolean existsByMobileUsername(String username) {
		return empAuthRepository.existsByUsername(username);
	}
	@Override
	public String createUser(SignupRequest signUpRequest) {
		String msg="";
		AuthorityDO auth=new AuthorityDO();
		if (!signUpRequest.equals(null)) {
			auth.setUsername(signUpRequest.getUsername());
			String encode = encoder.encode(signUpRequest.getPassword());
			auth.setPassword(encode);
			auth.setActive(true);
			auth.setUserCreationDate(new Date());
			auth.setUpdatedOn(new Date());
			auth=authRepository.save(auth);
			if(auth!=null) {
				msg="success";
			}else {
				msg="fail";
			}
		}
		return msg;
	}

	@Override
	public String createMobileUser(SignupRequest signUpRequest) {
		String msg="";
		EmployeeAuth emp=new EmployeeAuth();
		if (!signUpRequest.equals(null)) {
			emp.setUsername(signUpRequest.getUsername());
			String encode = encoder.encode(signUpRequest.getPassword());
			emp.setPassword(encode);
			emp.setUserCreationDate(new Date());
			emp=empAuthRepository.save(emp);
			if(emp!=null) {
				msg="success";
			}else {
				msg="fail";
			}
		}
		return msg;
	}

	@Override
	public ResponseEntity<?> signInMobile(String mobile,String password) {
		EmployeeAuth findUserNameAndPassword = empAuthRepository.findByUsername(mobile);
		if (findUserNameAndPassword != null) {
			if (encoder.matches(password, findUserNameAndPassword.getPassword())) {
				findUserNameAndPassword.getUsername();
				String createJWT = createJWT(findUserNameAndPassword.getUsername());
				AssignResponse assignResponse = masterService.getAssignEmpNameDeptNameByMobile(findUserNameAndPassword.getUsername());
				return ResponseEntity.ok(new JwtResponse(createJWT, findUserNameAndPassword.getUsername(),
						assignResponse.getEmpName(),assignResponse.getEcode(),
						assignResponse.getDeptNmae(),assignResponse.getDeptCode(),
						assignResponse.getDefaultInTime(),assignResponse.getDefaultOutTime()));
			} else {
				return ResponseEntity.ok(new MessageResponse("invalidPassword"));
			}
		} else {
			return ResponseEntity.ok(new MessageResponse("invalidMobile"));
		}

	}
	
	private String createJWT(String userName) {

		// The JWT signature algorithm we will be using to sign the token
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);

		// We will sign our JWT with our ApiKey secret
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(key);
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

		// Let's set the JWT Claims
		String compact = Jwts.builder().setSubject((userName)).setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
				.signWith(SignatureAlgorithm.HS512, key).compact();

		// if it has been specified, let's add the expiration
		/*
		 * if (ttlMillis >= 0) { long expMillis = nowMillis + ttlMillis; Date exp = new
		 * Date(expMillis); builder.setExpiration(exp); }
		 */
		// Builds the JWT and serializes it to a compact, URL-safe string
		return compact;
	}

	

	

}
