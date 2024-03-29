package FinalProject;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a movie in the theater, including its title, director, genre, start time,
 * duration, ticket price, ticket sales count, revenue, and customer reviews.
 * The Movie class provides methods to manipulate and retrieve information about the movie,
 * such as selling and refunding tickets, calculating average ratings, and managing reviews.
 */
public class Movie {
    private String title;
    private String director;
    private String genre;
    private String startTime;
    private int duration;
    private int ticketSales;
    private double revenue;
    private double ticketPrice;
    private TheaterTicketSystem ticketSystem;
    private List<Review> reviews;

    /**
     * Constructs a Movie object with the specified details.
     * Pre: The title, director, genre, startTime parameters are not null or empty.
     * The duration parameter is a positive integer.
     * The ticketPrice parameter is a positive number.
     * The ticketSystem parameter is not null.
     * Post: A Movie object is created with the specified details.
     * A seating arrangement for the movie is created in the theater ticket system.
     */
    public Movie(String title, String director, String genre, int duration, double ticketPrice,
                 TheaterTicketSystem ticketSystem, String startTime) {
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.duration = duration;
        this.ticketPrice = ticketPrice;
        this.startTime = startTime;
        this.revenue = 0;
        this.ticketSales = 0;
        this.reviews = new ArrayList<>();
        this.ticketSystem = ticketSystem;
        ticketSystem.createSeatingArrangement(title);
    }

    /**
     * Returns the start time of the movie.
     * Pre: None.
     * Post: The start time of the movie is returned as a string.
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * Sells a ticket for the movie at the specified seat.
     * Pre: The row and col parameters represent a valid seat in the theater.
     * Post: If the seat is available, it is sold.
     * The ticket sales and revenue are incremented.
     */
    public void sellTicket(int row, int col) {
        ticketSystem.sellSeatGraph(title, row, col);
        incrementTicketSales();
        addToRevenue(ticketPrice);
    }

    /**
     * Prints the seat graph for the movie.
     * Pre: None.
     * Post: The seat graph for the movie is printed to the console.
     * If the movie title is not found or the seating arrangement is not created,
     * appropriate messages are displayed.
     */
    public void printSeatGraph() {
        ticketSystem.printSeat(title);
    }

    /**
     * Refunds a ticket for the movie at the specified seat.
     * Pre: The row and col parameters represent a valid seat in the theater.
     * Post: If the seat is sold, it is refunded.
     * If the seat is already available or the specified seat is invalid,
     * appropriate messages are displayed.
     * Returns true if the seat was refunded successfully, false otherwise.
     */
    public boolean refundTicketGraph(int row, int col) {
        return ticketSystem.refundGraph(title, row, col);
    }

    /**
     * Returns the genre of the movie.
     * Pre: None.
     * Post: The genre of the movie is returned as a string.
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Sets the genre of the movie.
     * Pre: The genre parameter is not null or empty.
     * Post: The genre of the movie is updated.
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Increments the ticket sales count by one.
     * Pre: None.
     * Post: The ticket sales count is incremented by one.
     */
    public void incrementTicketSales() {
        this.ticketSales++;
    }

    /**
     * Decrements the ticket sales count by one.
     * Pre: None.
     * Post: The ticket sales count is decremented by one.
     */
    public void decrementTicketSales() {
        this.ticketSales--;
    }

    /**
     * Adds the specified price to the movie's revenue.
     * Pre: The price parameter is a positive number.
     * Post: The specified price is added to the movie's revenue.
     */
    public void addToRevenue(double price) {
        this.revenue += price;
    }

    /**
     * Returns the revenue generated by the movie.
     * Pre: None.
     * Post: The revenue generated by the movie is returned as a double.
     */
    public double getRevenue() {
        return this.revenue;
    }

    /**
     * Sets the revenue generated by the movie.
     * Pre: The revenue parameter is a non-negative number.
     * Post: The revenue generated by the movie is updated.
     */
    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    /**
     * Returns the ticket price for the movie.
     * Pre: None.
     * Post: The ticket price for the movie is returned as a double.
     */
    public double getTicketPrice() {
        return this.ticketPrice;
    }

    /**
     * Sets the ticket price for the movie.
     * Pre: The ticketPrice parameter is a positive number.
     * Post: The ticket price for the movie is updated.
     */
    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    /**
     * Returns the number of tickets sold for the movie.
     * Pre: None.
     * Post: The number of tickets sold for the movie is returned as an integer.
     */
    public int getTicketSales() {
        return this.ticketSales;
    }

    /**
     * Returns the title of the movie.
     * Pre: None.
     * Post: The title of the movie is returned as a string.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Returns the director of the movie.
     * Pre: None.
     * Post: The director of the movie is returned as a string.
     */
    public String getDirector() {
        return this.director;
    }

    /**
     * Returns the duration of the movie in minutes.
     * Pre: None.
     * Post: The duration of the movie is returned as an integer.
     */
    public int getDuration() {
        return this.duration;
    }

    /**
     * Sets the title of the movie.
     * Pre: The title parameter is not null or empty.
     * Post: The title of the movie is updated.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets the director of the movie.
     * Pre: The director parameter is not null or empty.
     * Post: The director of the movie is updated.
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Sets the duration of the movie in minutes.
     * Pre: The duration parameter is a positive integer.
     * Post: The duration of the movie is updated.
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Adds a review to the movie's list of reviews.
     * Pre: The review parameter is not null.
     * Post: The review is added to the movie's list of reviews.
     */
    public void addReview(Review review) {
        reviews.add(review);
    }

    /**
     * Returns the list of reviews for the movie.
     * Pre: None.
     * Post: The list of reviews for the movie is returned.
     */
    public List<Review> getReviews() {
        return reviews;
    }

    /**
     * Calculates and returns the average rating of the movie based on the reviews.
     * Pre: None.
     * Post: The average rating of the movie is calculated and returned as a double.
     * If there are no reviews, the average rating is 0.
     */
    public double getAverageRating() {
        if (reviews.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (Review review : reviews) {
            sum += review.getRating();
        }
        return sum / reviews.size();
    }

    /**
     * Returns a string representation of the movie.
     * Pre: None.
     * Post: A string representation of the movie is returned, including its title,
     * director, genre, start time, duration, and ticket price.
     */
    @Override
    public String toString() {
        return "Movie: " + this.title +
                "\nDirector: " + this.director +
                "\nGenre: " + this.genre +
                "\nStart Time: " + convertTime() +
                "\nDuration: " + this.duration + " minutes" +
                "\nTicket Price: $" + this.ticketPrice + "\n";
    }

    /**
     * Converts the start time of the movie from 24-hour format to 12-hour format.
     * Pre: The startTime field is a string in the format "HH:mm" where HH represents
     * hours in 24-hour format and mm represents minutes.
     * Post: The start time of the movie is converted to 12-hour format and returned as a string.
     */
    private String convertTime() {
        String newTime = "";
        if (startTime.compareTo("12:00") > 0) {
            String[] arr = (startTime.split(":"));
            int hours = Integer.valueOf(arr[0]);
            if (hours == 12) {
                return "12:" + arr[1] + "PM";
            }
            newTime = (hours - 12) + ":" + arr[1];
            return newTime + " PM";
        }

        return startTime + " AM";
    }
}
