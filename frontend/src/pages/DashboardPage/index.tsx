import { To } from 'react-router-dom';
import { GiBarn, GiFarmer, GiPerson, GiBroccoli } from 'react-icons/gi';

import { ROUTES } from '@/configs/routes';

import NavBar from '@/components/NavBar';
import { Link } from 'react-router-dom';

import styles from './index.module.scss';


/* -------------------------------------------------------------------------- */
/*                                  COMPONENT                                 */
/* -------------------------------------------------------------------------- */
interface Button {
  link: To;
  text: string;
  disabled?: boolean;
}

// Farmer Actions Buttons
const FARMER_ACTIONS_BUTTONS : Button[] = [
  {
    link: `${ROUTES.FARMER_ACTIONS}#tend-fields`,
    text: "Tend Fields",
    disabled: true
  },
  {
    link: `${ROUTES.FARMER_ACTIONS}#nurture-animals`,
    text: "Nurture Animals"
  },
  {
    link: `${ROUTES.FARMER_ACTIONS}#sell-products`,
    text: "Sell Products",
    disabled: true
  },
  {
    link: `${ROUTES.FARMER_ACTIONS}#manage-facilities`,
    text: "Manage Facilities",
    disabled: true
  }
];

// User Info Buttons
const USER_INFO_BUTTONS : Button[] = [
  {
    link: `${ROUTES.USER_INFO}#profile`,
    text: "View Profile",
    disabled: true
  },
  {
    link: `${ROUTES.USER_INFO}#inventory`,
    text: "View Inventory"
  }
];

// Company Fun Facts Buttons
const COMPANY_FUN_FACTS_BUTTONS : Button[] = [
  {
    link: `${ROUTES.COMPANY_FUN_FACTS}#company-info`,
    text: "View Company Info"
  }
];

// Housing Buttons
const HOUSING_BUTTONS : Button[] = [
  {
    link: `${ROUTES.HOUSING}#housing`,
    text: "View Housing",
    disabled: true
  },
  {
    link: `${ROUTES.HOUSING}#manage-housing`,
    text: "Manage Housing",
    disabled: true
  }
];


const MainPage = () => {
  return (
    <div className={styles.MainPage} data-testid="main-page">
      <NavBar />

      <main>
        <section className={styles.Section}>
          <h1><GiFarmer size="2rem" /> Farmer Actions</h1>

          {FARMER_ACTIONS_BUTTONS.map((button, index) => (
            <Link to={button.link} key={index}>
              <button className={styles.Button} disabled={button.disabled}>
                {button.text}
              </button>
            </Link>
          ))}
        </section>

        <section className={styles.Section}>
          <h1><GiPerson /> User Info</h1>

          {USER_INFO_BUTTONS.map((button, index) => (
            <Link to={button.link} key={index}>
              <button className={styles.Button} disabled={button.disabled}>
                {button.text}
              </button>
            </Link>
          ))}
        </section>
        
        <section className={styles.Section}>
          <h1><GiBroccoli /> Company Fun Facts</h1>
          
          {COMPANY_FUN_FACTS_BUTTONS.map((button, index) => (
            <Link to={button.link} key={index}>
              <button className={styles.Button} disabled={button.disabled}>
                {button.text}
              </button>
            </Link>
          ))}
        </section>
        
        <section className={styles.Section}>
          <h1><GiBarn /> Housing</h1>
          
          {HOUSING_BUTTONS.map((button, index) => (
            <Link to={button.link} key={index}>
              <button className={styles.Button} disabled={button.disabled}>
                {button.text}
              </button>
            </Link>
          ))}
        </section>
      </main>
    </div>
  );
}

export default MainPage;
