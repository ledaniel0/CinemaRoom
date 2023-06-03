package FinalProject;

import java.util.InputMismatchException;
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
        scanner.nextLine();
        String movieTitle = scanner.nextLine();
        Movie buyMovie = movies.searchMovie(movieTitle);
        if (buyMovie != null) {
            buyMovie.seats.printSeats();
            System.out.println();
            int row;
            boolean isValidRow = false;
            do {
                System.out.println("What row would you like?");
                try {
                    row = scanner.nextInt();
                    scanner.nextLine();
                    if (row <= 10) {
                        isValidRow = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Row should be an integer.");
                    scanner.nextLine(); // Consume the invalid input
                    row = -1; // Set row to an invalid value to trigger re-prompting
                }
            } while (!isValidRow);

            int column;
            boolean isValidColumn = false;
            do {
                System.out.println("What column would you like?");
                try {
                    column = scanner.nextInt();
                    scanner.nextLine();
                    if (column <= 20) {
                        isValidColumn = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Column should be an integer.");
                    scanner.nextLine(); // Consume the invalid input
                    column = -1; // Set column to an invalid value to trigger re-prompting
                }
            } while (!isValidColumn);

            Seat selectedSeat = new Seat(row, column, buyMovie);
            System.out.println("What is your name?");
            String name = scanner.nextLine();
            System.out.println("What is your email?");
            String email = scanner.nextLine();
            Customer buyingCustomer = new Customer(name, email);
            if (isSeatAvailable(buyMovie, row, column)) {
                sellTicket(buyMovie, selectedSeat, buyingCustomer);
            }
        }
    }

    public boolean refundTicket(Scanner scanner) {
        System.out.println("Enter the movie title:");
        scanner.nextLine();
        String movieTitle = scanner.nextLine();
        Movie movie = movies.searchMovie(movieTitle);
        if (movie != null) {
            movie.seats.printSeats();
            System.out.println();
            int row;
            boolean isValidRow = false;
            do {
                System.out.println("Enter the row number:");
                try {
                    row = scanner.nextInt();
                    scanner.nextLine();
                    if (row <= 10) {
                        isValidRow = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Row should be an integer.");
                    scanner.nextLine(); // Consume the invalid input
                    row = -1; // Set row to an invalid value to trigger re-prompting
                }
            } while (!isValidRow);

            int column;
            boolean isValidColumn = false;
            do {
                System.out.println("Enter the column number:");
                try {
                    column = scanner.nextInt();
                    scanner.nextLine();
                    if (column <= 20) {
                        isValidColumn = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Column should be an integer.");
                    scanner.nextLine(); // Consume the invalid input
                    column = -1; // Set column to an invalid value to trigger re-prompting
                }
            } while (!isValidColumn);

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

}
