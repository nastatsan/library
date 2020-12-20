package sample;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        GraphicsUserInterface graphicsUserInterface = new GraphicsUserInterface();
        Administrator administrator = new Administrator("admin", "admin");
        Library library = new Library();
        library.name = "Library 1";
        administrator.idLibrary = library.idLibrary;
        Book book = new Book();
        book.name = "Book 1";
        library.listOfBook.add(book);
        graphicsUserInterface.menuVisitorWindow.libraryVisitorWindow.libraryFullnessWindow.libraryList.add(library);
        graphicsUserInterface.menuVisitorWindow.libraryVisitorWindow.libraryWindow.libraryList.add(library);
        graphicsUserInterface.menuVisitorWindow.libraryVisitorWindow.libraryFeedbackWindow.libraryList.add(library);
        graphicsUserInterface.menuVisitorWindow.bookVisitorWindow.bookWindow.bookList.add(book);
        graphicsUserInterface.menuVisitorWindow.bookVisitorWindow.bookAvailabilityVisitorWindow.libraryList.add(library);
        graphicsUserInterface.menuVisitorWindow.bookVisitorWindow.bookFeedbackWindow.bookList.add(book);
        graphicsUserInterface.menuWindow.libraryAssistanceWindow.libraryFullnessWindow.libraryList.add(library);
        graphicsUserInterface.menuWindow.libraryAssistanceWindow.libraryFeedbackWindow.libraryList.add(library);
        graphicsUserInterface.menuWindow.libraryAssistanceWindow.libraryChangeWindow.libraryList.add(library);
        graphicsUserInterface.menuWindow.bookAssistanceWindow.bookWindow.bookChangeWindow.bookList.add(book);
        graphicsUserInterface.menuWindow.bookAssistanceWindow.bookReviewWindow.bookList.add(book);
        graphicsUserInterface.menuWindow.bookAssistanceWindow.bookAvailabilityWindow.libraryList.add(library);
        Visitor visitor = new Visitor();
        visitor.saveID("nasta");
        visitor.savePassword("password");
        graphicsUserInterface.registrationWindow.registration = visitor;
        graphicsUserInterface.authorizerWindow.visitorList.add(visitor);
        graphicsUserInterface.authorizerWindow.administrator = administrator;
        graphicsUserInterface.mainMenu();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
