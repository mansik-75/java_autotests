package AuthTest.Models;

public class UserData {
    String username;
    String password;
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
}
