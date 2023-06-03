package FinalProject;

/*
    use a map
        the key will be a string for the movie
        each key will be a seat
        [][][][][][][][][][][][][]
        [][][][][][][][][][][][][]
 */
public class SeatLinkedList {
    private Seat head;

    public SeatLinkedList() {
        this.head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addSeat(Seat seat) {
        if (isEmpty()) {
            head = seat;
        } else {
            Seat current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = seat;
        }
    }

    public void removeSeat(Seat seat) {
        if (head == null) {
            return;
        }

        if (head == seat) {
            head = head.next;
        } else {
            Seat current = head;
            Seat previous = null;
            while (current != null && current != seat) {
                previous = current;
                current = current.next;
            }
            if (current != null) {
                previous.next = current.next;
            }
        }
    }

    public Seat findSeat(int row, int column) {
        Seat current = head;
        while (current != null) {
            if (current.getRow() == row && current.getColumn() == column) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
}
