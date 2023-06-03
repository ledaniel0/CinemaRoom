package FinalProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CinemaRoomManager {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        Scanner scanner = new Scanner(System.in);

        try {
            File file = new File("movies.txt");
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()) {
                String info = fileReader.nextLine();
                String[] arr = info.split(" ");
                Movie movie = new Movie(arr[0], arr[1], arr[2], Integer.parseInt(arr[3]), Double.parseDouble(arr[4]));
                cinema.getMovies().addMovie(movie);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }

        while (true) {
            System.out.println("Welcome to the Cinema Room Manager!");
            System.out.println("-------------------------");
            System.out.println("Please choose an action");
            System.out.println("1: Look at Movie Schedule");
            System.out.println("2: Buy a ticket");
            System.out.println("3: Show Movie statistics");
            System.out.println("4: Refund ticket");
            System.out.println("5: Review a Movie");
            System.out.println("6: View Movie Ratings");
            System.out.println("7: Search for a Movie");
            System.out.println("8: Filter Movies");
            System.out.println("9: Employee Login");
            System.out.println("0: Exit");
            System.out.println("-------------------------");
            System.out.print("Action: ");

            switch (scanner.nextInt()) {
                case 0:
                    System.out.println("Thank you for using Cinema Room Manager. We look forward to seeing you again. Goodbye!");
                    System.out.println("-------------------------");
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("Movies:");
                    System.out.println("-------------------------");
                    cinema.printMovieSchedule();
                    break;
                case 2:
                    cinema.buyTicket(scanner);
                    break;
                case 3:
                    cinema.showStatistics();
                    break;
                case 4:
                    cinema.refundTicket(scanner);
                    break;
                case 5:
                    cinema.rateAndReview(scanner);
                    break;
                case 6:
                    cinema.showMovieRatings();
                    break;
                case 7:
                    cinema.searchMovies(scanner);
                    break;
                case 8:
                    cinema.printFilteredMovies(scanner);
                    break;
                case 9:
                    System.out.println("Welcome Employee. What would you like to do?");
                    System.out.println("-------------------------");
                    System.out.println("1: Add Movie");
                    System.out.println("2: Remove Movie");
                    System.out.println("3: Fix Ticket Price");
                    System.out.println("0: Exit");
                    System.out.println("-------------------------");
                    System.out.print("Action: ");
                    int employeeAction = scanner.nextInt();
                    scanner.nextLine();
                    switch (employeeAction) {
                        case 0:
                            break;
                        case 1:
                            cinema.addMovie(scanner);
                            break;
                        case 2:
                            cinema.removeMovie(scanner);
                            break;
                        case 3:
                            cinema.fixMoviePrice(scanner);
                            break;
                        default:
                            System.out.println("Invalid Choice. Pick another action");
                            break;
                    }
                    break;
                default:
                    System.out.println("Invalid Choice. Pick another action");
                    break;
            }
        }
    }
}
