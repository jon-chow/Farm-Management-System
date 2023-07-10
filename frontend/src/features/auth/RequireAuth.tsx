import { useLocation, Navigate, Outlet, Location } from "react-router-dom";

import useAuth from "@/hooks/useAuth";


/* -------------------------------------------------------------------------- */
/*                                  COMPONENT                                 */
/* -------------------------------------------------------------------------- */
/**
 * Wrapper component that checks if the user is authenticated and has the required role to access the route.
 * @param {string[]} allowedRoles The roles that are allowed to access the route.
 */
const RequireAuth = ({ allowedRoles }: { allowedRoles: string[] }): JSX.Element => {
	const location: Location = useLocation();
	const { roles } = useAuth();

	return roles.some((role: string) => allowedRoles.includes(role)) ? 
		<Outlet /> :
		<Navigate to="/login" state={{ from: location }} replace />;
};

export default RequireAuth;
