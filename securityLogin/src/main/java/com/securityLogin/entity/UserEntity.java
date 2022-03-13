package com.securityLogin.entity;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Entity
public class UserEntity implements UserDetails{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(length = 100)
	private String email;
	
	@Column
	private String firstname;
	
	@Column
	private String lastname;
	
	@Column
	private String password;
	
	@Column
	private String authority;
	
	@Column(updatable=false)
	@CreatedDate
	private LocalDateTime createdDate;
	
	@Column(updatable=false)
	@LastModifiedDate
	private LocalDateTime modifiedDate;
	
	@Builder
	public UserEntity(Long id, String email, String firstname, String lastname, String password, String authority) {
		this.id = id;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.authority = authority;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	    Set<GrantedAuthority> authorities = new HashSet<>();
		authorities.add(new SimpleGrantedAuthority(this.authority));
        
	    return authorities;
	}

	@Override
	public String getUsername() {
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	

}
