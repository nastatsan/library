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

public class BookWindow {
    public Visitor visitor;
    public BookChangeWindow bookChangeWindow;
    public List<Book> bookList;
    Stage stage;
    ComboBox<String> books;
    VBox root;
    Button back;

    public BookWindow() {
        bookChangeWindow = new BookChangeWindow();
        bookList = new ArrayList<>();
        stage = new Stage();
        books = new ComboBox<>();
        back = new Button("Назад");
        root = new VBox(books, back);
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
        stage.setTitle("ПУБЛИЧНАЯ БИБЛИОТЕКА\nраздел информации о книге");
        stage.setScene(new Scene(root, 400, 600));
        back.setOnAction(e -> {
            stage.close();
        });
    }

    public void configureWindow() {
        for (Book book : bookList) {
            books.getItems().add(book.name);
        }
        books.setOnAction(e -> {
            Book book = null;
            for (Book b : bookList) {
                if (b.name.equals(books.getValue())) {
                    book = b;
                }
            }
            if (book != null) {
                root.getChildren().clear();
                root.getChildren().addAll(books,
                        new Text(book.toString()),
                        back);
            }
        });
    }
}
