package FinalProject;

public class Movie {
    private String title;
    private String director;
    private int duration;
    private int ticketSales;
    private double revenue;
    private double ticketPrice;
    private SeatLinkedList seats;
    public Movie next;

    public Movie(String title, String director, int duration, double ticketPrice) {
        this.title = title;
        this.director = director;
        this.duration = duration;
        this.ticketPrice = ticketPrice;
        this.revenue = 0;
        this.ticketSales = 0;
        this.seats = new SeatLinkedList();
        this.next = null;
    }

    public void incrementTicketSales() {
        this.ticketPrice++;
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

    @Override
    public String toString() {
        return "Movie: " + this.title +
                "\nDirector: " + this.director +
                "\nDuration: " + this.duration + " minutes" +
                "\nTicket Price: $" + this.ticketPrice;
    }
}


