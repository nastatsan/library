package sample;

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
        return new Book();
    }

    public Library editLibraryInformation(Library library, String info){
        return new Library();
    }

    public Book deleteBookReview(Book book){
        return new Book();
    }

    public Library deleteLibraryReview(Library library){
        return new Library();
    }

    public Book editBookAvailability(Book book){
        return new Book();
    }

    public int updateAmountOfFreeComputerSeats(Library library, int seats){
        return 0;
    }

    public int updateAmountOfFreeBookSeats(Book book, int seats){
        return 0;
    }
}
