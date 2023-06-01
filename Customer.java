package FinalProject;

public class Customer {
    private String name;
    private String email;

    // Constructor to initialize the Customer object
    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
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
}
