package com.server.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.sql.Date;

@AllArgsConstructor
@Builder
@Getter
public class UserModel {
	private final int userID;
	private final String username;
	private final String password;
	private final String firstName;
	private final String lastName;
	private final String[] roles;
	private final Date lastLogin;
}
