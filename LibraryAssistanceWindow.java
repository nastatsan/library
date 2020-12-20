package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LibraryAssistanceWindow {
    Stage parentWindowStage;
    public LibraryChangeWindow libraryChangeWindow;
    public LibraryFeedbackWindow libraryFeedbackWindow;
    public LibraryFullnessWindow libraryFullnessWindow;
    Scene scene;
    Scene parentWindowScene;
    Button libraryChange;
    Button feedback;
    Button fullness;
    Button back;

    public LibraryAssistanceWindow(){
        libraryChangeWindow = new LibraryChangeWindow();
        libraryFeedbackWindow = new LibraryFeedbackWindow();
        libraryFullnessWindow = new LibraryFullnessWindow();
        libraryChange = new Button("Изменение информации о билиотеке");
        fullness = new Button("Изменение информации о загруженности");
        feedback = new Button("Изменение отзыва о библиотеке");
        back = new Button("Назад");
        VBox root = new VBox(libraryChange, fullness,  feedback, back);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        scene = new Scene(root,200,400);
        libraryChange.setOnAction(e->{
            libraryChangeWindow.stage.show();
            libraryChangeWindow.configureWindow();
        });
        feedback.setOnAction(e->{
            libraryFeedbackWindow.stage.show();
            libraryFeedbackWindow.configureAssistanceWindow();
        });
        fullness.setOnAction(e->{
            libraryFullnessWindow.stage.show();
            libraryFullnessWindow.configureAssistantWindow();
        });
        back.setOnAction(e->{
            parentWindowStage.setScene(parentWindowScene);
        });
    }
}
