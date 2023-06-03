package FinalProject;

public class Cinema {
    private MovieLinkedList movies;

    public Cinema() {
        movies = new MovieLinkedList();
    }

    public MovieLinkedList getMovies() {
        return movies;
    }

    public boolean isSeatAvailable(Movie movie, int row, int column) {
        // Code to check if the given seat is available for the movie
//        seats.searchSeat(row, column);
        return false;
    }

    public void sellTicket(Movie movie, Seat seat, Customer customer) {
        if (isSeatAvailable(movie, seat.getRow(), seat.getColumn())) {
            seat.setSold();
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
        movies.traverseStats();
    }

    public void printMovieSchedule() {
        System.out.println(movies.toString());
    }
}


