package sample;

import java.util.UUID;

public class LibraryReview {
    public UUID idLibraryReview;
    public String textOfLibraryReview;

    public LibraryReview(){
        this.idLibraryReview = UUID.randomUUID();
        textOfLibraryReview = "";
    }
    public LibraryReview(String review){
        this.idLibraryReview = UUID.randomUUID();
        textOfLibraryReview = review;
    }

    @Override
    public String toString() {
        return "\nLibraryReview{" +
                "\nidLibraryReview=" + idLibraryReview +
                ", \ntextOfLibraryReview='" + textOfLibraryReview + '\'' +
                '}';
    }
}
