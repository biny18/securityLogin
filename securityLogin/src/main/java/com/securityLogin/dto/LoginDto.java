package com.securityLogin.dto;

import com.securityLogin.entity.UserEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginDto {
	private String email;
	
	private String password;
	
	@Builder
	public LoginDto (String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public UserEntity toEntity() {
		UserEntity build = UserEntity.builder()
				.email(email)
				.password(password)
				.build();
		return build;
	}

}
