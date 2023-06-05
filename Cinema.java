package FinalProject;

import java.util.Scanner;

public class Cinema {
    private MovieLinkedList movies;
    private Employee employee;

    public Cinema() {
        movies = new MovieLinkedList();
        employee = new Employee(movies);
    }

    public MovieLinkedList getMovies() {
        return movies;
    }

    public boolean isSeatAvailable(Movie movie, int row, int column) {
        Seat seat = movie.seats.findSeat(row, column);
        return seat != null && seat.isAvailable();
    }

    private void sellTicket(Movie movie, Seat seat, Customer customer) {
        if (isSeatAvailable(movie, seat.getRow(), seat.getColumn())) {
            seat.setAvailable(false);
            seat.setCustomer(customer);
            movie.incrementTicketSales();
            movie.addToRevenue(movie.getTicketPrice());
            customer.setSeat(seat);
            System.out.println("Ticket sold successfully. Thank you for purchasing!\n");
        } else {
            System.out.println("Sorry, the seat is not available.");
        }
    }

    public boolean refundTicket(String movieTitle, int row, int column) {
        Movie movie = movies.searchMovie(movieTitle);
        if (movie != null) {
            Seat seat = movie.seats.findSeat(row, column);
            if (seat != null && seat.isAvailable()) {
                double ticketPrice = movie.getTicketPrice();
                movie.addToRevenue(ticketPrice);
                movie.decrementTicketSales();
                seat.setAvailable(true);
                seat.setCustomer(null);
                return true;
            }
        }
        return false;
    }

    public void showStatistics() {
        System.out.println("Ticket Sales Statistics:");
        System.out.println("-------------------------");
        movies.traverseStats();
    }

    public void printMovieSchedule() {
        System.out.println(movies.toString());
    }

    public void buyTicket(Scanner scanner) {
        System.out.println("Enter the movie title:");
        String movieTitle = scanner.nextLine();
        Movie buyMovie = movies.searchMovie(movieTitle);
        if (buyMovie != null) {
            buyMovie.seats.printSeats();
            System.out.println();

            int row = getValidInput(scanner, "row", 1, 10);
            int column = getValidInput(scanner, "column", 1, 20);

            Seat selectedSeat = new Seat(row, column, buyMovie);
            Customer buyingCustomer = getCustomerDetails(scanner);

            sellTicket(buyMovie, selectedSeat, buyingCustomer);
        }
    }

    public boolean refundTicket(Scanner scanner) {
        System.out.println("Enter the movie title:");
        String movieTitle = scanner.nextLine();

        Movie movie = movies.searchMovie(movieTitle);
        if (movie != null) {
            movie.seats.printSeats();
            System.out.println();

            int row = getValidInput(scanner, "row", 1, 10);
            int column = getValidInput(scanner, "column", 1, 20);

            if (isSeatAvailable(movie, row, column)) {
                System.out.println("The seat is already available. Cannot refund the ticket.\n");
            } else {
                if (refundTicket(movieTitle, row, column)) {
                    System.out.println("Ticket refunded successfully.\n");
                    return true;
                } else {
                    System.out.println("Sorry, the ticket cannot be refunded.\n");
                }
            }
        } else {
            System.out.println("Movie not found.");
        }
        return false;
    }

    public void rateAndReview(Scanner scanner) {
        System.out.println("Enter the movie title to rate and review:");
        scanner.nextLine();
        String movieTitle = scanner.nextLine();
        Movie movie = movies.searchMovie(movieTitle);
        if (movie != null) {
            System.out.println("Rate the movie (1-5):");
            int rating = scanner.nextInt();
            scanner.nextLine();
            System.out.println("What is your name?");
            String name = scanner.nextLine();
            System.out.println("Write a review:");
            String reviewComment = scanner.nextLine();
            Review review = new Review(name, rating, reviewComment);
            movie.addReview(review);
            System.out.println("Rating and review submitted successfully.");
        } else {
            System.out.println("Movie not found.");
        }
    }

    public void showMovieRatings() {
        movies.showMovieRatings();
    }

    public void printFilteredMovies(Scanner scanner) {
        System.out.println("Enter the genre to filter movies (leave blank for all movies):");
        String genre = scanner.nextLine();
        System.out.println("Filtered Movies:");
        System.out.println("-------------------------");
        movies.printFilteredMovies(genre);
        System.out.println("-------------------------");
    }

    public void searchMovies(Scanner scanner) {
        System.out.println("Enter the search query:");
        String query = scanner.nextLine();
        System.out.println("Search Results:");
        System.out.println("-------------------------");
        Movie searchedMovie = movies.searchMovie(query);
        System.out.println(searchedMovie.toString());
        System.out.println("-------------------------");
    }

    public void addMovie(Scanner scanner) {
        if (employee.login(scanner)) {
            employee.addMovie(scanner);
        }
    }

    public void removeMovie(Scanner scanner) {
        if (employee.login(scanner)) {
            employee.removeMovie(scanner);
        }
    }

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
                    System.out.println("Invalid input. " + inputName + " should be between " + min + " and " + max + ".");
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
