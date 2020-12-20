package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class RegistrationWindow {
    public Visitor registration;
    TextField id;
    PasswordField password;
    Button reg;
    Stage stage;

    public RegistrationWindow() {
        this.id = new TextField();
        this.password = new PasswordField();
        reg = new Button("Зарегистрироваться");
        stage = new Stage();
        VBox root = new VBox();
        root.setSpacing(5);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(new Text("Логин"),
                id,
                new Text("Пароль"),
                password,
                reg);
        stage.setTitle("Регистрация");
        stage.setScene(new Scene(root,200,400));
        reg.setOnAction(e->{
            if(!id.getText().equals("") && !password.getText().equals("")) {
                this.saveId(id.getText());
                this.savePassword(password.getText());
                id.setText("");
                password.setText("");
                stage.close();
            }else {
                this.id.setText("Введите логин и пароль");
            }
        });
    }

    public void saveId(String id) {
        registration.saveID(id);
    }

    public void savePassword(String password) {
        registration.savePassword(password);
    }
}
