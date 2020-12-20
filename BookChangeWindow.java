package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class BookChangeWindow {
    public List<Book> bookList;
    public Administrator administrator;
    Stage stage;
    ComboBox<String> books;
    VBox root;
    Button back;
    Button edit;
    TextField name;
    TextField translator;
    TextField publishingOffice;
    TextField author;
    TextField publishingYear;
    TextField pagesNumber;
    TextField ageRating;
    TextField rating;

    public BookChangeWindow() {
        bookList = new ArrayList<>();
        stage = new Stage();
        books = new ComboBox<>();
        edit = new Button("Изменить");
        back = new Button("Назад");
        name = new TextField();
        translator = new TextField();
        publishingOffice = new TextField();
        author = new TextField();
        publishingYear = new TextField();
        pagesNumber = new TextField();
        ageRating = new TextField();
        rating = new TextField();
        root = new VBox(books,
                new HBox(new Text("Название: "), name),
                new HBox(new Text("Переводчик: "), translator),
                new HBox(new Text("Издательство: "), publishingOffice),
                new HBox(new Text("Автор:"), author),
                new HBox(new Text("Год издания: "), publishingYear),
                new HBox(new Text("Количество страниц: "), pagesNumber),
                new HBox(new Text("Возрастной рейтинг:"), ageRating),
                new HBox(new Text("Читательский рейтинг: "), rating),
                edit,
                back);
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
        stage.setTitle("ПУБЛИЧНАЯ БИБЛИОТЕКА\nраздел информации о библиотеке");
        stage.setScene(new Scene(root, 400, 600));
        back.setOnAction(e -> {
            stage.close();
        });
    }

    public void configureWindow() {
        books.getItems().clear();
        for (Book book : bookList) {
            books.getItems().add(book.name);
        }
        books.setOnAction(e -> {
            Book book = null;
            for (Book l : bookList) {
                if (l.name.equals(books.getValue())) {
                    book = l;
                }
            }
            if (book != null) {
                root.getChildren().clear();
                name.setText(book.name);
                translator.setText(book.translator);
                publishingOffice.setText(book.publishingOffice);
                author.setText(book.author);
                publishingYear.setText(String.valueOf(book.publishingYear));
                pagesNumber.setText(String.valueOf(book.pagesNumber));
                ageRating.setText(String.valueOf(book.ageRating));
                rating.setText(String.valueOf(book.rating));
                root.getChildren().addAll(books,
                        new HBox(new Text("Название: "), name),
                        new HBox(new Text("Переводчик: "), translator),
                        new HBox(new Text("Издательство: "), publishingOffice),
                        new HBox(new Text("Автор:"), author),
                        new HBox(new Text("Год издания: "), publishingYear),
                        new HBox(new Text("Количество страниц: "), pagesNumber),
                        new HBox(new Text("Возрастной рейтинг:"), ageRating),
                        new HBox(new Text("Читательский рейтинг: "), rating),
                        edit,
                        back);
            }
        });
        edit.setOnAction(e->{
            Book book = null;
            for (Book l : bookList) {
                if (l.name.equals(books.getValue())) {
                    book = l;
                }
            }
            if (book != null) {
                root.getChildren().clear();
                String info = "";
                info += "name=" + name.getText();
                info += ",translator=" + translator.getText();
                info += ",publishingOffice=" + publishingOffice.getText();
                info += ",author=" + author.getText();
                info += ",publishingYear=" + publishingYear.getText();
                info += ",pagesNumber=" + pagesNumber.getText();
                info += ",ageRating=" + ageRating.getText();
                info += ",rating=" + rating.getText();
                book = administrator.editBookInformation(book,info);
                name.setText(book.name);
                translator.setText(book.translator);
                publishingOffice.setText(book.publishingOffice);
                author.setText(book.author);
                publishingYear.setText(String.valueOf(book.publishingYear));
                pagesNumber.setText(String.valueOf(book.pagesNumber));
                ageRating.setText(String.valueOf(book.ageRating));
                rating.setText(String.valueOf(book.rating));
                root.getChildren().addAll(books,
                        new HBox(new Text("Название: "), name),
                        new HBox(new Text("Переводчик: "), translator),
                        new HBox(new Text("Издательство: "), publishingOffice),
                        new HBox(new Text("Автор:"), author),
                        new HBox(new Text("Год издания: "), publishingYear),
                        new HBox(new Text("Количество страниц: "), pagesNumber),
                        new HBox(new Text("Возрастной рейтинг:"), ageRating),
                        new HBox(new Text("Читательский рейтинг: "), rating),
                        edit,
                        back);
            }
        });
    }
}
