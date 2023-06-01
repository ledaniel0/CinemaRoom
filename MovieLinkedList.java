package FinalProject

public class MovieLinkedList {
    private Movie head;

    public MovieLinkedList() {
        this.head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addMovie(Movie movie) {
        if (isEmpty()) {
            head = movie;
        } else {
            Movie current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(movie);
        }
    }

    public void removeMovie(Movie movie) {
        if (isEmpty()) {
            return;
        }
        
        if (head == movie) {
            head = head.getNext();
            return;
        }

        Movie current = head;
        while (current.getNext() != null) {
            if (current.getNext() == movie) {
                current.setNext(movie.getNext());
                break;
            }
            current = current.getNext();
        }
    }

    // Other methods for traversing, searching, and manipulating the movie linked list
}
