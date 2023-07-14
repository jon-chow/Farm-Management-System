package com.server.dto;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.sql.Date;

@AllArgsConstructor
@Builder
@Getter
public class UserDto {
	@SerializedName("user_id")
	private final int userID;

	@SerializedName("username")
	private final String username;

	@SerializedName("password")
	private final String password;

	@SerializedName("first_name")
	private final String firstName;

	@SerializedName("last_name")
	private final String lastName;

	@SerializedName("role")
	private final int role;

	@SerializedName("last_login")
	private final Date lastLogin;
}
