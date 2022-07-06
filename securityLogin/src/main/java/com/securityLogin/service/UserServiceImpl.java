package com.securityLogin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.securityLogin.constants.Role;
import com.securityLogin.dto.UserDto;
import com.securityLogin.repository.UserEntityRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserEntityRepository userEntityRepository;
	
	@Override
	public Integer saveUser(UserDto userdto) {
		userdto.setPassword(new BCryptPasswordEncoder().encode(userdto.getPassword()));
		userdto.setAuthority(Role.USER.getRolename());
		
		return userEntityRepository.save(userdto.toEntity()).getId().intValue();
	}
	

}
