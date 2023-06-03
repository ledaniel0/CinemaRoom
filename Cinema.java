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
        Seat seat = movie.seats.findSeat(row, column);
        return seat != null && seat.isAvailable();
    }

    public void sellTicket(Movie movie, Seat seat, Customer customer) {
        if (isSeatAvailable(movie, seat.getRow(), seat.getColumn())) {
            seat.setAvailable(false);
            seat.setSold();
            seat.setCustomer(customer);
            movie.incrementTicketSales();
            movie.addToRevenue(movie.getTicketPrice());
            customer.setSeat(seat);
            System.out.println("Ticket sold successfully. Thank You for Purchasing!\n");
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
}
