package FinalProject;

/**
 * Represents a customer review for a movie, including the customer's name, email,
 * rating, and comment.
 * The Review class extends the Customer class to inherit the customer information.
 * It provides methods to retrieve the rating and comment for the review.
 */

public class Review extends Customer {
    private int rating;
    private String comment;

    /**
     * Initializes a new Review object with the specified customer information, rating,
     * and comment.
     * Pre: The name parameter is not null or empty.
     * The email parameter is a valid email address.
     * The rating parameter is an integer between 1 and 5 (inclusive).
     * The comment parameter is not null or empty.
     * Post: A new Review object is created with the specified customer information, rating,
     * and comment.
     */
    public Review(String name, String email, int rating, String comment) {
        super(name, email);
        this.rating = rating;
        this.comment = comment;
    }

    /**
     * Retrieves the rating of the review.
     * Pre: None.
     * Post: The rating of the review is returned.
     *
     * @return The rating of the review.
     */
    public int getRating() {
        return rating;
    }

    /**
     * Retrieves the comment of the review.
     * Pre: None.
     * Post: The comment of the review is returned.
     *
     * @return The comment of the review.
     */
    public String getComment() {
        return comment;
    }

    /**
     * Returns a string representation of the review, including the customer information,
     * rating, and comment.
     * Pre: None.
     * Post: A string representation of the review is returned.
     *
     * @return A string representation of the review.
     */
    @Override
    public String toString() {
        return super.toString() +
                "Rating: " + rating + "\n" +
                "Comment: " + comment + "\n";
    }
}
