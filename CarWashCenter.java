package OOP_Project;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CarWashCenter {
    private int centerId;
    private String centerName;
    private List<LocalDateTime> availableTimeSlots;
    private List<Reservation> reservations;


    public CarWashCenter(int centerId, String centerName) {
        this.centerId = centerId;
        this.centerName = centerName;
        this.availableTimeSlots = new ArrayList<>();
        this.reservations = new ArrayList<>();
        System.out.println("The " + centerName + " Car Wash Center has been created successfully..");

    }

    public List<Reservation> getReservations() {
        return reservations;
    }
    public int getCenterId() {
        return centerId;
    }

    public void setCenterId(int centerId) {
        this.centerId = centerId;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }
    public List<LocalDateTime> getAvailableTimeSlots() {
        return availableTimeSlots;
    }

    public void setAvailableTimeSlots(List<LocalDateTime> availableTimeSlots) {
        this.availableTimeSlots = availableTimeSlots;
    }

    public void addAvailableTimeSlot(LocalDateTime timeSlot) {
        if(!availableTimeSlots.contains(timeSlot))
            availableTimeSlots.add(timeSlot);
        else
            System.out.println("Time slot is already in avaliable time slots list..");
    }
    public void createReservation(User user, LocalDateTime requestedTime) {
        if (availableTimeSlots.contains(requestedTime)) {
            Reservation newReservation = new Reservation(user, this, requestedTime);
            reservations.add(newReservation);
            availableTimeSlots.remove(requestedTime);
            System.out.println("Reservation created successfully for "  + centerName + " Wash Center."  + "Reservation ID: " + newReservation.getReservationId() + ". The owner of reservation is " + user.getUsername());
        } else {
            System.out.println("Sorry, the selected time is not available.");
        }
    }
    public void createReservation(Reservation reservation){
        if(availableTimeSlots.contains(reservation.getReservationTime())){
            reservations.add(reservation);
            availableTimeSlots.remove(reservation.getReservationTime());
            System.out.println("Reservation created successfully for "  + centerName + " Wash Center."  + "Reservation ID: " + reservation.getReservationId() + ". The owner of reservation is " + reservation.getUser().getUsername());
        }
        else{
            System.out.println("Sorry, the selected time is not available.");
        }

    }
    public void approveReservation(Reservation reservation) {
        if (reservations.contains(reservation) && reservation.getStatus() == ReservationStatus.PENDING) {
            reservation.setStatus(ReservationStatus.CONFIRMED);
            System.out.println("Reservation confirmed for " + reservation.getUser().getUsername() + " in " + reservation.getCarWashCenter().getCenterName() + ". Reservation ID: " + reservation.getReservationId());
        } else {
            System.out.println("The reservation could not be confirmed because no such reservation exists.");
        }
    }

    public void rejectReservation(Reservation reservation) {
        if (reservations.contains(reservation) && reservation.getStatus() == ReservationStatus.PENDING) {
            reservation.setStatus(ReservationStatus.REJECTED);
            System.out.println("Reservation rejected for " + reservation.getUser().getUsername() + " in " + reservation.getCarWashCenter().getCenterName() + ". Reservation ID: " + reservation.getReservationId());
        } else {
            System.out.println("The reservation could not be rejected because no such reservation exists.");
        }
    }
    public void cleanCar(Reservation reservation) {
        if (reservations.contains(reservation) && reservation.getStatus() == ReservationStatus.CONFIRMED) {
            System.out.println("The " + reservation.getUser().getUsername() + "'s vehicle has been cleaned. Reservation ID: " + reservation.getReservationId());
            reservations.remove(reservation); // Rezervasyonu kaldır
        } else {
            System.out.println("The " + reservation.getUser().getUsername() + "'s Vehicle could not be cleaned, Reservation Not Found in "+ getCenterName() + ".");
        }
    }
    public void displayReservations() {
        System.out.println("Existing Reservations for " + centerName + ":");

        if (reservations.isEmpty()) {
            System.out.println("There are no reservations yet.");
        } else {
            for (Reservation reservation : reservations) {
                System.out.println(reservation.getReservationInfo());
            }
        }
        System.out.println();
    }


}
