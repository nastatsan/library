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

public class LibraryFeedbackWindow {
    public Administrator administrator;
    public Visitor visitor;
    public List<Library> libraryList;
    Stage stage;
    ComboBox<String> libraries;
    VBox root;
    Button back;
    Button review;
    Button delete;
    TextField toDel;
    HBox buttons;
    TextArea textArea;

    public LibraryFeedbackWindow() {
        libraryList = new ArrayList<>();
        stage = new Stage();
        libraries = new ComboBox<>();
        back = new Button("Назад");
        review = new Button("Оставить отзыв");
        textArea = new TextArea();
        buttons = new HBox(back,review);
        buttons.setSpacing(20);
        buttons.setAlignment(Pos.CENTER);
        toDel = new TextField();
        root = new VBox(libraries, buttons);
        delete = new Button("Удалить");
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
        stage.setTitle("ПУБЛИЧНАЯ БИБЛИОТЕКА\nраздел отзывов о библиотеке");
        stage.setScene(new Scene(root, 800, 600));
        back.setOnAction(e -> {
            stage.close();
        });
        review.setOnAction(e->{
            Library lib = null;
            for (Library l : libraryList) {
                if (l.name.equals(libraries.getValue())) {
                    lib = l;
                }
            }
            if (lib != null) {
                LibraryReview review = new LibraryReview();
                review.textOfLibraryReview = textArea.getText();
                lib.libraryReview.add(review);
                root.getChildren().clear();
                HBox text = new HBox();
                text.getChildren().addAll( new Text(lib.libraryReview.toString()), textArea);
                text.setAlignment(Pos.CENTER);
                text.setSpacing(5);
                root.getChildren().addAll(libraries,
                        text,
                        buttons);
                textArea.setText("");
            }
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
                root.getChildren().clear();
                HBox text = new HBox();
                text.getChildren().addAll( new Text(lib.libraryReview.toString()), textArea);
                text.setAlignment(Pos.CENTER);
                text.setSpacing(5);
                root.getChildren().addAll(libraries,
                        text,
                        buttons);
            }
        });
    }

    public void configureAssistanceWindow(){
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
                root.getChildren().clear();
                VBox review = new VBox();
                int i = 0;
                for(LibraryReview lr: lib.libraryReview){
                    i++;
                    review.getChildren().add(new Text( i + lr.toString()));
                }
                Library finalLib = lib;
                delete.setOnAction(q->{
                    finalLib.libraryReview.remove(Integer.parseInt(toDel.getText()) -1);
                    toDel.setText("");
                    root.getChildren().clear();
                    VBox rev = new VBox();
                    int it = 0;
                    for(LibraryReview lr: finalLib.libraryReview){
                        it++;
                        rev.getChildren().add(new Text( it + lr.toString()));
                    }
                    rev.setAlignment(Pos.CENTER);
                    rev.setSpacing(2);
                    HBox but = new HBox(back, delete);
                    but.setSpacing(10);
                    but.setAlignment(Pos.CENTER);
                    root.getChildren().addAll(libraries,
                            rev,
                            toDel,
                            but);
                });
                review.setAlignment(Pos.CENTER);
                review.setSpacing(2);
                HBox but = new HBox(back, delete);
                but.setSpacing(10);
                but.setAlignment(Pos.CENTER);
                root.getChildren().addAll(libraries,
                        review,
                        toDel,
                        but);
            }
        });
    }
}
