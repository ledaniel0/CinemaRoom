public class MovieLinkedList {
    private MovieNode head;

    // Constructor to initialize the MovieLinkedList object
    public MovieLinkedList() {
        head = null;
    }

    // Add a movie to the linked list
    public void addMovie(Movie movie) {
        MovieNode newNode = new MovieNode(movie);
        if (head == null) {
            head = newNode;
        } else {
            MovieNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public boolean removeMovie(String movieTitle) {
        Movie movie = searchMovie(movieTitle);
        if (movie == null) {
            return false;
        }
        if (head == null) {
            return true;
        }

        if (head.movie == movie) {
            head = head.next;
        } else {
            MovieNode current = head;
            while (current.next != null && current.next.movie != movie) {
                current = current.next;
            }
            if (current.next != null) {
                current.next = current.next.next;
            }
        }
        return true;
    }

    public Movie searchMovie(String movieTitle) {
        MovieNode current = head;
        while (current != null) {
            if (movieTitle.equalsIgnoreCase(current.movie.getTitle())) {
                return current.movie;
            }
            current = current.next;
        }
        return null;
    }

    // Traverse and print the linked list of movies
    public void traverseStats() {
        MovieNode current = head;
        while (current != null) {
            System.out.println("Movie: " + current.movie.getTitle());
            System.out.println("Ticket Sales: " + current.movie.getTicketSales());
            System.out.println("Revenue: $" + current.movie.getRevenue());
            System.out.println("-------------------------");
            current = current.next;
        }
    }

    public void printFilteredMovies(String genre) {
        MovieNode current = head;
        boolean foundMovies = false;

        while (current != null) {
            if (current.movie.getGenre().equalsIgnoreCase(genre)) {
                System.out.println(current.movie.toString());
                foundMovies = true;
            }
            current = current.next;
        }

        if (!foundMovies) {
            System.out.println("No movies found in the specified genre.");
        }
    }

    public void showMovieRatings() {
        MovieNode current = head;

        while (current != null) {
            System.out.println("Movie: " + current.movie.getTitle());
            System.out.println("Average Rating: " + current.movie.getAverageRating());
            System.out.println("Reviews:");
            current.movie.getReviews().forEach(review -> System.out.println(review));
            System.out.println("-------------------------");
            current = current.next;
        }
    }

    public String toString() {
        MovieNode current = head;
        String movies = "";
        while (current != null) {
            movies += current.movie.toString();
            movies += "\n";
            current = current.next;
        }
        return movies;
    }

    // Inner class representing a node in the linked list
    private class MovieNode {
        private Movie movie;
        private MovieNode next;

        public MovieNode(Movie movie) {
            this.movie = movie;
            this.next = null;
        }

        public Movie getMovie() {
            return movie;
        }

    }
}
