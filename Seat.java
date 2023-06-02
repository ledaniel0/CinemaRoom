package FinalProject;

public class Seat {
    private int row;
    private int column;
    private boolean available;
    public Seat next;

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

    public boolean getSold(Seat seat) {
        if (!seat.isAvailable()) {
            return true;
        }
        return false;
    }

    public void setSold() {
        this.available = false;
    }
}

