package FinalProject;

public class Seat {
    private int row;
    private int column;
    private boolean available;
    private Seat next;

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        this.available = true;
        this.next = null;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setNext(Seat next) {
        this.next = next;
    }
    
    public boolean setSeat(Seat seat) {
        if (seat.isAvailable()) {       
            return true; 
        }    
    return false; 
}
}
