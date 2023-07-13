import { createContext, useState } from 'react';

import BackgroundImg from '@/assets/backgrounds/background.png';

import styles from './BackgroundContext.module.scss';


const BackgroundContext = createContext<{
  background: string,
  setBackground: React.Dispatch<React.SetStateAction<string>>
}>({
  background: BackgroundImg,
  setBackground: () => {},
});

export default BackgroundContext;


/* -------------------------------------------------------------------------- */
/*                                  COMPONENT                                 */
/* -------------------------------------------------------------------------- */
/**
 * Context provider for the background image.
 * @returns {React.ReactElement} The background provider.
 */
export const BackgroundProvider = (props: React.PropsWithChildren): React.ReactElement => {
  const [background, setBackground] = useState(BackgroundImg);

  return (
    <BackgroundContext.Provider value={{ background, setBackground }}>
      <div className={styles.Background}>
        <img src={background} alt="" />
      </div>

      {props.children}
    </BackgroundContext.Provider>
  );
};
