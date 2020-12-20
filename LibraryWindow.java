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

public class LibraryWindow {
    public Visitor visitor;
    public List<Library> libraryList;
    Stage stage;
    ComboBox<String> libraries;
    VBox root;
    Button back;

    public LibraryWindow() {
        libraryList = new ArrayList<>();
        stage = new Stage();
        libraries = new ComboBox<>();
        back = new Button("Назад");
        root = new VBox(libraries, back);
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
        stage.setTitle("ПУБЛИЧНАЯ БИБЛИОТЕКА\nраздел информации о библиотеке");
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
                root.getChildren().clear();
                root.getChildren().addAll(libraries,
                        new Text(lib.toString()),
                        back);
            }
        });
    }
}
