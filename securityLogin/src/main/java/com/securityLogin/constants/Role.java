package com.securityLogin.constants;

public enum Role {
	USER("ROLE_USER"), ADMIN("ROLE_ADMIN");

	private String name;

	Role(String name) {
		this.name = name;
	}

	public String getRolename() {
		return this.name;
	}
	
}
