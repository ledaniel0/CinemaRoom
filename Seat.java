package FinalProject;

/**
 * Represents a seat in the theater for a specific movie.
 * The Seat class stores information about the seat's location,
 * associated movie, and assigned customer.
 */
public class Seat {
    private int row;
    private int column;
    private Movie movie;
    private Customer customer;
    public Seat next;

    /**
     * Initializes a new Seat object.
     *
     * @param row    The row number of the seat.
     * @param column The column number of the seat.
     * @param movie  The movie associated with the seat.
     *               <p>
     *               Pre: Row and column are positive integers, movie is not null.
     *               Post: Seat object is created with specified row, column, and movie.
     */
    public Seat(int row, int column, Movie movie) {
        this.row = row;
        this.column = column;
        this.movie = movie;
        this.next = null;
    }

    /**
     * Sets the customer assigned to the seat.
     *
     * @param customer The customer assigned to the seat.
     *                 <p>
     *                 Pre: Customer is not null.
     *                 Post: Seat's customer is set to the specified customer.
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Retrieves the customer assigned to the seat.
     *
     * @return The customer assigned to the seat.
     * <p>
     * Post: Seat's customer is returned as a string.
     */
    public String getCustomer() {
        return customer.toString();
    }

    /**
     * Retrieves the movie associated with the seat.
     *
     * @return The movie associated with the seat.
     * <p>
     * Post: Seat's movie is returned.
     */
    public Movie getMovie() {
        return movie;
    }

    /**
     * Sets the movie associated with the seat.
     *
     * @param movie The movie to associate with the seat.
     *              <p>
     *              Pre: Movie is not null.
     *              Post: Seat's movie is set to the specified movie.
     */
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    /**
     * Retrieves the row number of the seat.
     *
     * @return The row number of the seat.
     * <p>
     * Post: Seat's row number is returned.
     */
    public int getRow() {
        return row;
    }

    /**
     * Retrieves the column number of the seat.
     *
     * @return The column number of the seat.
     * <p>
     * Post: Seat's column number is returned.
     */
    public int getColumn() {
        return column;
    }

    /**
     * Returns a string representation of the seat.
     *
     * @return A string representation of the seat.
     * <p>
     * Post: Seat's row and column numbers are returned as a formatted string.
     */
    public String toString() {
        return "Row: " + this.row +
                " Column: " + this.column;
    }
}
