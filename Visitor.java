package sample;

public class Visitor {
    public String id;
    public String password;

    public Visitor(String id, String password){
        this.id = id;
        this.password = password;
    }

    public Visitor(){
        this.id = "";
        this.password = "";
    }

    public boolean verifyID(String id){
        return this.id.equals(id);
    }
    public boolean verifyPassword(String password){
        return this.password.equals(password);
    }

    public void saveID(String id){
        this.id = id;
    }

    public void savePassword(String password){
        this.password = password;
    }

    public void giveBookFeedback(BookReview bookReview, String feedback){
        bookReview.textOfBookReview = feedback;
    }

    public void giveLibraryFeedback(LibraryReview libraryReview, String feedback){
        libraryReview.textOfLibraryReview = feedback;
    }

}
