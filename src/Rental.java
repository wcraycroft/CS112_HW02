/* Rental.java
 * Author:  William Craycroft
 * Module:  2
 * Project: Homework 2, Project 1
 * Description:
 *
 *      Instance variables:
 *          mRentedMovie (Movie) - rented movie information (rating, id, title)
 *          mCustomerID (int) - customer ID number
 *          mDaysLate (int) - number of days overdue (negative if not yet due)
 *
 *      Methods:
 *          Constructors
 *              Default constructor sets instance variables to 0 and default Movie
 *              Parameterized constructor taking rating, id and title as parameters
 *          setters and getters for all instance variables
 *          toString() - String with customer ID, days late, and Movie information (rating, id, title)
 *          equals(Object) - true if member variables are equal
 *          calcLateFees - calculates late fees using helper method from Movie class
 */

import java.text.NumberFormat;

public class Rental {

    // NumberFormat
    NumberFormat currency = NumberFormat.getCurrencyInstance();

    // Member variables
    private Movie mRentedMovie;
    private int mCustomerID;
    private int mDaysLate;

    // Default constructor
    public Rental() {
        mRentedMovie = new Movie();
        mCustomerID = 0;
        mDaysLate = 0;
    }
    // Parameterized constructor
    public Rental(Movie rentedMovie, int customerID, int daysLate) {
        mRentedMovie = rentedMovie;
        mCustomerID = customerID;
        mDaysLate = daysLate;
    }

    // Getters
    public Movie getRentedMovie() {
        return mRentedMovie;
    }
    public int getCustomerID() {
        return mCustomerID;
    }
    public int getDaysLate() {
        return mDaysLate;
    }

    // Setters
    public void setRentedMovie(Movie rentedMovie) {
        mRentedMovie = rentedMovie;
    }
    public void setCustomerID(int customerID) {
        mCustomerID = customerID;
    }
    public void setDaysLate(int daysLate) {
        mDaysLate = daysLate;
    }

    // toString() - e.g., Movie[ID, Title, Rating]
    public String toString() {
        return "Movie Rental [Customer ID=" + mCustomerID
                + ", Movie Title=" + mRentedMovie.getTitle()
                + ", Class=" + mRentedMovie.getClass().getName()
                + ", Movie ID=" + mRentedMovie.getID()
                + ", MPAA Rating=" + mRentedMovie.getRating()
                + ", Movie ID=" + mDaysLate
                + ", Late Fees=" + currency.format(calcLateFees()) + "]";
    }

    // equals() - checks for equal id's
    public boolean equals(Object anObject) {
        if ((anObject == null) || getClass() != anObject.getClass())
            return false;
        Rental otherRental = (Rental) anObject;
        return (mRentedMovie.equals(otherRental.mRentedMovie) &&
                mCustomerID == otherRental.mCustomerID &&
                mDaysLate == otherRental.mDaysLate);
    }

    // Helper methods
    // calcLateFees() - takes input of number of days and returns the late fee
    public double calcLateFees() {
        return mRentedMovie.calcLateFees(mDaysLate);
    }
}