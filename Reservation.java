package OOP_Project;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Reservation {
    private int reservationId;
    private User user;
    private CarWashCenter carWashCenter;
    private LocalDateTime reservationTime;
    private ReservationStatus status;
    public Reservation(User user, CarWashCenter carWashCenter, LocalDateTime reservationTime) {
        this.reservationId = generateResevationId();
        this.user = user;
        this.carWashCenter = carWashCenter;
        this.reservationTime = reservationTime;
        this.status = ReservationStatus.PENDING;
    }
    public int getReservationId() {
        return reservationId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CarWashCenter getCarWashCenter() {
        return carWashCenter;
    }

    public void setCarWashCenter(CarWashCenter carWashCenter) {
        this.carWashCenter = carWashCenter;
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(LocalDateTime reservationTime) {
        this.reservationTime = reservationTime;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }


    private int generateResevationId() {
        return (int) (Math.random()*100) + 1 ;
    }
    public String getReservationInfo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String reservationTimeFormatted = reservationTime.format(formatter);

        return "Reservation Informations:\n" +
                "Reservation ID: " + reservationId + "\n" +
                "User: " + user.getUsername() + "\n" +
                "Car Wash Center: " + carWashCenter.getCenterName() + "\n" +
                "Reservation Time: " + reservationTimeFormatted + "\n" +
                "Status: " + status.toString() + "\n";
    }


}
