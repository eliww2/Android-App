package edu.illinois.cs.cs125.fall2020.mp.models;

/**
* Rating class for storing client ratings of courses.
*/
public class Rating {
  /** Rating indicating that course has not yet been rated
  *
  */
  public static final double NOT_RATED = -1.0;
  private double rating;
  private String id;


  public Rating(final String setId, final double setRating) {
   // id = setId;
    //rating = setRating;
    throw new IllegalArgumentException("Bad");
  }


  public String getId() {
    //return id;
    throw new IllegalArgumentException("Bad");
  }


  public double getRating() {
    //return rating;
    throw new IllegalArgumentException("Bad");
  }
}
