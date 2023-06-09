package FinalProject;

import java.util.Scanner;

/**
 * The Employee class represents an employee who manages the movie list and performs various
 * administrative tasks in the theater ticket system. An employee is responsible for adding,
 * removing, and updating movies in the movie list, as well as handling the login process
 * for accessing the employee functionalities. The Employee class provides methods to add
 * a new movie, remove an existing movie, and fix the ticket price of a movie.
 * It also includes a helper method for reading and validating user input.
 * The employee is identified by a username and password, and the class maintains a
 * reference to the movie list and
 * the theater ticket system.
 */
public class Employee {
    private final String USERNAME = "admin";
    private final String PASSWORD = "admin";
    private MovieLinkedList movieList;
    private TheaterTicketSystem ticketSystem;

    /**
     * Initializes a new Employee object with the specified movie list.
     * Pre: The movieList parameter is not null.
     * Post: A new Employee object is created with the specified movie list.
     *
     * @param movieList The movie list to be managed by the employee.
     */
    public Employee(MovieLinkedList movieList) {
        ticketSystem = new TheaterTicketSystem();
        this.movieList = movieList;
    }

    /**
     * Performs the employee login process.
     * Pre: The scanner parameter is not null.
     * Post: The employee is logged in if the entered username and password are correct.
     *
     * @param scanner The scanner object to read user input.
     * @return True if the login is successful, false otherwise.
     */
    public boolean login(Scanner scanner) {
        System.out.println("Employee Login");
        System.out.println("Enter your USERNAME:");
        String enteredUsername = scanner.nextLine();
        System.out.println("Enter your PASSWORD:");
        String enteredPassword = scanner.nextLine();

        if (enteredUsername.equals(USERNAME) && enteredPassword.equals(PASSWORD)) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Invalid USERNAME or PASSWORD. Login failed.");
            return false;
        }
    }

    /**
     * Adds a new movie to the movie list.
     * Pre: The scanner parameter is not null.
     * Post: A new movie is added to the movie list with the specified details.
     *
     * @param scanner The scanner object to read user input.
     */
    public void addMovie(Scanner scanner) {
        System.out.println("Enter the movie title:");
        String title = scanner.nextLine();
        System.out.println("Enter the movie director:");
        String director = scanner.nextLine();
        System.out.println("Enter the movie genre:");
        String genre = scanner.nextLine();
        System.out.println("Enter the movie duration (in minutes):");
        int duration = getValidInput(scanner, "Duration", true);
        System.out.println("Enter the movie ticket price:");
        double ticketPrice = getValidInput(scanner, "Ticket price", false);
        System.out.println("Enter the movie start time:");
        String startTime = scanner.nextLine();

        Movie newMovie = new Movie(title, director, genre, duration, ticketPrice,
                ticketSystem, startTime);
        movieList.addMovie(newMovie);

        System.out.println("Movie added successfully.");
    }

    /**
     * Removes a movie from the movie list.
     * Pre: The scanner parameter is not null.
     * Post: The movie with the specified title is removed from the movie list if found.
     *
     * @param scanner The scanner object to read user input.
     */
    public void removeMovie(Scanner scanner) {
        System.out.println("Enter the movie title to remove:");
        String title = scanner.nextLine();

        boolean removed = movieList.removeMovie(title);

        if (removed) {
            System.out.println("Movie removed successfully.");
        } else {
            System.out.println("Movie not found.");
        }
    }

    /**
     * Fixes the ticket price of a movie in the movie list.
     * Pre: The scanner parameter is not null.
     * Post: The ticket price of the movie with the specified title is updated if found.
     *
     * @param scanner The scanner object to read user input.
     */
    public void fixMoviePrice(Scanner scanner) {
        System.out.println("Enter the movie title to fix the price:");
        String title = scanner.nextLine();

        Movie movie = movieList.searchMovie(title);

        if (movie != null) {
            System.out.println("Enter the new ticket price:");
            double newPrice = getValidInput(scanner, "New ticket price", false);
            movie.setTicketPrice(newPrice);
            System.out.println("Movie price updated successfully.");
        } else {
            System.out.println("Movie not found.");
        }
    }

    /**
     * Reads and validates user input based on whether it should be an integer or double value.
     * Pre: The scanner parameter is not null. The inputName parameter is not null or empty.
     * Post: The user input is read and validated. An integer or double value is returned.
     *
     * @param scanner   The scanner object to read user input.
     * @param inputName The name of the input to be displayed in error messages.
     * @param isInteger True if the input should be an integer value, false if it should
     *                  be a double value.
     * @return The valid integer or double value entered by the user.
     */
    private int getValidInput(Scanner scanner, String inputName, boolean isInteger) {
        int intValue = -1;
        double doubleValue = -1.0;
        boolean isValidInput = false;
        do {
            String inputString = scanner.nextLine().trim();
            try {
                if (isInteger) {
                    intValue = Integer.parseInt(inputString);
                    isValidInput = true;
                } else {
                    doubleValue = Double.parseDouble(inputString);
                    isValidInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. " + inputName + " should be a " +
                        (isInteger ? "integer" : "number") + ".");
            }
        } while (!isValidInput);
        return isInteger ? intValue : (int) doubleValue;
    }
}
