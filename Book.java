package sample;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Book {
    public UUID idBook;
    public String name;
    public String author;
    public String translator;
    public int publishingYear;
    public String publishingOffice;
    public int pagesNumber;
    public int ageRating;
    public double rating;
    public boolean bookAvailability;
    public List<BookReview> bookReview;

    public Book(){
        this.idBook = UUID.randomUUID();
        this.name = "";
        this.author = "";
        this.translator = "";
        this.publishingYear = 0;
        this.publishingOffice = "";
        this.pagesNumber = 0;
        this.ageRating = 0;
        this.rating = 0;
        this.bookAvailability = false;
        this.bookReview = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Book{" +
                "\nidBook=" + idBook +
                ",\n name='" + name + '\'' +
                ",\n author='" + author + '\'' +
                ",\n translator='" + translator + '\'' +
                ",\n publishingYear=" + publishingYear +
                ",\n publishingOffice='" + publishingOffice + '\'' +
                ",\n pagesNumber=" + pagesNumber +
                ",\n ageRating=" + ageRating +
                ",\n rating=" + rating +
                ",\n bookAvailability=" + bookAvailability +
                ",\n bookReview=" + bookReview +
                '}';
    }
}
