package FinalProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cinema {
    private List<Movie> movies;
    private Map<Integer, Seat> seats;
    private MovieSchedule movieSchedule;

    // Constructor to initialize the Cinema object
    public Cinema() {
        movies = new ArrayList<>();
        seats = new HashMap<>();
        movieSchedule = new MovieSchedule();
    }

    // Add a movie to the cinema
    public void addMovie(Movie movie) {
        // Code to add movie to the movies list
    }

    // Remove a movie from the cinema
    public void removeMovie(Movie movie) {
        // Code to remove movie from the movies list
    }

    // Get the list of available movies
    public List<Movie> getMovies() {
        // Code to retrieve the movies list
        return movies;
    }

    // Sell a ticket for a movie
    public void sellTicket(Movie movie, Seat seat, Customer customer) {
        // Code to sell a ticket for the given movie and seat to the customer
    }

    // Check seat availability for a movie
    public boolean isSeatAvailable(Movie movie, Seat seat) {
        // Code to check if the given seat is available for the movie
        return false;
    }

    // Show statistics of ticket sales
    public void showStatistics() {
        // Code to display statistics such as ticket sales, revenue, etc.
    }

    // Get the movie schedule
    public MovieSchedule getMovieSchedule() {
        return movieSchedule;
    }
}
