/* Drama.java
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

public class Drama extends Movie {

    // Constants
    public static final double DRAMA_LATE_FEE = 2.0;

    // Default constructor
    public Drama() {
        super();
    }
    // Parameterized constructor
    public Drama(String rating, String id, String title) {
        super(rating, id, title);
    }

    // toString() - e.g., Drama Movie[ID, Title, Rating]
    public String toString() {
        return "Drama " + super.toString();
    }

    // Helper methods
    // calcLateFees() - takes input of number of days and returns the late fee
    public double calcLateFees(int numberOfDays) {
        if (numberOfDays > 0) {
            return numberOfDays * DRAMA_LATE_FEE;
        } else {
            return 0.0;
        }
    }
}
