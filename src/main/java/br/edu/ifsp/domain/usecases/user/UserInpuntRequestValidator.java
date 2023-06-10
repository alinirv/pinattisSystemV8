package br.edu.ifsp.domain.usecases.user;

import br.edu.ifsp.domain.entities.user.User;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

import java.util.Collections;

public class UserInpuntRequestValidator extends Validator<User> {
    @Override
    public Notification validate(User user) {
        Notification notification=new Notification();

        if (user == null){
            notification.addError("User is null");
            return notification;
        }
        if(nullOrEmpty(user.getNameUser())){
            notification.addError("Name is null or empty");
        }
        if(nullOrEmpty(Collections.singleton(user.getCpfUser()))){
            notification.addError("CPF is null or empty");
        }
        if(nullOrEmpty(user.getPasswordUser())){
            notification.addError("Password is null or empty");
        }
        if(nullOrEmpty(Collections.singleton(user.getTypeUser()))){
            notification.addError("Name is null or empty");
        }
        return notification;
    }
}
