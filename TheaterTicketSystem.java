package FinalProject;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a Theater Ticket System that manages seating arrangements for movies.
 * The TheaterTicketSystem class provides methods for creating seating arrangements,
 * selling and refunding seats, and printing seat graphs for movies.
 */
public class TheaterTicketSystem {
    private static final int NUM_ROWS = 10;
    private static final int NUM_COLS = 20;
    private Map<String, char[][]> movieSeats;

    /**
     * Initializes a new TheaterTicketSystem object.
     * Pre: None.
     * Post: An empty map is created for seating arrangements.
     */
    public TheaterTicketSystem() {
        movieSeats = new HashMap<>();
    }

    /**
     * Creates a seating arrangement for the specified movie title.
     * Pre: The movieTitle parameter is not null or empty.
     * Post: A seating arrangement is created for the specified movie title.
     * The seating arrangement is stored in the movieSeats map.
     */
    public void createSeatingArrangement(String movieTitle) {
        char[][] seats = new char[NUM_ROWS][NUM_COLS];
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                seats[i][j] = 'O';
            }
        }
        movieSeats.put(movieTitle, seats);
    }

    /**
     * Sells a seat for the specified movie at the given row and column.
     * Pre: The movieTitle parameter is not null or empty.
     * The row parameter is a valid row number (between 1 and NUM_ROWS).
     * The col parameter is a valid column number (between 1 and NUM_COLS).
     * Post: If the seat is available, it is sold (seat status is updated to 'X').
     * If the seat is already sold or the specified seat is invalid,
     * appropriate messages are displayed.
     */
    public void sellSeatGraph(String movieTitle, int row, int col) {
        char[][] seats = movieSeats.get(movieTitle);
        if (seats != null) {
            if (row >= 1 && row <= NUM_ROWS && col >= 1 && col <= NUM_COLS) {
                if (seats[row - 1][col - 1] == 'O') {
                    seats[row - 1][col - 1] = 'X';
                    System.out.println("Seat at Row " + row + ", Column " + col +
                            " for movie '" +
                            movieTitle + "' sold successfully.");
                } else {
                    System.out.println("Seat at Row " + row + ", Column " + col + " " +
                            "is already sold.");
                }
            } else {
                System.out.println("Invalid seat selection. Please choose a valid seat.");
            }
        }
    }

    /**
     * Prints the seat graph for the specified movie.
     * Pre: The movieTitle parameter is not null or empty.
     * Post: The seat graph for the specified movie is printed to the console.
     * If the movie title is not found or the seating arrangement is not
     * created, appropriate messages are displayed.
     */
    public void printSeat(String movieTitle) {
        char[][] seats = movieSeats.get(movieTitle);
        if (seats != null) {
            System.out.println("Seat Graph for movie '" + movieTitle + "':");
            for (int i = 0; i < NUM_ROWS; i++) {
                for (int j = 0; j < NUM_COLS; j++) {
                    System.out.print(seats[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Movie not found. Please create seating arrangement " +
                    "for the movie first.");
        }
    }

    /**
     * Refunds a seat for the specified movie at the given row and column.
     * Pre: The movieTitle parameter is not null or empty.
     * The row parameter is a valid row number (between 1 and NUM_ROWS).
     * The col parameter is a valid column number (between 1 and NUM_COLS).
     * Post: If the seat is sold, it is refunded (seat status is updated to 'O').
     * If the seat is already available or the specified seat is invalid,
     * appropriate messages are displayed.
     * Returns true if the seat was refunded successfully, false otherwise.
     */
    public boolean refundGraph(String movieTitle, int row, int col) {
        char[][] seats = movieSeats.get(movieTitle);
        if (seats[row - 1][col - 1] == 'X') {
            seats[row - 1][col - 1] = 'O';
            System.out.println("Seat at Row " + row + ", Column " + col + " has been refunded");
            return true;
        } else {
            System.out.println("Seat at Row " + row + ", Column " + col + " " +
                    "is already available");
            return false;
        }
    }
}
