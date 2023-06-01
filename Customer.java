package FinalProject;

public class Customer {
    private String name;
    private String email;

    // Constructor to initialize the Customer object
    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String name) {
        this.name = name;
    }

    public void setName(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + this.name +
                "\nEmail: " + this.email;
    }
}

