package sample;

import java.util.UUID;

public class BookReview {
    public UUID idBookReview;
    public String textOfBookReview;

    public BookReview(){
        this.idBookReview = UUID.randomUUID();
        textOfBookReview = "";
    }
    public BookReview(String review){
        this.idBookReview = UUID.randomUUID();
        textOfBookReview = review;
    }

    @Override
    public String toString() {
        return "\nBookReview{" +
                "\nidBookReview=" + idBookReview +
                ", \ntextOfBookReview='" + textOfBookReview + '\'' +
                '}';
    }
}
