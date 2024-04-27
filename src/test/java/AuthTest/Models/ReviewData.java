package AuthTest.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReviewData {
    @JsonProperty("filmName")
    String filmName;
    @JsonProperty("review")
    String review;
    public ReviewData() {}

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
    public static ReviewData readFromFile(String filename) {
        ReviewData reviewData = null;
        try {
            XmlMapper xmlMapper = new XmlMapper();

            // read file and put contents into the string
            String readContent = new String(Files.readAllBytes(Paths.get(filename)));

            // deserialize from the XML into a Phone object
            reviewData = xmlMapper.readValue(readContent, ReviewData.class);
        } catch (IOException e) {
            // handle the exception
        }
        return reviewData;
    }
}