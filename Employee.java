package FinalProject;

import java.util.Scanner;

public class Employee {
    private final String USERNAME = "admin";
    private final String PASSWORD = "admin";
    private MovieLinkedList movieList;

    public Employee(MovieLinkedList movieList) {
        this.movieList = movieList;
    }

    public boolean login(Scanner scanner) {
        System.out.println("Employee Login");
        System.out.println("Enter your USERNAME:");
        String enteredUsername = scanner.nextLine();
        System.out.println("Enter your PASSWORD:");
        String enteredPassword = scanner.nextLine();

        if (enteredUsername.equals(USERNAME) && enteredPassword.equals(PASSWORD)) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Invalid USERNAME or PASSWORD. Login failed.");
            return false;
        }
    }

    public void addMovie(Scanner scanner) {
        System.out.println("Enter the movie title:");
        String title = scanner.nextLine();
        System.out.println("Enter the movie director:");
        String director = scanner.nextLine();
        System.out.println("Enter the movie genre:");
        String genre = scanner.nextLine();
        System.out.println("Enter the movie duration (in minutes):");
        int duration = scanner.nextInt();
        System.out.println("Enter the movie ticket price:");
        double ticketPrice = scanner.nextDouble();
        scanner.nextLine();

        Movie newMovie = new Movie(title, director, genre, duration, ticketPrice);
        movieList.addMovie(newMovie);

        System.out.println("Movie added successfully.");
    }

    public void removeMovie(Scanner scanner) {
        System.out.println("Enter the movie title to remove:");
        String title = scanner.nextLine();

        boolean removed = movieList.removeMovie(title);

        if (removed) {
            System.out.println("Movie removed successfully.");
        } else {
            System.out.println("Movie not found.");
        }
    }

    public void fixMoviePrice(Scanner scanner) {
        System.out.println("Enter the movie title to fix the price:");
        String title = scanner.nextLine();

        Movie movie = movieList.searchMovie(title);

        if (movie != null) {
            System.out.println("Enter the new ticket price:");
            double newPrice = scanner.nextDouble();
            scanner.nextLine();
            movie.setTicketPrice(newPrice);
            System.out.println("Movie price updated successfully.");
        } else {
            System.out.println("Movie not found.");
        }
    }
}

