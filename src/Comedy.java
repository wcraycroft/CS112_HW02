/* Comedy.java
 * Author:  William Craycroft
 * Module:  2
 * Project: Homework 2, Project 1
 * Description:
 *
 *      Methods:
 *          Constructors
 *              Default constructor sets instance variables to 0 and ""
 *              Parameterized constructor taking rating, id and title as parameters
 *          toString() - String with rating, ID and title
 *          calcLateFees - takes input of number of days and returns the late fee
 */

public class Comedy extends Movie {

    // Constants
    public static final double COMEDY_LATE_FEE = 2.5;

    // Default constructor
    public Comedy() {
        super();
    }
    // Parameterized constructor
    public Comedy(String rating, String id, String title) {
        super(rating, id, title);
    }

    // toString() - e.g., Comedy Movie[ID, Title, Rating]
    public String toString() {
        return "Comedy " + super.toString();
    }

    // Helper methods
    // calcLateFees() - takes input of number of days and returns the late fee
    public double calcLateFees(int numberOfDays) {
        if (numberOfDays > 0) {
            return numberOfDays * COMEDY_LATE_FEE;
        } else {
            return 0.0;
        }
    }
}
