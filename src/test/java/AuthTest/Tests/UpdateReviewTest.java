package AuthTest.Tests;


import AuthTest.Models.ReviewData;
import org.junit.Assert;
import org.junit.Test;

public class UpdateReviewTest extends TestBase {
    @Test
    public void updateReview() {
        applicationManager.getNavigation().OpenStartPage();
        applicationManager.getLogin().Login(user);
        ReviewData review = new ReviewData("dune", "очень прикольный фильм");
        applicationManager.getNavigation().OpenPage("https://letterboxd.com/" + user.getUsername() + "/films/diary/");
        applicationManager.getReview().UpdateReview(review);
        applicationManager.getNavigation().OpenPage("https://letterboxd.com/" + user.getUsername() + "/films/reviews/");
        ReviewData newReview = applicationManager.getReview().GetCreatedReview();
        Assert.assertEquals(review.getReview(), newReview.getReview());
        applicationManager.getLogin().Logout();
    }
}