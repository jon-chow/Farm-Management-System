import { BrowserRouter as Router, Routes, Route, Navigate } from "react-router-dom";

import RequireAuth from "./features/auth/RequireAuth";

import LoginPage from './pages/LoginPage';
import DashboardPage from './pages/DashboardPage';
import FarmerActionsPage from "./pages/DashboardPage/FarmActionsPage";
import UserInfoPage from "./pages/DashboardPage/UserInfoPage";
import CompanyFunFactsPage from "./pages/DashboardPage/CompanyFunFactsPage";
import HousingPage from "./pages/DashboardPage/HousingPage";

import { ROUTES } from "./configs/routes";


/* -------------------------------------------------------------------------- */
/*                                  COMPONENT                                 */
/* -------------------------------------------------------------------------- */
/**
 * Renders the main application component.
 * @returns {React.ReactElement} The main application component.
 */
const App = (): React.ReactElement => {
  return (
    <div data-testid="app">
      <Router>
        <Routes>
          {/* Protected Routes */}
          <Route path="/" element={<RequireAuth allowedRoles={["owner", "admin", "farmer"]} />}>
            <Route path={ROUTES.DASHBOARD} element={<DashboardPage />} />
            <Route path={ROUTES.FARMER_ACTIONS} element={<FarmerActionsPage />} />
            <Route path={ROUTES.USER_INFO} element={<UserInfoPage />} />
            <Route path={ROUTES.COMPANY_FUN_FACTS} element={<CompanyFunFactsPage />} />
            <Route path={ROUTES.HOUSING}element={<HousingPage />} />
            <Route path="" element={<Navigate to={ROUTES.DASHBOARD} />} />
            <Route path="*" element={<Navigate to={ROUTES.DASHBOARD} />} />
          </Route>

          {/* Public Routes */}
          <Route path="/" element={<Navigate to={ROUTES.LOGIN} />} />
          <Route path={ROUTES.LOGIN} element={<LoginPage />} />
          <Route path="*" element={<Navigate to={ROUTES.LOGIN} />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
