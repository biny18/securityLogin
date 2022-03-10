package com.securityLogin.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.securityLogin.entity.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long>{

	Collection<UserEntity> findByEmail(String email);
}
