package AuthTest.Tests;
import AuthTest.Models.ReviewData;
import org.junit.Assert;
import org.junit.Test;

public class CreateReviewTest extends TestBase {
    @Test
    public void createReview() {
        applicationManager.getNavigation().OpenStartPage();
        applicationManager.getLogin().Login(user);
        ReviewData review = ReviewData.readFromFile("./TestData/review_create.xml");
//        ReviewData review = new ReviewData("dune", "прикольный фильм");
        applicationManager.getReview().CreateReview(review);
        applicationManager.getNavigation().OpenPage("https://letterboxd.com/" + TestBase.user.getUsername() + "/films/reviews/");
        ReviewData createdReview = applicationManager.getReview().GetCreatedReview();
        Assert.assertEquals(review.getFilmName().toLowerCase(), createdReview.getFilmName().toLowerCase());
        Assert.assertEquals(review.getReview(), createdReview.getReview());
        applicationManager.getLogin().Logout();
    }
}