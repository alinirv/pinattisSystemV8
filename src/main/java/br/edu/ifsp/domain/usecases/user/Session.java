
package br.edu.ifsp.domain.usecases.user;

import br.edu.ifsp.domain.entities.user.User;

    public class Session {
        private static Session instance;
        private Session session;
        private User currentUser;

        private Session() {
        }

        public static synchronized Session getInstance() {
            if (instance == null) {
                instance = new Session();
            }
            return instance;
        }

        public Session getSession() {
            return session;
        }

        public void setCurrentUser(User user) {
            this.currentUser = user;
        }

        public User getCurrentUser() {
            return currentUser;
        }
    }

