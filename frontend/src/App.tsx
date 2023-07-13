import { useEffect } from "react";
import { BrowserRouter as Router, Routes, Route, Navigate, useLocation } from "react-router-dom";

import RequireAuth from "./app/auth/RequireAuth";

import LoginPage from './pages/LoginPage';
import DashboardPage from './pages/DashboardPage';
import FarmerActionsPage from "./pages/DashboardPage/FarmActionsPage";
import UserInfoPage from "./pages/DashboardPage/UserInfoPage";
import CompanyFunFactsPage from "./pages/DashboardPage/CompanyFunFactsPage";
import HousingPage from "./pages/DashboardPage/HousingPage";

import { ROUTES, getRouteFromPath, getPathFromRoute } from "./configs/routes";


/* -------------------------------------------------------------------------- */
/*                                  COMPONENT                                 */
/* -------------------------------------------------------------------------- */
/**
 * Routes for the application.
 * @returns The application routes.
 */
const AppRoutes = (): React.ReactElement => {
	const { pathname } = useLocation();

  // Update the title when the route changes.
	useEffect(() => {
		const route = getRouteFromPath(pathname);
		if (route)
      document.title = route.title + " | Farm Management System";
	}, [pathname]);

  return (
    <Routes>
      {/* Protected Routes */}
      <Route path="/" element={<RequireAuth allowedRoles={["owner", "admin", "farmer"]} />}>
        <Route path={getPathFromRoute(ROUTES.DASHBOARD)} element={<DashboardPage />} />
        <Route path={getPathFromRoute(ROUTES.FARMER_ACTIONS)} element={<FarmerActionsPage />} />
        <Route path={getPathFromRoute(ROUTES.USER_INFO)} element={<UserInfoPage />} />
        <Route path={getPathFromRoute(ROUTES.COMPANY_FUN_FACTS)} element={<CompanyFunFactsPage />} />
        <Route path={getPathFromRoute(ROUTES.HOUSING)} element={<HousingPage />} />
        <Route path="" element={<Navigate to={getPathFromRoute(ROUTES.DASHBOARD)} />} />
        <Route path="*" element={<Navigate to={getPathFromRoute(ROUTES.DASHBOARD)} />} />
      </Route>

      {/* Public Routes */}
      <Route path="/" element={<Navigate to={getPathFromRoute(ROUTES.LOGIN)} />} />
      <Route path={getPathFromRoute(ROUTES.LOGIN)} element={<LoginPage />} />
      <Route path="*" element={<Navigate to={getPathFromRoute(ROUTES.LOGIN)} />} />
    </Routes>
  );
}

/**
 * Renders the main application component.
 * @returns The main application component.
 */
const App = (): React.ReactElement => {
  return (
    <div data-testid="app">
      <Router>
        <AppRoutes />
      </Router>
    </div>
  );
}

export default App;
