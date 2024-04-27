package AuthTest.Models;

public class ReviewData {
    String filmName;
    String review;
    public ReviewData(String filmName, String review) {
        this.filmName = filmName;
        this.review = review;
    }
    public String getFilmName() {
        return this.filmName;
    }
    public String getReview() {
        return this.review;
    }
}
