package FinalProject;

import java.util.Scanner;

/**
 * Represents a Cinema that manages movies, ticket sales, and customer interactions.
 * The Cinema class provides methods for displaying statistics, printing movie schedule,
 * buying and refunding tickets, rating and reviewing movies, filtering and searching movies,
 * and adding/removing movies. It also interacts with the Employee class to perform
 * employee-related operations.
 */
public class Cinema {
    private MovieLinkedList movies;
    private Employee employee;

    /**
     * Initializes a new Cinema object with an empty movie list and an employee.
     */
    public Cinema() {
        movies = new MovieLinkedList();
        employee = new Employee(movies);
    }

    /**
     * Retrieves the list of movies in the cinema.
     *
     * @return The list of movies.
     */
    public MovieLinkedList getMovies() {
        return movies;
    }

    /**
     * Displays the ticket sales statistics for all movies.
     * The statistics include information about ticket sales, revenue, and occupancy.
     */
    public void showStatistics() {
        System.out.println("Ticket Sales Statistics:");
        System.out.println("-------------------------");
        movies.traverseStats();
    }

    /**
     * Prints the movie schedule, showing the details of all movies in the cinema.
     */
    public void printMovieSchedule() {
        System.out.println(movies);
    }

    /**
     * Initiates the process of buying a ticket for a specific movie.
     * Precondition: The movie list is not empty.
     * Postcondition: If the movie is found and has available seats, a ticket is purchased, the
     * revenue and ticket sales are updated, and a success message is displayed. Otherwise, an
     * error message is displayed.
     *
     * @param scanner The Scanner object for user input.
     */
    public void buyTicket(Scanner scanner) {
        System.out.println("Enter the movie title:");
        String movieTitle = scanner.nextLine();
        Movie buyMovie = movies.searchMovie(movieTitle);
        if (buyMovie != null) {
            buyMovie.printSeatGraph();
            System.out.println();

            int row = getValidInput(scanner, "row", 1, 10);
            int column = getValidInput(scanner, "column", 1, 20);

            Seat selectedSeat = new Seat(row, column, buyMovie);
            Customer buyingCustomer = getCustomerDetails(scanner);

            sellTicket(buyMovie, selectedSeat, buyingCustomer);
            System.out.println("Thank you for purchasing, " + selectedSeat.getCustomer());
        } else {
            System.out.println("Movie not found");
        }
    }

    /**
     * Processes the sale of a ticket for a specific seat in a movie.
     * Updates the movie's seat graph, assigns the seat to the customer,
     * and records the sale in the movie's revenue.
     *
     * @param movie    The movie for which the ticket is being sold.
     * @param seat     The selected seat for the ticket.
     * @param customer The customer who is purchasing the ticket.
     */
    private void sellTicket(Movie movie, Seat seat, Customer customer) {
        movie.sellTicket(seat.getRow(), seat.getColumn());
        seat.setCustomer(customer);
        customer.setSeat(seat);
    }

    /**
     * Initiates the process of refunding a ticket for a specific movie.
     * Precondition: The movie list is not empty.
     * Postcondition: If the movie is found and the specified ticket is refundable, the ticket
     * is refunded, the revenue and ticket sales are updated, and a success message is displayed.
     * Otherwise, an error message is displayed.
     *
     * @param scanner The Scanner object for user input.
     */
    public void refundTicket(Scanner scanner) {
        System.out.println("Enter the movie title:");
        String movieTitle = scanner.nextLine();

        Movie movie = movies.searchMovie(movieTitle);

        if (movie != null) {
            System.out.println();

            int row = getValidInput(scanner, "row", 1, 10);
            int column = getValidInput(scanner, "column", 1, 20);

            if (movie.refundTicketGraph(row, column)) {
                double ticketPrice = movie.getTicketPrice();
                movie.addToRevenue(ticketPrice);
                movie.decrementTicketSales();
                System.out.println("Thank you for refunding, ");
            } else {
                System.out.println("Movie not found.");
            }
        }
    }

    /**
     * Allows a customer to rate and review a movie.
     * Precondition: The movie list is not empty.
     * Postcondition: If the movie is found, the rating and review are submitted and
     * associated with the movie, and a success message is displayed. Otherwise, an
     * error message is displayed.
     *
     * @param scanner The Scanner object for user input.
     */
    public void rateAndReview(Scanner scanner) {
        System.out.println("Enter the movie title to rate and review:");
        String movieTitle = scanner.nextLine();
        Movie movie = movies.searchMovie(movieTitle);
        if (movie != null) {
            System.out.println("Rate the movie (1-5):");
            int rating = scanner.nextInt();
            scanner.nextLine();
            System.out.println("What is your name?");
            String name = scanner.nextLine();
            System.out.println("What is your email?");
            String email = scanner.nextLine();
            System.out.println("Write a review:");
            String reviewComment = scanner.nextLine();
            Review review = new Review(name, email, rating, reviewComment);
            movie.addReview(review);
            System.out.println("Rating and review submitted successfully.");
        } else {
            System.out.println("Movie not found.");
        }
    }

    /**
     * Displays the ratings and reviews for all movies in the cinema.
     * Precondition: The movie list is not empty.
     * Postcondition: The ratings and reviews for all movies are displayed.
     */
    public void showMovieRatings() {
        movies.showMovieRatings();
    }

    /**
     * Prints the filtered list of movies based on the specified genre.
     * Precondition: The movie list is not empty.
     * Postcondition: The search results based on the specified query are displayed.
     *
     * @param scanner The Scanner object for user input.
     */
    public void printFilteredMovies(Scanner scanner) {
        System.out.println("Enter the genre to filter movies (leave blank for all movies):");
        String genre = scanner.nextLine();
        System.out.println("Filtered Movies:");
        System.out.println("-------------------------");
        movies.printFilteredMovies(genre);
        System.out.println("-------------------------");
    }

    /**
     * Searches for movies based on the specified search query and prints the search results.
     * Precondition: The movie list is not empty.
     * Postcondition: The search results based on the specified query are displayed.
     *
     * @param scanner The Scanner object for user input.
     */
    public void searchMovies(Scanner scanner) {
        System.out.println("Enter the search query:");
        String query = scanner.nextLine();
        System.out.println("Search Results:");
        System.out.println("-------------------------");
        Movie searchedMovie = movies.searchMovie(query);
        System.out.println(searchedMovie.toString());
        System.out.println("-------------------------");
    }

    /**
     * Adds a new movie to the cinema's movie list.
     * Requires employee login for authorization.
     * Precondition: The employee is logged in.
     * Postcondition: A new movie is added to the movie list.
     *
     * @param scanner The Scanner object for user input.
     */
    public void addMovie(Scanner scanner) {
        if (employee.login(scanner)) {
            employee.addMovie(scanner);
        }
    }

    /**
     * Removes a movie from the cinema's movie list.
     * Requires employee login for authorization.
     * Precondition: The employee is logged in.
     * Postcondition: The specified movie is removed from the movie list.
     *
     * @param scanner The Scanner object for user input.
     */
    public void removeMovie(Scanner scanner) {
        if (employee.login(scanner)) {
            employee.removeMovie(scanner);
        }
    }

    /**
     * Allows an employee to fix the ticket price for a movie.
     * Requires employee login for authorization.
     * Precondition: The employee is logged in.
     * Postcondition: The ticket price for the specified movie is fixed.
     *
     * @param scanner The Scanner object for user input.
     */
    public void fixMoviePrice(Scanner scanner) {
        if (employee.login(scanner)) {
            employee.fixMoviePrice(scanner);
        }
    }

    private int getValidInput(Scanner scanner, String inputName, int min, int max) {
        int input = -1; // Initialize input with an invalid value
        boolean isValidInput = false;
        do {
            System.out.println("Enter the " + inputName + " number:");
            try {
                String userInput = scanner.nextLine();
                if (userInput.isEmpty()) {
                    System.out.println("Invalid input. " + inputName + " should be an integer.");
                    continue;
                }
                input = Integer.parseInt(userInput);
                if (input >= min && input <= max) {
                    isValidInput = true;
                } else {
                    System.out.println("Invalid input. " + inputName + " should be between "
                            + min + " and " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. " + inputName + " should be an integer.");
            }
        } while (!isValidInput);
        return input;
    }

    private Customer getCustomerDetails(Scanner scanner) {
        System.out.println("What is your name?");
        String name = scanner.nextLine();
        System.out.println("What is your email?");
        String email = scanner.nextLine();
        return new Customer(name, email);
    }
}
