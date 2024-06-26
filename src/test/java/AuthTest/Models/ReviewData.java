package AuthTest.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;


import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

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
    public static List<ReviewData> readFromFileAsList(String filename) {
        List<ReviewData> reviewData = null;
        try {
            XmlMapper xmlMapper = new XmlMapper();

            // read file and put contents into the string
            String readContent = new String(Files.readAllBytes(Paths.get(filename)));

            // deserialize from the XML into a Phone object
            reviewData = xmlMapper.readValue(readContent, new TypeReference<List<ReviewData>>() {});
        } catch (IOException e) {
            // handle the exception
        }
        return reviewData;
    }
}