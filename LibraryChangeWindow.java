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

public class LibraryChangeWindow {
    public List<Library> libraryList;
    public Administrator administrator;
    Stage stage;
    ComboBox<String> libraries;
    VBox root;
    Button back;
    Button edit;
    TextField name;
    TextField number;
    TextField address;
    TextField workingTime;
    TextField phoneNumber;

    public LibraryChangeWindow() {
        libraryList = new ArrayList<>();
        stage = new Stage();
        libraries = new ComboBox<>();
        edit = new Button("Изменить");
        back = new Button("Назад");
        name = new TextField();
        number = new TextField();
        address = new TextField();
        workingTime = new TextField();
        phoneNumber = new TextField();
        root = new VBox(libraries,
                new HBox(new Text("Название: "), name),
                new HBox(new Text("Номер: "),number),
                new HBox(new Text("Адрес"),address),
                new HBox(new Text("Время работы:"),workingTime),
                new HBox(new Text("Номер телефона"),phoneNumber),
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
                name.setText(lib.name);
                number.setText(lib.number);
                address.setText(lib.address);
                workingTime.setText(lib.workingTime);
                phoneNumber.setText(lib.phoneNumber);
                root.getChildren().addAll(libraries,
                        new HBox(new Text("Название: "), name),
                        new HBox(new Text("Номер: "),number),
                        new HBox(new Text("Адрес"),address),
                        new HBox(new Text("Время работы:"),workingTime),
                        new HBox(new Text("Номер телефона"),phoneNumber),
                        edit,
                        back);
            }
        });
        edit.setOnAction(e->{
            Library lib = null;
            for (Library l : libraryList) {
                if (l.name.equals(libraries.getValue())) {
                    lib = l;
                }
            }
            if (lib != null) {
                root.getChildren().clear();
                String info = "";
                info += "name=" + name.getText();
                info += ",number=" + number.getText();
                info += ",address=" + address.getText();
                info += ",workingTime=" + workingTime.getText();
                info += ",phoneNumber=" + phoneNumber.getText();
                lib = administrator.editLibraryInformation(lib,info);
                name.setText(lib.name);
                number.setText(lib.number);
                address.setText(lib.address);
                workingTime.setText(lib.workingTime);
                phoneNumber.setText(lib.phoneNumber);
                root.getChildren().addAll(libraries,
                        new HBox(new Text("Название: "), name),
                        new HBox(new Text("Номер: "),number),
                        new HBox(new Text("Адрес"),address),
                        new HBox(new Text("Время работы:"),workingTime),
                        new HBox(new Text("Номер телефона"),phoneNumber),
                        edit,
                        back);
            }
        });
    }
}
