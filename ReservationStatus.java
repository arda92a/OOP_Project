package OOP_Project;

public enum ReservationStatus {
    PENDING,
    CONFIRMED,
    CANCELED,
    REJECTED;


    public String toString() {
       switch (this){
           case PENDING:return "Pending";
           case CANCELED:return "Canceled";
           case REJECTED:return "Rejected";
           case CONFIRMED:return "Confirmed";
           default:return null;
       }
    }
}

