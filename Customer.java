package FinalProject;

/**
 * Represents a customer in the theater, including their name, email, and assigned seat.
 * The Customer class provides methods to retrieve and update customer information.
 */
public class Customer {
    private String name;
    private String email;
    private Seat seat;

    /**
     * Initializes a new Customer object with the specified name and email.
     * Pre: The name parameter is not null or empty.
     * The email parameter is a valid email address.
     * Post: A new Customer object is created with the specified name and email.
     */
    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    /**
     * Retrieves the name of the customer.
     * Pre: None.
     * Post: The name of the customer is returned.
     *
     * @return The name of the customer.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the customer.
     * Pre: The name parameter is not null or empty.
     * Post: The name of the customer is updated with the specified value.
     *
     * @param name The new name of the customer.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the email of the customer.
     * Pre: None.
     * Post: The email of the customer is returned.
     *
     * @return The email of the customer.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the customer.
     * Pre: The email parameter is a valid email address.
     * Post: The email of the customer is updated with the specified value.
     *
     * @param email The new email of the customer.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets the assigned seat for the customer.
     * Pre: The seat parameter is not null.
     * Post: The assigned seat for the customer is updated with the specified seat.
     *
     * @param seat The seat assigned to the customer.
     */
    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    /**
     * Retrieves the assigned seat of the customer.
     * Pre: None.
     * Post: The assigned seat of the customer is returned.
     *
     * @return The assigned seat of the customer.
     */
    public Seat getSeat() {
        return seat;
    }

    /**
     * Returns a string representation of the customer, including the name, email,
     * and assigned seat.
     * Pre: None.
     * Post: A string representation of the customer is returned.
     *
     * @return A string representation of the customer.
     */
    @Override
    public String toString() {
        return this.name +
                "\nEmail: " + this.email +
                "\nSeat: " + this.seat + "\n";
    }
}
