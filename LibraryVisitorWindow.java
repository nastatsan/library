package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class LibraryVisitorWindow {
    public Visitor visitor;
    Stage parentWindowStage;
    public LibraryWindow libraryWindow;
    public LibraryFeedbackWindow libraryFeedbackWindow;
    public LibraryFullnessWindow libraryFullnessWindow;
    Scene scene;
    Scene parentWindowScene;
    Button library;
    Button feedback;
    Button fullness;
    Button back;

    public LibraryVisitorWindow(){
        libraryWindow = new LibraryWindow();
        libraryFeedbackWindow = new LibraryFeedbackWindow();
        libraryFullnessWindow = new LibraryFullnessWindow();
        library = new Button("Просмотр информации о билиотеке");
        fullness = new Button("Просмотр информации о загруженности");
        feedback = new Button("Добавление отзыва о библиотеке");
        back = new Button("Назад");
        VBox root = new VBox(library, fullness,  feedback, back);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        scene = new Scene(root,200,400);
        library.setOnAction(e->{
            libraryWindow.stage.show();
            libraryWindow.configureWindow();
        });
        feedback.setOnAction(e->{
            libraryFeedbackWindow.stage.show();
            libraryFeedbackWindow.configureWindow();
        });
        fullness.setOnAction(e->{
            libraryFullnessWindow.stage.show();
            libraryFullnessWindow.configureWindow();
        });
        back.setOnAction(e->{
            parentWindowStage.setScene(parentWindowScene);
        });
    }
}
