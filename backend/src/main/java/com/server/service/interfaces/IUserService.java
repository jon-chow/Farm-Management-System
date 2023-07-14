package com.server.service.interfaces;

import java.util.List;

import com.server.dto.UserDto;

public interface IUserService {
    /**
     * Get list of all users.
     * @return List of user data transfer objects.
     */
    public List<UserDto> getUser();

	/**
	 * Get user based on userID.
	 * @param userID
	 * @return The user data transfer object.
	 */
	public UserDto getUser(int userID);

    /**
     * Update the user based on userID.
     * @param userDto
     */
    public UserDto updateUser(UserDto userDto, int userID);

	/**
	 * Patch the user based on userID.
	 * @param userDto
	 */
    public UserDto patchUser(UserDto userDto, int userID);

    /**
     * Insert a user from the user data transfer object.
	 * @param userDto
     */
    public UserDto insertUser(UserDto userDto);

	/**
	 * Delete a user based on userID.
	 * @param userID
	 */
    public void deleteUser(int userID);
}
