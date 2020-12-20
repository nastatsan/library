package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class BookAvailabilityVisitorWindow {
    public Visitor visitor;
    public List<Library> libraryList;
    List<Book> bookList;
    Stage stage;
    ComboBox<String> libraries;
    ComboBox<String> books;
    VBox root;
    Button back;

    public BookAvailabilityVisitorWindow() {
        libraryList = new ArrayList<>();
        stage = new Stage();
        libraries = new ComboBox<>();
        books = new ComboBox<>();
        back = new Button("Назад");
        root = new VBox(new Text("Библиотека"),libraries,new Text("Книга"),books, back);
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
        stage.setTitle("ПУБЛИЧНАЯ БИБЛИОТЕКА\nраздел информации о наличии книги");
        stage.setScene(new Scene(root, 400, 600));
        back.setOnAction(e -> {
            stage.close();
        });
    }

    public void configureWindow() {
        for (Library lib : libraryList) {
            libraries.getItems().add(lib.name);
        }
        libraries.setOnAction(e -> {
            Library lib = null;
            for (Library l : libraryList) {
                if (l.name.equals(libraries.getValue())) {
                    lib = l;
                }
            }
            if (lib != null) {
                bookList = lib.listOfBook;
                for (Book book : bookList) {
                    books.getItems().add(book.name);
                }
            }
        });
        books.setOnAction(e->{
            Book book = null;
            for (Book b : bookList) {
                if (b.name.equals(books.getValue())) {
                    book = b;
                }
            }
            if(book != null) {
                root.getChildren().clear();
                root.getChildren().addAll(new Text("Библиотека"),
                        libraries,
                        new Text("Книга"),
                        books,
                        new Text(book.bookAvailability ? "Есть в наличии": "Нет в наличии"),
                        back);
            }
        });
    }
}
