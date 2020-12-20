package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class AuthorizerWindow {
    public Visitor authorizationByVisitor;
    public Administrator authorizationByAdministrator;
    List<Visitor> visitorList;
    public Administrator administrator;
    TextField id;
    PasswordField password;
    Button auth;
    Stage stage;

    public AuthorizerWindow() {
        this.id = new TextField();
        this.password = new PasswordField();
        visitorList = new ArrayList<>();
        auth = new Button("Авторизоваться");
        stage = new Stage();
        VBox root = new VBox();
        root.setSpacing(5);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(new Text("Логин"),
                id,
                new Text("Пароль"),
                password,
                auth);
        stage.setTitle("Авторизация");
        stage.setScene(new Scene(root,200,400));
        auth.setOnAction(e->{
            this.verifyId(id.getText());
            this.verifyPassword(password.getText());
            if(authorizationByVisitor == null && authorizationByAdministrator == null){
                id.setText("Неверный логин или пароль");
                password.setText("");
            } else {
                id.setText("");
                password.setText("");
                stage.close();
            }
        });
    }

    public void verifyId(String id){
        if(administrator.verifyID(id)){
            authorizationByAdministrator = administrator;
            return;
        } else authorizationByAdministrator = null;
        for(Visitor v: visitorList){
            if(v.verifyID(id)){
                authorizationByVisitor = v;
                return;
            }
        }
        authorizationByVisitor = null;
    }

    public void verifyPassword(String password){
        if(administrator.verifyPassword(password)){
            authorizationByAdministrator = administrator;
            return;
        } else authorizationByAdministrator = null;
        for(Visitor v: visitorList){
            if(v.verifyPassword(password)){
                authorizationByVisitor = v;
                return;
            }
        }
        authorizationByVisitor = null;
    }
}
