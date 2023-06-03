package FinalProject;

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

    // Remove a movie from the linked list
    public void removeMovie(Movie movie) {
        if (head == null) {
            return;
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

    public String toString() {
        MovieNode current = head;
        String movies = "";
        while (current != null) {
            movies += current.movie.toString();
            current = current.next;
        }
        return movies;
    }

    // Inner class representing a node in the linked list
    private class MovieNode {
        private Movie movie;
        private MovieNode next;

        // Constructor to initialize the MovieNode object
        public MovieNode(Movie movie) {
            this.movie = movie;
            this.next = null;
        }
    }
}



