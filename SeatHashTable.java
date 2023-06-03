package FinalProject;

import java.util.HashMap;

public class SeatHashTable {
    private HashMap<String, Seat> seats;

    public SeatHashTable() {
        seats = new HashMap<>();
        createSeats();
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

    private void createSeats() {
        int totalRows = 10;
        int seatsPerRow = 20;

        for (int row = 1; row <= totalRows; row++) {
            for (int column = 1; column <= seatsPerRow; column++) {
                Seat seat = new Seat(row, column);
                seat.setAvailable(true);
                addSeat(seat);
            }
        }
    }
}
