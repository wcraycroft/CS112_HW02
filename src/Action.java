/* Action.java
 * Author:  William Craycroft
 * Module:  2
 * Project: Homework 2, Project 1
 * Description:
 *
 *      Methods:
 *          Constructors
 *              Default constructor sets instance variables to ""
 *              Parameterized constructor taking rating, id and title as parameters
 *          toString() - String with rating, ID and title
 *          calcLateFees - takes input of number of days and returns the late fee
 */

public class Action extends Movie {

    // Constants
    public static final double ACTION_LATE_FEE = 3.0;

    // Default constructor
    public Action() {
        super();
    }
    // Parameterized constructor
    public Action(String rating, String id, String title) {
        super(rating, id, title);
    }

    // toString() - e.g., Action Movie[ID, Title, Rating]
    public String toString() {
        return "Action " + super.toString();
    }

    // Helper methods
    // calcLateFees() - takes input of number of days and returns the late fee
    public double calcLateFees(int numberOfDays) {
        if (numberOfDays > 0) {
            return numberOfDays * ACTION_LATE_FEE;
        } else {
            return 0.0;
        }
    }
}
