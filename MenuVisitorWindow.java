package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuVisitorWindow {
    public LibraryVisitorWindow libraryVisitorWindow;
    public BookVisitorWindow bookVisitorWindow;
    Scene scene;
    Stage parentWindowStage;
    Button books;
    Button library;
    Button back;
    Scene parentWindowScene;
    public MenuVisitorWindow(){
        libraryVisitorWindow = new LibraryVisitorWindow();
        bookVisitorWindow = new BookVisitorWindow();
        books = new Button("Книги");
        library = new Button("Библиотеки");
        back = new Button("Назад");
        VBox root = new VBox(books, library, back);
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
        scene = new Scene(root,200,400);
        books.setOnAction(e->{
            bookVisitorWindow.parentWindowScene = scene;
            bookVisitorWindow.parentWindowStage = parentWindowStage;
            parentWindowStage.setScene(bookVisitorWindow.scene);
        });
        library.setOnAction(e->{
            libraryVisitorWindow.parentWindowScene = scene;
            libraryVisitorWindow.parentWindowStage = parentWindowStage;
            parentWindowStage.setScene(libraryVisitorWindow.scene);
        });
        back.setOnAction(e->{
            parentWindowStage.setScene(parentWindowScene);
        });
    }
}
