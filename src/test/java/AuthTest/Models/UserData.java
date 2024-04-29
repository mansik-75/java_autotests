package AuthTest.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UserData {
    @JsonProperty("username")
    String username;
    @JsonProperty("password")
    String password;

    public UserData() {}

    public UserData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public static UserData readFromFile(String filename) {
        UserData user = null;
        try {
            XmlMapper xmlMapper = new XmlMapper();

            // read file and put contents into the string
            String readContent = new String(Files.readAllBytes(Paths.get(filename)));

            // deserialize from the XML into a Phone object
            user = xmlMapper.readValue(readContent, UserData.class);
        } catch (IOException e) {
            // handle the exception
        }
        return user;
    }
}
