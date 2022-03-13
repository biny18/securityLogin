package com.securityLogin.dto;

import java.time.LocalDateTime;

import com.securityLogin.entity.UserEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
	
	private Long id;
	
	private String email;
	
	private String firstname;
	
	private String lastname;
	
	private String password;
	
	private String authority;
	
	private LocalDateTime createdDate;
	
	private LocalDateTime modifiedDate;
	
	@Builder
	public UserDto (Long id, String email, String firstname, String lastname, String password, LocalDateTime createdDate, LocalDateTime modifiedDate, String authority) {
		this.id = id;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.authority = authority;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}
	
	public UserEntity toEntity() {
		UserEntity build = UserEntity.builder()
				.id(id)
				.email(email)
				.firstname(firstname)
				.lastname(lastname)
				.password(password)
				.authority(authority)
				.build();
		return build;
	}

}
