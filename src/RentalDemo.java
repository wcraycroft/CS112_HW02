/* MovieDemo.java
 * Author:  William Craycroft
 * Module:  2
 * Project: Homework 2, Project 1
 * Problem Statement: This class demonstrates the functionality of the Movie class and its derived classes Action,
 *      Comedy and Drama.
 *
 * Algorithm / Plan:
 *      1. Create an array of 4 Movie object
 *      2. Instantiate each element to a new Movie, Action, Comedy and Drama object.
 *      3. For each element in Movie array, call toString and calcLateFees methods.
 */

import java.text.NumberFormat;
import java.util.Scanner;

public class RentalDemo {

    public static void main (String[] args) {

        // Create arrays of Movies and Rentals
        Movie[] movies = new Movie[6];
        Rental[] rentals = new Rental[5];
        // Instantiate Scanner and NumberFormat
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        Scanner keyboard = new Scanner(System.in);
        // If true, display only overdue movies
        boolean overdueOnly;

        // Populate array with Movie and its children
        movies[0] = new Movie("PG", "A12345", "Frozen");
        movies[1] = new Action("PG-13", "G15612", "Avengers");
        movies[2] = new Comedy("PG-13", "C54321", "Meet the Parents");
        movies[3] = new Drama("R", "X32154", "Basic Instinct");
        movies[4] = new Action("PG", "G15412", "Jumanji");
        movies[5] = new Comedy("R", "C52321", "Deadpool");
        // Populate rentals array
        rentals[0] = new Rental(movies[1], 5912, -5);
        rentals[1] = new Rental(movies[5], 1296, 12);
        rentals[2] = new Rental(movies[3], 8504, 7);
        rentals[3] = new Rental(movies[0], 1833, 2);
        rentals[4] = new Rental(movies[4], 8382, -6);

        // Prompt user to display overdue movies only
        System.out.print("Do you want to see just overdue movies <y=yes>? ");
        overdueOnly = keyboard.nextLine().equalsIgnoreCase("y");

        // Set up report table
        System.out.println("Rental Customer                                 Movie     MPAA   Days   Late ");
        System.out.println("  No.     ID       Movie Title         Class      ID     Rating  Late   Fees ");
        System.out.println("------ ------ ---------------------- -------- ---------- ------ ----- -------");
        // Loop through rentals array
        for (int i = 0; i < rentals.length; i++)
        {
            // if overdueOnly, skip movies that have < 0 days overdue
            if (overdueOnly && rentals[i].getDaysLate() < 0) {
                continue;
            }
            // else, print formatted rental information
            System.out.printf("%6d %6d %-22s %-8s %-10s %-6s %5d %7s%n", i + 1,
                    rentals[i].getCustomerID(),
                    rentals[i].getRentedMovie().getTitle(),
                    rentals[i].getRentedMovie().getClass().getName(),
                    rentals[i].getRentedMovie().getID(),
                    rentals[i].getRentedMovie().getRating(),
                    rentals[i].getDaysLate(),
                    currency.format(rentals[i].calcLateFees()));
        }
        // Print total late fees
        System.out.printf("%77s %n", "Total fees due:      " + currency.format(lateFeesOwed(rentals)));
    }

    // Loops through rentals in the array and adds together late fees
    public static double lateFeesOwed(Rental[] rentalArray) {
        double sum = 0;
        for (int i = 0; i < rentalArray.length; i++) {
            sum += rentalArray[i].calcLateFees();
        }
        return sum;
    }
}
