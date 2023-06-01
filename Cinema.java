package FinalProject;

public class Cinema {
    private MovieLinkedList movies;
    private SeatLinkedList seats;
    private MovieSchedule movieSchedule;

    public Cinema() {
        movies = new MovieLinkedList();
        seats = new SeatLinkedList();
        movieSchedule = new MovieSchedule();
    }

    public void addMovie(Movie movie) {
        movies.addMovie(movie);
    }

    public void removeMovie(Movie movie) {
        movies.removeMovie(movie);
    }

    public MovieLinkedList getMovies() {
        return movies;
    }

    public boolean isSeatAvailable(Movie movie, Seat seat) {
        // Code to check if the given seat is available for the movie
        return false;
    }

    public void sellTicket(Movie movie, Seat seat, Customer customer) {
        if (isSeatAvailable(movie, seat)) {
            seat.setSold(true);
            movie.incrementTicketSales();
            movie.addToRevenue(movie.getTicketPrice());
            customer.setSeat(seat);
            System.out.println("Ticket sold successfully.");
        } else {
            System.out.println("Sorry, the seat is not available.");
        }
    }

    public void showStatistics() {
        System.out.println("Ticket Sales Statistics:");
        movies.traverse();
    }

    public MovieSchedule getMovieSchedule() {
        return movieSchedule;
    }
}
