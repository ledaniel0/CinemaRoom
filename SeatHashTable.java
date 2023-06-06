package FinalProject;

import java.util.HashMap;

public class SeatHashTable {
    private HashMap<String, Seat> seats;

    public SeatHashTable() {
        seats = new HashMap<>();
    }

    public boolean isEmpty() {
        return seats.isEmpty();
    }

    public void addSeat(Seat seat) {
        String key = generateKey(seat.getRow(), seat.getColumn());
        seats.put(key, seat);
    }

    public Seat findSeat(int row, int column) {
        String key = generateKey(row, column);
        return seats.get(key);
    }

    private String generateKey(int row, int column) {
        return row + "-" + column;
    }
}
