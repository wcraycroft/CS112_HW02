/* RentalDemo.java
 * Author:  William Craycroft
 * Module:  2
 * Project: Homework 2, Project 1
 * Problem Statement: This class demonstrates the functionality of the Rental and Movie classes and their use of
 *      polymorphism in their derived classes.
 *
 * Algorithm / Plan:
 *      1. Create two arrays, one with 6 elements of variable type Movie and another with 5 of type Rental
 *      2. Instantiate each Movie element to a new Movie, Action, Comedy or Drama object.
 *      3. Instantiate each Rental element to a new Rental, using Movie objects from first array.
 *      4. Prompt user to select whether they would like to see overdue movies only. Set boolean accordingly.
 *      5. Print header of report table.
 *      6. Go to first element in Rental array
 *      7. If rental is not overdue and user has selected to show only overdue rentals, go to Step 9
 *      8. Print rental number, customer ID, title, class, movie ID, rating, days late and late fees.
 *      9. Repeat Step 7-8 for all Rentals in Rental array.
 *      10. Start a running sum for total late fees due.
 *      11. For each Rental in array, call helper method to calculate late fee and add value to sum.
 *      12. Print total late fees.
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

        // Populate array with Movie and its subclasses
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
        rentals[4] = new Rental(movies[4], 8382, 0);

        // Prompt user to display overdue movies only, checks for any input starting with 'y' or 'Y'
        System.out.print("Do you want to see just overdue movies <y=yes>? ");
        overdueOnly = keyboard.nextLine().substring(0,1).equalsIgnoreCase("y");

        // Set up report table
        System.out.println("Rental Customer                                 Movie     MPAA   Days   Late ");
        System.out.println("  No.     ID       Movie Title         Class      ID     Rating  Late   Fees ");
        System.out.println("------ ------ ---------------------- -------- ---------- ------ ----- -------");
        // Loop through rentals array
        for (int i = 0; i < rentals.length; i++)
        {
            // if overdueOnly, skip movies that have <= 0 days overdue
            if (overdueOnly && rentals[i].getDaysLate() <= 0) {
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

    // Loops through rentals in the array and returns sum of late fees
    public static double lateFeesOwed(Rental[] rentalArray) {
        double sum = 0.0;
        for (Rental r : rentalArray) {
            sum += r.calcLateFees();
        }
        return sum;
    }
}
