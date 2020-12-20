package sample;

import java.util.ArrayList;
import java.util.UUID;

public class Administrator {
    public String id;
    public String password;
    public UUID idLibrary;

    public Administrator(String id, String password, UUID idLibrary){
        this.id = id;
        this.password = password;
        this.idLibrary = idLibrary;
    }

    public Administrator(String id, String password){
        this.id = id;
        this.password = password;
    }

    //methods
    public boolean verifyID(String id){
        return this.id.equals(id);
    }
    public boolean verifyPassword(String password){
        return this.password.equals(password);
    }
    public Book editBookInformation(Book book, String info){

        return book;
    }

    public Library editLibraryInformation(Library library, String info){
        return library;
    }

    public Book deleteBookReview(Book book){
        book.bookReview = new ArrayList<>();
        return book;
    }

    public Library deleteLibraryReview(Library library){
        library.libraryReview = new ArrayList<>();
        return library;
    }

    public Book editBookAvailability(Book book){
        book.bookAvailability = !book.bookAvailability;
        return book;
    }

    public int updateAmountOfFreeComputerSeats(Library library, int seats){
        int res = library.computerSeats - seats;
        library.computerSeats = seats;
        return Math.abs(res);
    }

    public int updateAmountOfFreeBookSeats(Library library, int seats){
        int res = library.bookSeats - seats;
        library.bookSeats = seats;
        return Math.abs(res);
    }
}
