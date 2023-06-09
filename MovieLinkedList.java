package FinalProject;

/**
 * The MovieLinkedList class represents a linked list of movies. It provides methods to add and remove movies, search for
 * movies by title, traverse and print movie statistics, print movies based on a specified genre, display movie ratings,
 * and convert the linked list to a string representation.
 * The linked list is sorted based on the start time of the movies, ensuring that they are stored in chronological order.
 * Each movie is encapsulated within a MovieNode, which contains a reference to the next node in the list.
 */
public class MovieLinkedList {
    private MovieNode head;

    /**
     * Constructs an empty MovieLinkedList object.
     * The head is initialized to null, indicating an empty list.
     */
    public MovieLinkedList() {
        head = null;
    }

    /**
     * Adds a new movie to the linked list in a sorted manner based on the movie's start time.
     * If the movie's start time is earlier than or equal to the head node's start time, the new movie becomes the new head.
     * Otherwise, it is inserted at the appropriate position in the sorted list.
     *
     * @param movie The movie to be added to the linked list.
     * @pre The movie parameter must not be null.
     * @post The movie is added to the linked list at the appropriate position based on the start time.
     */
    public void addMovie(Movie movie) {
        assert movie != null : "Movie cannot be null.";

        MovieNode newNode = new MovieNode(movie);

        if (head == null || head.movie.getStartTime().compareTo(newNode.movie.getStartTime()) >= 0) {
            newNode.next = head;
            head = newNode;
        } else {
            MovieNode current = head;
            while (current.next != null && current.next.getStartTime().compareTo(newNode.getStartTime()) < 0) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    /**
     * Removes a movie with the specified title from the linked list.
     * If the movie is found, it is removed from the list. If it is the head node, the head is updated.
     * Otherwise, the movie node is removed by adjusting the next reference of the previous node.
     *
     * @param movieTitle The title of the movie to be removed.
     * @return True if the movie is found and removed, false otherwise.
     * @pre The movieTitle parameter must not be null.
     * @post If the movie with the specified title is found, it is removed from the linked list.
     */
    public boolean removeMovie(String movieTitle) {
        assert movieTitle != null : "Movie title cannot be null.";

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

    /**
     * Searches for a movie with the specified title in the linked list.
     * If the movie is found, a reference to the movie object is returned. Otherwise, null is returned.
     *
     * @param movieTitle The title of the movie to search for.
     * @return The Movie object if found, null otherwise.
     * @pre The movieTitle parameter must not be null.
     * @post None.
     */
    public Movie searchMovie(String movieTitle) {
        assert movieTitle != null : "Movie title cannot be null.";

        MovieNode current = head;
        while (current != null) {
            if (movieTitle.equalsIgnoreCase(current.movie.getTitle())) {
                return current.movie;
            }
            current = current.next;
        }
        return null;
    }

    /**
     * Traverses the linked list and prints the statistics for each movie, including the title, ticket sales, and revenue.
     *
     * @pre None.
     * @post None.
     */
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

    /**
     * Prints the movies in the linked list that belong to the specified genre.
     * If no movies are found in the genre, a corresponding message is displayed.
     *
     * @param genre The genre of the movies to be printed.
     * @pre The genre parameter must not be null.
     * @post None.
     */
    public void printFilteredMovies(String genre) {
        assert genre != null : "Genre cannot be null.";

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

    /**
     * Displays the ratings for each movie in the linked list, including the average rating and reviews.
     *
     * @pre None.
     * @post None.
     */
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

    /**
     * Returns a string representation of the movies in the linked list.
     * Each movie is represented by its string representation obtained from the Movie class.
     *
     * @return The string representation of the movies in the linked list.
     * @pre None.
     * @post None.
     */
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

    /**
     * The MovieNode class represents a node in the MovieLinkedList.
     * It encapsulates a Movie object and contains a reference to the next node in the list.
     */
    private static class MovieNode {
        private Movie movie;
        private MovieNode next;

        /**
         * Constructs a MovieNode object with the specified movie and null next reference.
         *
         * @param movie The Movie object to be encapsulated in the node.
         */
        public MovieNode(Movie movie) {
            this.movie = movie;
            this.next = null;
        }

        /**
         * Returns the movie encapsulated in the node.
         *
         * @return The Movie object.
         */
        public Movie getMovie() {
            return movie;
        }

        /**
         * Returns the start time of the movie encapsulated in the node.
         *
         * @return The start time of the movie.
         */
        public String getStartTime() {
            return movie.getStartTime();
        }
    }
}
