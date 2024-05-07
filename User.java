package OOP_Project;

import java.util.Objects;

public class User {
    private int userId;
    private UserProperties userProperties;
    private boolean loggedIn;


    public User(int userId, String username, String password, String phoneNumber) {
        this.userId = userId;
        this.userProperties = new UserProperties();
        this.userProperties.addProperty("username", username);
        this.userProperties.addProperty("password", password);
        this.userProperties.addProperty("phoneNumber", phoneNumber);
        this.loggedIn = false;
    }


    public String getPhoneNumber() {
        return (String) userProperties.getProperty("phoneNumber");
    }

    public int getUserId() {
        return userId;
    }

    public String getPassword() {
        return (String) userProperties.getProperty("password");
    }

    public String getUsername() {
        return (String) userProperties.getProperty("username");
    }
    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void logIn() {
        this.loggedIn = true;
    }

    public void logOut() {
        this.loggedIn = false;
    }
    public UserProperties getUserProperties() {
        return userProperties;
    }

    public void setUserName(String username) {
        this.userProperties.addProperty("username",username);
    }
}
