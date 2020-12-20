package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class BookFeedbackWindow {
    public Visitor visitor;
    public List<Book> bookList;
    Stage stage;
    ComboBox<String> books;
    VBox root;
    Button back;
    Button review;
    HBox buttons;
    TextArea textArea;
    Button delete;
    TextField toDel;

    public BookFeedbackWindow() {
        bookList = new ArrayList<>();
        stage = new Stage();
        books = new ComboBox<>();
        back = new Button("Назад");
        review = new Button("Оставить отзыв");
        textArea = new TextArea();
        delete = new Button("Удалить");
        toDel = new TextField();
        buttons = new HBox(back,review);
        buttons.setSpacing(20);
        buttons.setAlignment(Pos.CENTER);
        root = new VBox(books, buttons);
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
        stage.setTitle("ПУБЛИЧНАЯ БИБЛИОТЕКА\nраздел отзывов о книге");
        stage.setScene(new Scene(root, 800, 600));
        back.setOnAction(e -> {
            stage.close();
        });
        review.setOnAction(e->{
            Book book = null;
            for (Book b : bookList) {
                if (b.name.equals(books.getValue())) {
                    book = b;
                }
            }
            if (book != null) {
                BookReview review = new BookReview();
                review.textOfBookReview = textArea.getText();
                book.bookReview.add(review);
                root.getChildren().clear();
                HBox text = new HBox();
                text.getChildren().addAll( new Text(book.bookReview.toString()), textArea);
                text.setAlignment(Pos.CENTER);
                text.setSpacing(5);
                root.getChildren().addAll(books,
                        text,
                        buttons);
                textArea.setText("");
            }
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
                HBox text = new HBox();
                text.getChildren().addAll( new Text(book.bookReview.toString()), textArea);
                text.setAlignment(Pos.CENTER);
                text.setSpacing(5);
                root.getChildren().addAll(books,
                        text,
                        buttons);
            }
        });
    }

}
