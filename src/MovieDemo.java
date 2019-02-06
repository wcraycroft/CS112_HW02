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

public class MovieDemo {

    public static void main (String[] args) {
        // Declare Movies array
        Movie[] movies = new Movie[4];
        // Populate array with Movie and its children
        movies[0] = new Movie("PG", "A12345", "Frozen");
        movies[1] = new Action();        // test default constructor
        movies[2] = new Comedy("PG-13", "C54321", "Meet the Parents");
        movies[3] = new Drama("R", "X32154", "Basic Instinct");
        // Loop through array
        for (int i = 0; i < movies.length; i++) {
            // test toString()
            System.out.println(movies[i].toString());
            // test calcLateFees
            System.out.println("Late fee = " + movies[i].calcLateFees(5));
        }
    }
}
