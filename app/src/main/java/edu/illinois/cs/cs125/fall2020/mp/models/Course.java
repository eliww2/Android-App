package edu.illinois.cs.cs125.fall2020.mp.models;
/** thing.
* Course extends Summary
 */
public class Course extends Summary {

    /** Create an empty Summary. *
     *
     *
     */
  public Course() {}


  private String description;
    /** Create constructor.
     *
     * @param setDescription set
     **/
  public Course(final String setDescription) {
    description = setDescription;
  }


    /**
     *
     * @return description
     **/
  public String getDescription() {
    return description;
  }
}
