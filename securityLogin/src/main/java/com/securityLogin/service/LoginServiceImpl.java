package com.securityLogin.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.securityLogin.entity.UserEntity;
import com.securityLogin.repository.UserEntityRepository;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserEntityRepository userEntityRepository;
	
	@Override
	public UserEntity loadUserByUsername(String email) throws UsernameNotFoundException {
		final Collection<UserEntity> user = userEntityRepository.findByEmail(email);
		
		if(user.isEmpty()) {
			throw new UsernameNotFoundException("User with email " + email + " not found!");
		}
		return user.iterator().next();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}


}
