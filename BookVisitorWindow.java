package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BookVisitorWindow {
    public Visitor visitor;
    Stage parentWindowStage;
    public BookFeedbackWindow bookFeedbackWindow;
    public BookAvailabilityVisitorWindow bookAvailabilityVisitorWindow;
    public BookWindow bookWindow;
    Scene scene;
    Scene parentWindowScene;
    Button book;
    Button feedback;
    Button availability;
    Button back;

    public BookVisitorWindow(){
        bookFeedbackWindow = new BookFeedbackWindow();
        bookAvailabilityVisitorWindow = new BookAvailabilityVisitorWindow();
        bookWindow = new BookWindow();
        book = new Button("Просмотр информации о книге");
        availability = new Button("Просмотр информации о наличии");
        feedback = new Button("Добавление отзыва о книге");
        back = new Button("Назад");
        VBox root = new VBox(book, availability, feedback, back);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        scene = new Scene(root,200,400);
        book.setOnAction(e->{
            bookWindow.stage.show();
            bookWindow.configureWindow();
        });
        feedback.setOnAction(e->{
            bookFeedbackWindow.stage.show();
            bookFeedbackWindow.configureWindow();
        });
        availability.setOnAction(e->{
            bookAvailabilityVisitorWindow.stage.show();
            bookAvailabilityVisitorWindow.configureWindow();
        });
        back.setOnAction(e->{
            parentWindowStage.setScene(parentWindowScene);
        });
    }
}
