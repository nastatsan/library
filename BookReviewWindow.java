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

import java.util.ArrayList;
import java.util.List;

public class BookReviewWindow {
    public Administrator administrator;
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

    public BookReviewWindow() {
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
    }
    public void configureAssistanceWindow(){
        books.getItems().clear();
        for (Book lib : bookList) {
            books.getItems().add(lib.name);
        }
        books.setOnAction(e -> {
            Book lib = null;
            for (Book l : bookList) {
                if (l.name.equals(books.getValue())) {
                    lib = l;
                }
            }
            if (lib != null) {
                root.getChildren().clear();
                VBox review = new VBox();
                int i = 0;
                for(BookReview lr: lib.bookReview){
                    i++;
                    review.getChildren().add(new Text( i + lr.toString()));
                }
                Book finalLib = lib;
                delete.setOnAction(q->{
                    finalLib.bookReview.remove(Integer.parseInt(toDel.getText()) -1);
                    toDel.setText("");
                    root.getChildren().clear();
                    VBox rev = new VBox();
                    int it = 0;
                    for(BookReview lr: finalLib.bookReview){
                        it++;
                        rev.getChildren().add(new Text( it + lr.toString()));
                    }
                    rev.setAlignment(Pos.CENTER);
                    rev.setSpacing(2);
                    HBox but = new HBox(back, delete);
                    but.setSpacing(10);
                    but.setAlignment(Pos.CENTER);
                    root.getChildren().addAll(books,
                            rev,
                            toDel,
                            but);
                });
                review.setAlignment(Pos.CENTER);
                review.setSpacing(2);
                HBox but = new HBox(back, delete);
                but.setSpacing(10);
                but.setAlignment(Pos.CENTER);
                root.getChildren().addAll(books,
                        review,
                        toDel,
                        but);
            }
        });
    }
}
