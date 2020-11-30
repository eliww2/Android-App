package edu.illinois.cs.cs125.fall2020.mp.models;

//import java.util.UUID;

//import edu.illinois.cs.cs125.fall2020.mp.application.CourseableApplication;

/**
* Rating class for storing client ratings of courses.
*/
public class Rating {
  /** Rating indicating that course has not yet been rated.
  *
  */
  public static final double NOT_RATED = -1.0;
  private double rating;
  private String id;

  /**
   * Unused constructor.
   */
  public Rating() { }

  /**
   * Sets rating.
   * @param setId
   * @param setRating
   */
  public Rating(final String setId, final double setRating) {
    id = setId;
    rating = setRating;

  }

  /**
   * getId.
   * @return id
   */
  public String getId() {
    return id;

  }

  /**
   * be Safe.
   * @return rating.
   */
  public double getRating() {
    return rating;

  }
}
