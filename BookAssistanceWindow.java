package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BookAssistanceWindow {
    Stage parentWindowStage;
    public BookReviewWindow bookReviewWindow;
    public BookAvailabilityWindow bookAvailabilityWindow;
    public BookWindow bookWindow;

    Scene scene;
    Scene parentWindowScene;
    Button book;
    Button feedback;
    Button availability;
    Button back;

    public BookAssistanceWindow(){
        bookReviewWindow = new BookReviewWindow();
        bookAvailabilityWindow = new BookAvailabilityWindow();
        bookWindow = new BookWindow();
        book = new Button("Изменение информации о книге");
        availability = new Button("Изменение информации о наличии");
        feedback = new Button("Изменение отзыва о книге");
        back = new Button("Назад");
        VBox root = new VBox(book, availability, feedback, back);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        scene = new Scene(root,200,400);
        book.setOnAction(e->{
            bookWindow.bookChangeWindow.stage.show();
            bookWindow.bookChangeWindow.configureWindow();
        });
        feedback.setOnAction(e->{
            bookReviewWindow.stage.show();
            bookReviewWindow.configureAssistanceWindow();
        });
        availability.setOnAction(e->{
            bookAvailabilityWindow.stage.show();
            bookAvailabilityWindow.configureWindow();
        });
        back.setOnAction(e->{
            parentWindowStage.setScene(parentWindowScene);
        });
    }
}
