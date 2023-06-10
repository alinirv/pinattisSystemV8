package br.edu.ifsp.domain.usecases.user;

import br.edu.ifsp.domain.entities.user.User;
import br.edu.ifsp.domain.entities.user.UserStatus;
import br.edu.ifsp.domain.usecases.utils.EntityAlreadyExistsException;
import br.edu.ifsp.domain.usecases.utils.EntityNotFoundException;

public class DisableUserUseCase {
    private UserDAO userDAO;

    public DisableUserUseCase(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public boolean update(User user){
        if (Session.getInstance().getCurrentUser().getTypeUser().isAdmin()) {
            String cpf = user.getCpfUser();
            if (cpf == null || userDAO.findOne(cpf).isEmpty())
                throw new EntityNotFoundException("User not Found");
            user.setStatusUser(UserStatus.INACTIVE);
            return userDAO.update(user);
        }
        throw new EntityAlreadyExistsException("Sorry, you do not have permission to perform this function on the system.");
    }
}