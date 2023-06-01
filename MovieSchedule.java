package FinalProject;

import java.util.LinkedList;

public class MovieSchedule {
    private LinkedList<Movie> schedule;

    // Constructor to initialize the MovieSchedule object
    public MovieSchedule() {
        schedule = new LinkedList<>();
    }

    // Add a movie to the schedule
    public void addMovieToSchedule(Movie movie) {
        schedule.add(movie);
    }

    // Remove a movie from the schedule
    public void removeMovieFromSchedule(Movie movie) {
        schedule.remove(movie);
    }

    // Get the movie schedule
    public LinkedList<Movie> getSchedule() {
        return schedule;
    }

}
