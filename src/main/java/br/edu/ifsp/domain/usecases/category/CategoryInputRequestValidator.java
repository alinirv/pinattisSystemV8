package br.edu.ifsp.domain.usecases.category;

import br.edu.ifsp.domain.entities.category.Category;
import br.edu.ifsp.domain.usecases.utils.Notification;
import br.edu.ifsp.domain.usecases.utils.Validator;

public class CategoryInputRequestValidator extends Validator<Category> {
    @Override
    public Notification validate(Category category) {
        Notification notification = new Notification();
        if (category == null) {
            notification.addError("Category is null");
            return notification;
        }

        if(nullOrEmpty(String.valueOf(category.getNameCategory()))){
            notification.addError("Name is null or empty");
        }
        if(nullOrEmpty(category.getRoomList())){
            notification.addError("Name is null or empty");
        }
        if(nullOrEmpty(category.getCategoryPrice().toString())){
            notification.addError("Name is null or empty");
        }
        if(nullOrEmpty(category.getCategoryStatus().toString())){
            notification.addError("Name is null or empty");
        }

        return notification;
    }

}
