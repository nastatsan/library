package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class BookAvailabilityWindow {
    public Administrator administrator;
    public List<Library> libraryList;
    List<Book> bookList;
    Stage stage;
    ComboBox<String> libraries;
    ComboBox<String> books;
    VBox root;
    Button back;
    CheckBox exist;

    public BookAvailabilityWindow() {
        libraryList = new ArrayList<>();
        stage = new Stage();
        libraries = new ComboBox<>();
        books = new ComboBox<>();
        exist = new CheckBox("В наличии");
        back = new Button("Назад");
        root = new VBox(new Text("Библиотека"), libraries, new Text("Книга"), books, back);
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
        stage.setTitle("ПУБЛИЧНАЯ БИБЛИОТЕКА\nраздел информации о наличии книги");
        stage.setScene(new Scene(root, 400, 600));
        back.setOnAction(e -> {
            stage.close();
        });
    }

    public void configureWindow() {
        libraries.getItems().clear();
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
                books.getItems().clear();
                for (Book book : bookList) {
                    books.getItems().add(book.name);
                }
            }
        });
        books.setOnAction(e -> {
            Book book = null;
            for (Book b : bookList) {
                if (b.name.equals(books.getValue())) {
                    book = b;
                }
            }
            if (book != null) {
                root.getChildren().clear();
                exist.setSelected(book.bookAvailability);
                root.getChildren().addAll(new Text("Библиотека"),
                        libraries,
                        new Text("Книга"),
                        books,
                        exist,
                        back);
            }
        });
        exist.setOnAction(e -> {
            Book book = null;
            for (Book b : bookList) {
                if (b.name.equals(books.getValue())) {
                    book = b;
                }
            }
            if (book != null) {
                book = administrator.editBookAvailability(book);
                exist.setSelected(book.bookAvailability);
                root.getChildren().clear();
                root.getChildren().clear();
                exist.setSelected(book.bookAvailability);
                root.getChildren().addAll(new Text("Библиотека"),
                        libraries,
                        new Text("Книга"),
                        books,
                        exist,
                        back);
            }
        });
    }
}
