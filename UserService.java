package OOP_Project;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class UserService {
    private List<User> userList;
    public UserService() {
        this.userList = new ArrayList<>();
    }
    public User registerUser(String username, String password,String phoneNumber) {
        if (!isValidUsername(username)) {
            throw new IllegalArgumentException("Geçersiz kullanıcı adı");
        }
        if (!isValidPassword(password)) {
            throw new IllegalArgumentException("Geçersiz şifre");
        }
        if (!isValidPhoneNumber(phoneNumber)) {
            throw new IllegalArgumentException("Geçersiz telefon numarası");
        }

        System.out.println("The verification process is successful, the new user is created and added to the database...");
        User newUser = new User(generateUserId(), username, password, phoneNumber);
        System.out.println("User " + username + " added to database.");
        userList.add(newUser);

        return newUser;
    }
    public User loginUser(String username, String password) {
        User user = findUserByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Username and password are correct, " + username + " login in system successfully...");
            user.logIn();
            return user;
        } else if (!Objects.requireNonNull(user).getPassword().equals(password)){
            System.out.println("Password is wrong, please check..");
            return null;
        }
        else{
            System.out.println("Invalid username, please check..");
            return null;
        }
    }
    public boolean updateUserInformation(int userId, String newUsername, String newPhoneNumber) {
        for (User existingUser : userList) {
            if (existingUser.getUserId() == userId) {
                existingUser.getUserProperties().updatePropertyValue("username",newUsername);
                existingUser.getUserProperties().updatePropertyValue("phoneNumber",newPhoneNumber);
                System.out.println("user informations has been successfully updated");
                return true;
            }
        }
        System.out.println("Update failed, user not found..");
        return false;
    }
    public boolean updateUserInformation(int userId, String newUsername) {
        for (User existingUser : userList) {
            if (existingUser.getUserId() == userId) {
                existingUser.getUserProperties().updatePropertyValue("username",newUsername);
                System.out.println("username has been successfully updated");
                return true;
            }
        }
        System.out.println("Update failed, user not found..");
        return false;
    }

    private User findUserByUsername(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                System.out.println("User found!");
                return user;
            }
        }
        System.out.println("User not found..");
        return null;
    }

    private int generateUserId() {
        return (int) (Math.random() * 900000000) + 100000000;
    }


    private boolean isValidUsername(String username) {
        if(Pattern.matches("^[a-zA-Z0-9_-]{3,15}$", username)){
            System.out.println("Username validity check successful..");
            return true;
        }
        else{
            System.out.println("Invalid username, please try again...");
            return false;
        }
    }


    private boolean isValidPassword(String password) {
        if(password.length() >= 6){
            System.out.println("password validity check successful");
            return true;
        }
        else {
            System.out.println("invalid password, please try again...");
            return false;
        }
    }


    private boolean isValidPhoneNumber(String phoneNumber) {
        if(Pattern.matches("^\\d{10}$", phoneNumber)){
            System.out.println("Phone number validity check successful..");
            return true;
        }
        else {
            System.out.println("Invalid phone number, please try again...");
            return false;
        }
    }
}
