import { createContext, ReactNode, useState } from 'react';

import styles from './ModalContext.module.scss';


const ModalContext = createContext<{
  modal: ReactNode,
  setModal: React.Dispatch<React.SetStateAction<ReactNode>>,
  clearModal: () => void,
}>({
  modal: null,
  setModal: () => {},
  clearModal: () => {},
});

export default ModalContext;


/* -------------------------------------------------------------------------- */
/*                                  COMPONENT                                 */
/* -------------------------------------------------------------------------- */
/**
 * Context provider for the modal component.
 * @returns {React.ReactElement} The modal provider.
 */
export const ModalProvider = (props: React.PropsWithChildren): React.ReactElement => {
  const [modal, setModal] = useState<ReactNode>(null);

  /**
   * Clears all states to their original values.
   */
  function clearModal() { setModal(null); }

  return (
    <ModalContext.Provider
      value={{
        modal,
        setModal,
        clearModal,
      }}
    >
      { (modal !== null) && (
        <div className={styles.Modal}>
          <button onClick={() => clearModal()} title="Close">X</button>

          <div className={styles.Info}>
            {modal}
          </div>
        </div>
      )}

      {props.children}
    </ModalContext.Provider>
  );
};
