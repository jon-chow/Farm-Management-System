import { Link } from 'react-router-dom';
import { GiFarmTractor } from 'react-icons/gi';

import useAuth from '@/hooks/useAuth';

import styles from './NavBar.module.scss';


/* -------------------------------------------------------------------------- */
/*                                  COMPONENT                                 */
/* -------------------------------------------------------------------------- */
const NavBar = (): React.ReactElement => {
  const currentUser: AuthData = useAuth();

  /**
   * Handles the logout button click event.
   * TODO: Implement logout functionality.
   */
  const handleLogout = (e: React.MouseEvent) => {
    e.preventDefault();
    console.log("Logout button clicked");
  };

  return (
    <div className={styles.NavBar}>
      <button
        className={styles.DashboardButton}
        type="button"
        title="Dashboard"
      >
        <Link to="/dashboard">
          <GiFarmTractor />
        </Link>
      </button>

      <h1>Farm Management System&trade;</h1>

      <button
        className={styles.NavButton}
        type="button"
        onClick={(e) => handleLogout(e)}
      >
        Log out
      </button>
    </div>
  );
}

export default NavBar;
