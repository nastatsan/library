package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MenuWindow {
    public LibraryAssistanceWindow libraryAssistanceWindow;
    public BookAssistanceWindow bookAssistanceWindow;
    Scene scene;
    Stage parentWindowStage;
    Button books;
    Button library;
    Button back;
    Scene parentWindowScene;
    public MenuWindow(){
        libraryAssistanceWindow = new LibraryAssistanceWindow();
        bookAssistanceWindow = new BookAssistanceWindow();
        books = new Button("Книги");
        library = new Button("Библиотеки");
        back = new Button("Назад");
        VBox root = new VBox(books, library, back);
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
        scene = new Scene(root,200,400);
        books.setOnAction(e->{
            bookAssistanceWindow.parentWindowScene = scene;
            bookAssistanceWindow.parentWindowStage = parentWindowStage;
            parentWindowStage.setScene(bookAssistanceWindow.scene);
        });
        library.setOnAction(e->{
            libraryAssistanceWindow.parentWindowScene = scene;
            libraryAssistanceWindow.parentWindowStage = parentWindowStage;
            parentWindowStage.setScene(libraryAssistanceWindow.scene);
        });
        back.setOnAction(e->{
            parentWindowStage.setScene(parentWindowScene);
        });
    }
}
