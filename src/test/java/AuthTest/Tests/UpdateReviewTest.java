package AuthTest.Tests;


import AuthTest.Models.ReviewData;
import org.junit.Assert;
import org.junit.Test;

public class UpdateReviewTest extends AuthBase {
    @Test
    public void updateReview() {
        ReviewData review = ReviewData.readFromFile("./TestData/review_update.xml");
        applicationManager.getNavigation().OpenPage("https://letterboxd.com/" + user.getUsername() + "/films/diary/");
        applicationManager.getReview().UpdateReview(review);
        applicationManager.getNavigation().OpenPage("https://letterboxd.com/" + user.getUsername() + "/films/reviews/");
        ReviewData newReview = applicationManager.getReview().GetCreatedReview();
        Assert.assertEquals(review.getReview(), newReview.getReview());
    }
}
