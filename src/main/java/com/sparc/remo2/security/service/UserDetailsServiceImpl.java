package com.sparc.remo2.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sparc.remo2.entity.AuthorityDO;
import com.sparc.remo2.repository.AuthRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	AuthRepository userRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		AuthorityDO auth = userRepository.findByUsername(username).get();
		if(auth != null && auth.isActive()) {
			return UserDetailsImpl.build(auth);
		}
		else {
			 throw new UsernameNotFoundException("username not found");
		}
		
	}
}
