package FinalProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CinemaRoomManager {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        Scanner scanner = new Scanner(System.in);

        /*
        file format:
        title director duration ticketPrice

        use try catch
         */
        try {
            File file = new File("movies.txt");
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()) {
                String info = fileReader.nextLine();
                String[] arr = info.split(" ");
                Movie movie = new Movie(arr[0], arr[1], Integer.parseInt(arr[2]), Double.parseDouble(arr[3]));
                cinema.getMovies().addMovie(movie);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }

        while (true) {
            System.out.println("Welcome to the Cinema Room Manager!");
            System.out.println("Please choose an action");
            System.out.println("1: Look at Movie Schedule");
            System.out.println("2: Buy a ticket");
            System.out.println("3: Show Movie statistics");
            System.out.println("0: Exit");

            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("Movies:");
                    cinema.printMovieSchedule();
                    System.out.println();
                    break;
                case 2:
                    /*
                    passes in the movie title
                    user types in the movie title
                    loops through linkedlist searching for movie

                    if a movie is found, print out the seats
                    the user will select a seat, if the seat is available,
                    ask the user how much money they have, if it is greater than
                    the ticketPrice of the movie, print enjoy your movie

                     */
                    System.out.println("Enter the movie title:");
                    Scanner buyTicket = new Scanner(System.in);
                    String movieTitle = buyTicket.nextLine();
                    Movie buyMovie = cinema.getMovies().searchMovie(movieTitle);
                    if (buyMovie != null) {
                        //print out the seats, then ask which row and then which column
                        System.out.println("What row would you like?");
                        int row = buyTicket.nextInt();
                        System.out.println("What column would you like?");
                        int column = buyTicket.nextInt();
                        Seat selectedSeat = new Seat(row, column, buyMovie);
                        // ask the user what their name and email is
                        System.out.println("What is your name?");
                        String name = buyTicket.nextLine();
                        System.out.println("What is your email?");
                        String email = buyTicket.nextLine();
                        Customer buyingCustomer = new Customer(name, email);
                        if (cinema.isSeatAvailable(buyMovie, row, column)) {
                            cinema.sellTicket(buyMovie, selectedSeat, buyingCustomer);
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid Choice. Pick another action");
                    break;
            }
        }
    }
}

