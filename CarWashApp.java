package OOP_Project;


import java.time.LocalDateTime;

public class CarWashApp {
    public static void main(String[] args) {
        //Create a user Service
        UserService userService=new UserService();
        //Create a user with register process. User1, User2 and User3
        User user1 = userService.registerUser("arda","123456","5338550905");
        User user2 = userService.registerUser("utkan","246805","5543467635");
        User user3 = userService.registerUser("emirali","135794","5437689345");
        System.out.println("************************************************");
        //Login for both users
        userService.loginUser("arda","123456");
        userService.loginUser("utkan","246805");
        // Wrong password for emirali
        userService.loginUser("emirali","246805");
        System.out.println("************************************************");
        // Check that emirali is logIn ?
        if(user3.isLoggedIn())
            System.out.println("Emirali is in system!");
        else
            System.out.println("Emirali is not in system");
        //Add Emirali to system
        userService.loginUser("emirali","135794");
        if(user3.isLoggedIn())
            System.out.println("Emirali is in system!");
        else
            System.out.println("Emirali is not in system");
        System.out.println("************************************************");
        //Update information of utkan's username to utkanksr
        if(userService.updateUserInformation(user2.getUserId(),"utkanksr"))
            System.out.println("User2's new username is " + user2.getUsername());
        System.out.println("************************************************");
        // Create two Car wash center, Auto Oasis and Snappy Shine
        CarWashCenter center1=new CarWashCenter(40,"Auto Oasis");
        CarWashCenter center2=new CarWashCenter(40,"Snappy Shine");
        System.out.println("************************************************");
        // Add available time slots for center 1 and center 2
        //Center 1: 08/12/2023 12:00,14:00,16:00
        //Center 2: 08/12/2023 13:00,15:00,18:00
        center1.addAvailableTimeSlot(LocalDateTime.of(2023,12,8,12,0));
        center1.addAvailableTimeSlot(LocalDateTime.of(2023,12,8,14,0));
        center1.addAvailableTimeSlot(LocalDateTime.of(2023,12,8,16,0));

        center2.addAvailableTimeSlot(LocalDateTime.of(2023,12,8,13,0));
        center2.addAvailableTimeSlot(LocalDateTime.of(2023,12,8,15,0));
        center2.addAvailableTimeSlot(LocalDateTime.of(2023,12,8,18,0));

        // Create reservation to center1 for user1 and user2 at 12:00,16:00
        // Create reservation to center2 for user3 at 15:00

        Reservation res1=new Reservation(user1,center1,LocalDateTime.of(2023,12,8,12,0));
        Reservation res2=new Reservation(user2,center1,LocalDateTime.of(2023,12,8,16,0));

        Reservation res3=new Reservation(user3,center2,LocalDateTime.of(2023,12,8,15,0));

        center1.createReservation(res2);
        center1.createReservation(res1);
        center2.createReservation(res3);
        System.out.println("************************************************");
        //approve all reservations
        center1.approveReservation(res2);
        center1.approveReservation(res1);
        center2.approveReservation(res3);
        System.out.println("************************************************");
        //Display reservations for center1
        center1.displayReservations();
        //Try to approve the  user2's reservation again
        center1.approveReservation(res2);
        System.out.println("************************************************");
        //Clean the user2's car and look again the reservations for center1
        center1.cleanCar(res2);
        center1.displayReservations();
        System.out.println("************************************************");
        //Try to clean user3's car at center1
        center1.cleanCar(res3);
        System.out.println();
        //Get reservation info about emirali's reservation
        System.out.println( res3.getReservationInfo());

        //Testing Section
        System.out.println("************************************************");
        System.out.println("Testing section...");
        User testUser=new User(111111,"arda12345","20042004","5338550905");
        testUsername(testUser,"arda123","arda123");
        testPassword(testUser,"12345","12345");
        testNonExistentProperty(testUser,"gender");
    }
    public static void testUsername(User user,Object inputValue,Object expectedOutputValue){
        System.out.println("Testing starting for an existing user’s user name value.");
        user.getUserProperties().addProperty("username",inputValue);
        Object outputValue = user.getUserProperties().getProperty("username");
        if(expectedOutputValue.equals(outputValue)) {
            System.out.println("Test passed");
        } else{
            System.out.println("Test failed:" +outputValue+" didn’t match" +
                    expectedOutputValue);
        }
    }
    public static void testPassword(User user,Object inputValue,Object expectedOutputValue){
        System.out.println("Testing starting for an existing user’s password value.");
        user.getUserProperties().addProperty("password",inputValue);
        Object outputValue = user.getUserProperties().getProperty("password");
        if(expectedOutputValue.equals(outputValue)) {
            System.out.println("Test passed");
        } else{
            System.out.println("Test failed:" +outputValue+" didn’t match" +
                    expectedOutputValue);
        }
    }
    public static void testNonExistentProperty(User user,String propertyName){
        System.out.println("Testing starting for an existing user’s non existent value.");
        Object outputValue = user.getUserProperties().getProperty(propertyName);
        if(outputValue == null) {
            System.out.println("Test passed");
        } else{
            System.out.println("Test failed with value " + outputValue);
        }
    }

}
