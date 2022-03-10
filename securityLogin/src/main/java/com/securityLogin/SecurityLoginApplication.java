package com.securityLogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SecurityLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityLoginApplication.class, args);
	}

}
