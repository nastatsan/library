package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class GraphicsUserInterface {
    public AuthorizerWindow authorizerWindow;
    public RegistrationWindow registrationWindow;
    public MenuWindow menuWindow;
    public MenuVisitorWindow menuVisitorWindow;
    Stage stage;
    Button auth;
    Button reg;
    Button exit;
    Scene mainScene;
    public GraphicsUserInterface(){
        authorizerWindow = new AuthorizerWindow();
        registrationWindow = new RegistrationWindow();
        menuWindow = new MenuWindow();
        menuVisitorWindow = new MenuVisitorWindow();
        stage = new Stage();
        stage.setTitle("Публичная библиотека");
        auth = new Button("Авторизация");
        reg = new Button("Регистрация");
        exit = new Button("Выход");
        VBox root = new VBox();
        auth.setOnAction(e->{
            authorizerWindow.authorizationByVisitor = null;
            authorizerWindow.authorizationByAdministrator = null;
            authorizerWindow.stage.show();
            authorizerWindow.stage.setOnHidden(q->{
                if(authorizerWindow.authorizationByAdministrator != null){
                    menuWindow.bookAssistanceWindow.bookAvailabilityWindow.administrator = authorizerWindow.authorizationByAdministrator;
                    menuWindow.bookAssistanceWindow.bookReviewWindow.administrator = authorizerWindow.authorizationByAdministrator;
                    menuWindow.bookAssistanceWindow.bookWindow.bookChangeWindow.administrator = authorizerWindow.authorizationByAdministrator;
                    menuWindow.libraryAssistanceWindow.libraryFullnessWindow.administrator = authorizerWindow.authorizationByAdministrator;
                    menuWindow.libraryAssistanceWindow.libraryChangeWindow.administrator = authorizerWindow.authorizationByAdministrator;
                    menuWindow.libraryAssistanceWindow.libraryFeedbackWindow.administrator = authorizerWindow.authorizationByAdministrator;
                    menuWindow.parentWindowScene = mainScene;
                    menuWindow.parentWindowStage = stage;
                    stage.setScene(menuWindow.scene);
                }else if(authorizerWindow.authorizationByVisitor != null){
                    menuVisitorWindow.bookVisitorWindow.bookAvailabilityVisitorWindow.visitor = authorizerWindow.authorizationByVisitor;
                    menuVisitorWindow.bookVisitorWindow.bookFeedbackWindow.visitor = authorizerWindow.authorizationByVisitor;
                    menuVisitorWindow.bookVisitorWindow.bookWindow.visitor = authorizerWindow.authorizationByVisitor;
                    menuVisitorWindow.libraryVisitorWindow.libraryFeedbackWindow.visitor = authorizerWindow.authorizationByVisitor;
                    menuVisitorWindow.libraryVisitorWindow.libraryFullnessWindow.visitor = authorizerWindow.authorizationByVisitor;
                    menuVisitorWindow.libraryVisitorWindow.libraryWindow.visitor = authorizerWindow.authorizationByVisitor;
                    menuVisitorWindow.parentWindowScene = mainScene;
                    menuVisitorWindow.parentWindowStage = stage;
                    stage.setScene(menuVisitorWindow.scene);
                }
            });
        });
        reg.setOnAction(e->{
            registrationWindow.stage.show();
            registrationWindow.stage.setOnHidden(q->{
                    menuVisitorWindow.bookVisitorWindow.bookAvailabilityVisitorWindow.visitor = authorizerWindow.authorizationByVisitor;
                    menuVisitorWindow.bookVisitorWindow.bookFeedbackWindow.visitor = authorizerWindow.authorizationByVisitor;
                    menuVisitorWindow.bookVisitorWindow.bookWindow.visitor = authorizerWindow.authorizationByVisitor;
                    menuVisitorWindow.libraryVisitorWindow.libraryFeedbackWindow.visitor = authorizerWindow.authorizationByVisitor;
                    menuVisitorWindow.libraryVisitorWindow.libraryFullnessWindow.visitor = authorizerWindow.authorizationByVisitor;
                    menuVisitorWindow.libraryVisitorWindow.libraryWindow.visitor = authorizerWindow.authorizationByVisitor;
                menuVisitorWindow.parentWindowScene = mainScene;
                menuVisitorWindow.parentWindowStage = stage;
                stage.setScene(menuVisitorWindow.scene);
            });
        });
        exit.setOnAction(e->{
            System.exit(0);
        });
        root.getChildren().addAll(reg,auth,exit);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        mainScene = new Scene(root,200,400);
        stage.setScene(mainScene);
    }

    public void mainMenu(){
        stage.show();
    }
}
