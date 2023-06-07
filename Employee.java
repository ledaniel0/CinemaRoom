import java.util.Scanner;

public class Employee {
    private final String USERNAME = "admin";
    private final String PASSWORD = "admin";
    private MovieLinkedList movieList;
    private TheaterTicketSystem ticketSystem = new TheaterTicketSystem();

    public Employee(MovieLinkedList movieList) {
        this.movieList = movieList;
    }

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

        Movie newMovie = new Movie(title, director, genre, duration, ticketPrice, ticketSystem);
        movieList.addMovie(newMovie);

        System.out.println("Movie added successfully.");
    }

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
                System.out.println("Invalid input. " + inputName + " should be a " + (isInteger ? "integer" : "number") + ".");
            }
        } while (!isValidInput);
        return isInteger ? intValue : (int) doubleValue;
    }
}
