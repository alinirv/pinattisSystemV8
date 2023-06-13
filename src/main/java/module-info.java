module br.edu.ifsp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens br.edu.ifsp.application.controller to javafx.fxml;
    opens br.edu.ifsp.application.views to javafx.fxml;
    opens br.edu.ifsp.domain.entities.user to javafx.base;
    opens br.edu.ifsp.domain.entities.room to javafx.base;
    opens br.edu.ifsp.domain.entities.category to javafx.base;
    opens br.edu.ifsp.domain.entities.booking to javafx.base;
    opens br.edu.ifsp.domain.entities.transaction to javafx.base;
    opens br.edu.ifsp.domain.entities.cashier to javafx.base;
    opens br.edu.ifsp.domain.entities.product to javafx.base;

    exports br.edu.ifsp.application.views;
    exports br.edu.ifsp.application.controller;
}