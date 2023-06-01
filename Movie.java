package FinalProject;

public class Movie {
    private String title;
    private String director;
    private int duration;
    private double revenue;
    public Movie next;

    // Constructor to initialize the Movie object
    public Movie(String title, String director, int duration) {
        this.title = title;
        this.director = director;
        this.duration = duration;
        this.revenue = 0;
        this.next = null;
    }

    public void addToRevenue(double price) {
        this.revenue += price;
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
                "\nDuration: " + this.duration + " minutes";
    }
}

