import { useEffect, useState } from 'react';
import { Navigate, useLocation } from 'react-router-dom';
import styled from 'styled-components';

import NavBar from '@components/NavBar';

import {
  DASHBOARD_PATHNAME,
  FARMER_ACTIONS_PATHNAME,
} from '@src/config/routes';


/* -------------------------------------------------------------------------- */
/*                                   STYLING                                  */
/* -------------------------------------------------------------------------- */
const StyledTendFields = styled.div`
  color: #fff;
  text-align: center;

  main {
    display: flex;
    flex-direction: row;
    gap: 0.5rem;
    min-height: 50vh;
    margin: 1rem 2rem;
  }

  .ControlPanel {
    display: flex;
    justify-content: center;
    width: 50%;
    height: 80vh;
    border-radius: 5px;
    border: 1px solid #fff;
    background-color: rgba(0, 0, 0, 0.1);
    overflow-x: none;
    transition: 0.2s ease;

    &:hover {
      background: rgba(0, 0, 0, 0.2);
      transition: 0.2s ease;
    }
  }

  .DisplayPanel {
    display: flex;
    justify-content: center;
    width: 100%;
    height: 80vh;
    border-radius: 5px;
    border: 1px solid #fff;
    background-color: rgba(0, 0, 0, 0.1);
    overflow-x: none;
    transition: 0.2s ease;

    &:hover {
      background: rgba(0, 0, 0, 0.2);
      transition: 0.2s ease;
    }
  }
`;

/* -------------------------------------------------------------------------- */
/*                                  COMPONENT                                 */
/* -------------------------------------------------------------------------- */
/**
 * Renders the 'Tend Fields' panel of Farmer Actions
 */
const TendFieldsPanel = () => {
  return (
    <StyledTendFields>
      <main>
        {/* CONTROL PANEL */}
        <div className="ControlPanel">
          <h2>Control Panel</h2>
        </div>

        {/* DISPLAY PANEL */}
        <div className="DisplayPanel">
          <h2>Display Panel</h2>

        </div>
      </main>
    </StyledTendFields>
  );
};

/**
 * Renders the 'Nurture Animals' panel of Farmer Actions
 */
const NurtureAnimalsPanel = () => {
  return (
    <>
      Nurture Animals
    </>
  );
};

/**
 * Renders the 'Sell Products' panel of Farmer Actions
 */
const SellProductsPanel = () => {
  return (
    <>
      Sell Products
    </>
  );
};

/**
 * Renders the 'Manage Facilities' panel of Farmer Actions
 */
const ManageFacilitiesPanel = () => {
  return (
    <>
      Manage Facilities
    </>
  );
};


const FarmerActions = () => {
  const [panel, setPanel] = useState<React.ReactElement | null>(null);
  const location = useLocation();
  
  // Sets the panel to be rendered based on the hash in the URL
  useEffect(() => {
    const { pathname, hash } = location;
    
    if (pathname === FARMER_ACTIONS_PATHNAME) {
      switch (hash) {
        case '#tend-fields':
          setPanel(<TendFieldsPanel />);
          break;
        case '#nurture-animals':
          setPanel(<NurtureAnimalsPanel />);
          break;
        case '#sell-products':
          setPanel(<SellProductsPanel />);
          break;
        case '#manage-facilities':
          setPanel(<ManageFacilitiesPanel />);
          break;
        default:
          setPanel(null);
          break;
      };
    };
  }, [location]);

  return (
    <div>
      <NavBar />
      
      { location.hash ? panel : <Navigate to={DASHBOARD_PATHNAME} />}
    </div>
  );
}

export default FarmerActions;