package sample;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Library {
    public UUID idLibrary;
    public String name;
    public String number;
    public String address;
    public String workingTime;
    public String phoneNumber;
    public int computerSeats;
    public int bookSeats;
    public List<LibraryReview> libraryReview;
    public List<Book> listOfBook;


    public Library(){
        this.idLibrary = UUID.randomUUID();
        this.name = "";
        this.number = "";
        this.address = "";
        this.workingTime = "";
        this.phoneNumber = "";
        this.computerSeats = 10;
        this.bookSeats = 10;
        this.libraryReview = new ArrayList<>();
        this.listOfBook = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Library{" +
                "\nidLibrary=" + idLibrary +
                ",\n name='" + name + '\'' +
                ",\n number='" + number + '\'' +
                ",\n address='" + address + '\'' +
                ",\n workingTime='" + workingTime + '\'' +
                ",\n phoneNumber='" + phoneNumber + '\'' +
                ",\n computerSeats=" + computerSeats +
                ",\n bookSeats=" + bookSeats +
                ",\n libraryReview=" + libraryReview +
                ",\n listOfBook=" + listOfBook +
                '}';
    }
}
