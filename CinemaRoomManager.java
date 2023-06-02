package FinalProject;

import java.util.Scanner;

public class CinemaRoomManager {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        Scanner scanner = new Scanner(System.in);
        
        cinema.getMovies().addMovie();

        while (true) {
            System.out.println("Welcome to the Cinema Room Manager!");
            System.out.println("Please choose a number");
            System.out.println("1: Look at Movie Schedule");
            System.out.println("2: Buy a ticket");
            System.out.println("3: Show Movie statistics");
            System.out.println("0: Exit");

            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("Movies:");
                    cinema.getMovieSchedule();
            }
        }
    }
}
