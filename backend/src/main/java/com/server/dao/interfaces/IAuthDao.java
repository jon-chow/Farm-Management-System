package com.server.dao.interfaces;

public interface IAuthDao {

    // TODO: encrypt password
    /**
     * Searches through the db and returns whether the specified username + password pair exists.
     * @param username
     * @param password
     * @return
     */
    public boolean doesAccountExist(String username, String password);

    /**
     * Returns the existing account id of the particular username + password pair.
     * @param username
     * @param password
     * @return
     *      a valid postive id - if found
     *      -1                 - if not found
     */
    public int getUserId(String username, String password);

}
