import { useEffect, useState } from "react";
import { Navigate, useLocation } from "react-router-dom";

import NavBar from "@/components/NavBar";

import { ROUTES, getPathFromRoute } from "@/configs/routes";

import ViewProfilePanel from './ViewProfilePanel';
import ViewInventoryPanel from "./ViewUserInventoryPanel";


/* -------------------------------------------------------------------------- */
/*                                  COMPONENT                                 */
/* -------------------------------------------------------------------------- */
const UserInfo = () => {
  const [panel, setPanel] = useState<React.ReactElement | null>(null);
  const location = useLocation();

  // Sets the panel to be rendered based on the hash in the URL
  useEffect(() => {
    const { pathname, hash } = location;

    if (pathname === getPathFromRoute(ROUTES.USER_INFO)) {
      switch (hash) {
        case "#profile":
          setPanel(<ViewProfilePanel />);
          break;
        case "#inventory":
          setPanel(<ViewInventoryPanel />);
          break;
        default:
          setPanel(null);
          break;
      }
    }
  }, [location]);

  return (
    <div>
      <NavBar />

      {location.hash ? panel : <Navigate to={ROUTES.DASHBOARD} />}
    </div>
  );
};

export default UserInfo;
