package AuthTest.Tests;
import AuthTest.Models.ReviewData;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CreateReviewTest extends AuthBase {
    @Test
    public void createReview() {
        List<ReviewData> reviews = ReviewData.readFromFileAsList("./TestData/reviewCreateList.xml");
        reviews.forEach((review) -> {
            applicationManager.getReview().CreateReview(review);
            applicationManager.getNavigation().OpenPage("https://letterboxd.com/" + TestBase.user.getUsername() + "/films/reviews/");
            ReviewData createdReview = applicationManager.getReview().GetCreatedReview();
            Assert.assertEquals(review.getFilmName().toLowerCase(), createdReview.getFilmName().toLowerCase());
            Assert.assertEquals(review.getReview(), createdReview.getReview());
        });
    }
}