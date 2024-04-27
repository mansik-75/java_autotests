package AuthTest.Services;

import AuthTest.ApplicationManager;
import AuthTest.Models.ReviewData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ReviewHelper extends HelpBase {
    public ReviewHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }
    public void CreateReview(ReviewData review) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement addNew = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-new-button")));
        addNew.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("frm-film-name"))).click();
        driver.findElement(By.id("frm-film-name")).sendKeys(review.getFilmName());
        driver.findElement(By.cssSelector(".ac_over")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("frm-review"))).click();
        driver.findElement(By.id("frm-review")).sendKeys(review.getReview());
        driver.findElement(By.id("frm-rewatch-label")).click();
        driver.findElement(By.id("diary-entry-submit-button")).click();
    }
    public ReviewData GetCreatedReview() {
        String filmName = driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/ul/li[1]/div[2]/h2/a")).getText();
        String review = driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/ul/li[1]/div[2]/div[2]/p")).getText();
        return new ReviewData(filmName, review);
    }
    public void UpdateReview(ReviewData newReview) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/section[2]/table/tbody/tr[1]/td[9]/span/span[1]/a"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("frm-review"))).clear();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("frm-review"))).click();
        driver.findElement(By.id("frm-review")).sendKeys(newReview.getReview());
        driver.findElement(By.id("diary-entry-submit-button")).click();
    }
}
