
public class Seat {
    private int row;
    private int column;
    private boolean available;
    private String symbol;
    private Movie movie;
    private Customer customer;
    public Seat next;

    public Seat(int row, int column, Movie movie) {
        this.row = row;
        this.column = column;
        this.available = true;
        this.movie = movie;
        this.next = null;
    }

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        this.available = true;
        this.next = null;
        this.movie = null;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }





    public String toString() {
        return "Row: " + this.row +
                " Column: " + this.column;
    }
}


