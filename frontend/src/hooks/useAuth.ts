import { useSelector } from "react-redux";
import jwtDecode from "jwt-decode";

import { selectCurrentToken } from "@/features/auth/authSlice";


/**
 * Checks if user is authenticated and returns user data.
 * @returns {AuthData} User data.
 * TODO: implement this
 */
const useAuth = (): AuthData => {
	const token = useSelector(selectCurrentToken) as string | null;

	if (token) {
		const decoded: AuthData = jwtDecode(token);
		const { username, roles } = decoded;

		return { username, roles };
	}

	// TODO: change roles to empty array after
	return { username: "", roles: ["admin"] };
};

export default useAuth;
