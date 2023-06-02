package FinalProject;

  class SeatLinkedList {
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
                while (current.getNext() != null) {
                    current = current.getNext();
                }
                current.setNext(seat);
            }
        }

        public void removeSeat(Seat seat) {
            if (head == null) {
                return;
            }

            if (head == seat) {
                head = head.getNext();
            } else {
                Seat current = head;
                Seat previous = null;
                while (current != null && current != seat) {
                    previous = current;
                    current = current.getNext();
                }
                if (current != null) {
                    previous.setNext(current.getNext());
                }
            }
        }

        public void traverse() {
            Seat current = head;
            while (current != null) {
                current = current.getNext();
            }
        }

        public Seat searchSeat(int row, int column) {
            Seat current = head;
            while (current != null) {
                if (current.getRow() == row && current.getColumn() == column) {
                    return current;
                }
                current = current.getNext();
            }
            return null;
        }

    }
}

