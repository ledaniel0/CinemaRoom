
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Movie {
    private String title;
    private String director;
    private String genre;
    private int duration;
    private int ticketSales;
    private double revenue;
    private double ticketPrice;
    private TheaterTicketSystem ticketSystem;
    private List<Review> reviews;

    public Movie(String title, String director, String genre, int duration, double ticketPrice, TheaterTicketSystem ticketSystem) {
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.duration = duration;
        this.ticketPrice = ticketPrice;
        this.revenue = 0;
        this.ticketSales = 0;
        this.reviews = new ArrayList<>();
        this.ticketSystem = ticketSystem;
        ticketSystem.createSeatingArrangement(title);
    }

    public void sellTicket(int row, int col) {
        ticketSystem.sellSeatGraph(title, row, col);
        incrementTicketSales();
        addToRevenue(ticketPrice);
    }

    public void printSeatGraph() {
        ticketSystem.printSeat(title);
    }
    public boolean refundTicketGraph(int row, int cal){
       return ticketSystem.refundGraph(title, row, cal);
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void incrementTicketSales() {
        this.ticketSales++;
    }

    public void decrementTicketSales() {
        this.ticketSales--;
    }

    public void addToRevenue(double price) {
        this.revenue += price;
    }

    public double getRevenue() {
        return this.revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public double getTicketPrice() {
        return this.ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getTicketSales() {
        return this.ticketSales;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDirector() {
        return this.director;
    }

    public int getDuration() {
        return this.duration;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public List<Review> getReviews() {
        return reviews;
    }

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


    @Override
    public String toString() {
        return "Movie: " + this.title +
                "\nDirector: " + this.director +
                "\nGenre: " + this.genre +
                "\nDuration: " + this.duration + " minutes" +
                "\nTicket Price: $" + this.ticketPrice + "\n";
    }
}

