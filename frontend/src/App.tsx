import { BrowserRouter as Router, Routes, Route, Navigate } from "react-router-dom";

import RequireAuth from "./features/auth/RequireAuth";

import LoginPage from './pages/LoginPage';
// import ErrorPage from './pages/ErrorPage';
import DashboardPage from './pages/DashboardPage';
import FarmerActionsPage from "./pages/DashboardPage/FarmActionsPage";
import UserInfoPage from "./pages/DashboardPage/UserInfoPage";
import CompanyFunFactsPage from "./pages/DashboardPage/CompanyFunFactsPage";
import HousingPage from "./pages/DashboardPage/HousingPage";

import * as ROUTES from "./configs/routes";


/* -------------------------------------------------------------------------- */
/*                                  COMPONENT                                 */
/* -------------------------------------------------------------------------- */
/**
 * Renders the main application component.
 */
const App = (): React.ReactElement => {
  return (
    <div data-testid="app">
      <Router>
        <Routes>
          {/* Protected Routes */}
          <Route path="/" element={<RequireAuth allowedRoles={["owner", "admin", "farmer"]} />}>
            <Route path={ROUTES.DASHBOARD_PATHNAME} element={<DashboardPage />} />
            <Route path={ROUTES.FARMER_ACTIONS_PATHNAME} element={<FarmerActionsPage />} />
            <Route path={ROUTES.USER_INFO_PATHNAME} element={<UserInfoPage />} />
            <Route path={ROUTES.COMPANY_FUN_FACTS_PATHNAME} element={<CompanyFunFactsPage />} />
            <Route path={ROUTES.HOUSING_PATHNAME}element={<HousingPage />} />
            <Route path="" element={<Navigate to={ROUTES.DASHBOARD_PATHNAME} />} />
            <Route path="*" element={<Navigate to={ROUTES.DASHBOARD_PATHNAME} />} />
          </Route>

          {/* Public Routes */}
          <Route path="/" element={<Navigate to={ROUTES.LOGIN_PATHNAME} />} />
          <Route path={ROUTES.LOGIN_PATHNAME} element={<LoginPage />} />
          <Route path="*" element={<Navigate to={ROUTES.LOGIN_PATHNAME} />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
