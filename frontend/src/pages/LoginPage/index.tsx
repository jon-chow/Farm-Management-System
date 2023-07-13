import { useState, useEffect, useContext } from 'react';
import { GiWheat } from 'react-icons/gi';

import { useLoginMutation } from '@/features/auth/auth.api.slice';

import BackgroundContext from '@/contexts/BackgroundContext';

import BackgroundImg from '@/assets/backgrounds/background2.png';

import styles from './index.module.scss';


/* -------------------------------------------------------------------------- */
/*                                  COMPONENT                                 */
/* -------------------------------------------------------------------------- */
/**
 * Renders the login page.
 * @returns {React.ReactElement} The login page.
 */
const LoginPage = (): React.ReactElement => {
  const [username, setUsername] = useState<string>('');
  const [password, setPassword] = useState<string>('');

  const { setBackground } = useContext(BackgroundContext);

  const [login] = useLoginMutation();

  /**
   * Handles the login process.
   * TODO: Complete when backend is ready.
   * @async
   */
  async function handleLogin(): Promise<void> {
    try {
      const response = await login({ username, password });

      window.alert("Logged in successfully!");
      document.location.href = '/dashboard';
    } catch (error) {
      window.alert(`Login failed: ${(error as Error).message}`);
    }
  }

  /**
   * Redirects to dashboard if user is already logged in.
   * TODO: Change this when backend is ready.
   */
  useEffect(() => {
    setBackground(BackgroundImg);
    if (sessionStorage.getItem('user-fms'))
      document.location.href = '/dashboard';
  }, []);

  return (
    <div className={styles.LoginPage}>
      <h1>Farm Management System&trade; Login</h1>
      <h3>The best way to control and manage your farm!</h3>
      <GiWheat className={styles.WheatIcon} />

      <form className={styles.LoginForm}>
        <div>
          <label htmlFor="user">Username</label>
          <input
            type="text"
            id="user"
            name="user"
            defaultValue=""
            onChange={(e) => { setUsername(e.target.value); }}
          />
        </div>

        <div>
          <label htmlFor="pass">Password</label>
          <input
            type="password"
            id="pass"
            name="pass"
            defaultValue=""
            onChange={(e) => { setPassword(e.target.value); }}
          />
        </div>

        <button
          type="button"
          onClick={handleLogin as () => void}
        >
          Login
        </button>
      </form>
    </div>
  );
}

export default LoginPage;
