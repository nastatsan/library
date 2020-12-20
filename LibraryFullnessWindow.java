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

public class LibraryFullnessWindow {
    public List<Library> libraryList;
    public Administrator administrator;
    public Visitor visitor;
    Stage stage;
    ComboBox<String> libraries;
    VBox root;
    Scene visitorScene;
    Scene assistanceScene;

    VBox assistanceRoot;
    TextField computerSeatsAmount;
    TextField bookSeatsAmount;
    Button edit;

    Button back;

    public LibraryFullnessWindow() {
        libraryList = new ArrayList<>();
        stage = new Stage();
        libraries = new ComboBox<>();
        back = new Button("Назад");
        root = new VBox(libraries, back);
        bookSeatsAmount = new TextField();
        computerSeatsAmount = new TextField();
        assistanceRoot = new VBox();
        edit = new Button("Изменить");
        assistanceRoot.setSpacing(10);
        assistanceRoot.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
        stage.setTitle("ПУБЛИЧНАЯ БИБЛИОТЕКА\nраздел информации о загруженности");
        visitorScene = new Scene(root, 400, 600);
        assistanceScene = new Scene(assistanceRoot, 400, 600);
        stage.setScene(visitorScene);
        back.setOnAction(e -> {
            stage.close();
            computerSeatsAmount.setText("");
            bookSeatsAmount.setText("");
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
                root.getChildren().addAll(libraries,
                        new HBox(new Text("Количество свободных компьютерных мест: " + lib.computerSeats)),
                        new HBox(new Text("Количество свободных читательских мест: " + lib.bookSeats)),
                        back);
            }
        });
    }

    public void configureAssistantWindow(){
        libraries.getItems().clear();
        for (Library lib : libraryList) {
            libraries.getItems().add(lib.name);
        }
        assistanceRoot.getChildren().clear();
        assistanceRoot.getChildren().addAll(libraries,
                new HBox(new Text("Количество свободных компьютерных мест: "), computerSeatsAmount),
                new HBox(new Text("Количество свободных читательских мест: "), bookSeatsAmount),
                edit,
                back);
        stage.setScene(assistanceScene);
        libraries.setOnAction(e->{
            Library lib = null;
            for (Library l : libraryList) {
                if (l.name.equals(libraries.getValue())) {
                    lib = l;
                }
            }
            if (lib != null) {
                computerSeatsAmount.setText(String.valueOf(lib.computerSeats));
                bookSeatsAmount.setText(String.valueOf(lib.bookSeats));
                Library finalLib = lib;
                edit.setOnAction(q->{
                    finalLib.computerSeats = Integer.parseInt(computerSeatsAmount.getText());
                    finalLib.bookSeats = Integer.parseInt(bookSeatsAmount.getText());
                });
                assistanceRoot.getChildren().clear();
                assistanceRoot.getChildren().addAll(libraries,
                        new HBox(new Text("Количество свободных компьютерных мест: "), computerSeatsAmount),
                        new HBox(new Text("Количество свободных читательских мест: "), bookSeatsAmount),
                        edit,
                        back);
            }
        });
    }
}
