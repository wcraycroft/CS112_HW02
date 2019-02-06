/* Movie.java
 * Author:  William Craycroft
 * Module:  2
 * Project: Homework 2, Project 1
 * Description:
 *
 *      Instance variables:
 *          mRating (String) - MPAA rating (e.g., R, G, PG-13)
 *          mID (String) - ID number
 *          mTitle (String) - movie title
 *
 *      Methods:
 *          Constructors
 *              Default constructor sets instance variables to ""
 *              Parameterized constructor taking rating, id and title as parameters
 *          setters and getters for all instance variables
 *          toString() - String with rating, ID and title
 *          equals(Object) - true if ID numbers are identical
 *          calcLateFees - takes input of number of days and returns the late fee
 */

public class Movie {

    // Constants
    public static final double DEFAULT_LATE_FEE = 2.0;

    // Member variables
    private String mRating;
    private String mID;
    private String mTitle;

    // Default constructor
    public Movie() {
        mRating = "";
        mID = "";
        mTitle = "";
    }
    // Parameterized constructor
    public Movie(String rating, String id, String title) {
        mRating = rating;
        mID = id;
        mTitle = title;
    }

    // Getters
    public String getRating() {
        return mRating;
    }
    public String getID() {
        return mID;
    }
    public String getTitle() {
        return mTitle;
    }

    // Setters
    public void setRating(String rating) {
        mRating = rating;
    }
    public void setID(String id) {
        mID = id;
    }
    public void setTitle(String title) {
        mTitle = title;
    }

    // toString() - e.g., Movie[ID, Title, Rating]
    public String toString() {
        return "Movie[ID=" + mID + ", Title=" + mTitle + ", Rating=" + mRating + "]";
    }

    // equals() - checks for equal id's
    public boolean equals(Object anObject) {
        if ((anObject == null) || getClass() != anObject.getClass())
            return false;
        Movie otherMovie = (Movie) anObject;
        return (mID.equals(otherMovie.mID));
    }

    // Helper methods
    // calcLateFees() - takes input of number of days and returns the late fee
    public double calcLateFees(int numberOfDays) {
        if (numberOfDays > 0) {
            return numberOfDays * DEFAULT_LATE_FEE;
        } else {
            return 0.0;
        }
    }
}
