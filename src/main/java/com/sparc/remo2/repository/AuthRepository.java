package com.sparc.remo2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sparc.remo2.entity.AuthorityDO;

public interface AuthRepository extends JpaRepository<AuthorityDO, Integer> {
	
	Optional<AuthorityDO> findByUsername(String username);
	
	Boolean existsByUsername(String username);
}

