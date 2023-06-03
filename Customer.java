package FinalProject;

public class Customer {
    private String name;
    private String email;
    private Seat seat;

    // Constructor to initialize the Customer object
    public Customer(String name, String email, Seat seat) {
        this.name = name;
        this.email = email;
        this.seat = seat;
    }

    // Getters and setters for the customer attributes
    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Seat getSeat() {
        return seat;
    }
    
    @Override
    public String toString() {
        return "Name: " + this.name +
                "\nEmail: " + this.email +
                "\nSeat: " + this.seat;
    }
}

