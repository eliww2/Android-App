package edu.illinois.cs.cs125.fall2020.mp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.illinois.cs.cs125.fall2020.mp.R;
import edu.illinois.cs.cs125.fall2020.mp.application.CourseableApplication;
import edu.illinois.cs.cs125.fall2020.mp.databinding.ActivityCourseBinding;
import edu.illinois.cs.cs125.fall2020.mp.models.Course;
import edu.illinois.cs.cs125.fall2020.mp.models.Rating;
import edu.illinois.cs.cs125.fall2020.mp.models.Summary;
import edu.illinois.cs.cs125.fall2020.mp.network.Client.CourseClientCallbacks;



/**
 * Opens new Activity.
 */
public class CourseActivity extends AppCompatActivity implements CourseClientCallbacks {
  private static final String TAG = CourseActivity.class.getSimpleName();

  private Course myCourse;
  private ActivityCourseBinding binding;
  private RatingBar myRating;
  private String clientID;
  private Summary summary;
  private CourseableApplication chickenNugget;
  private Rating rate;

  /**
   * do it.
   * @param savedInstanceState
   */

  @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);

    Intent intent = getIntent();
    binding = DataBindingUtil.setContentView(this, R.layout.activity_course);
    Log.d("hi", "1?!");
    try {
      ObjectMapper mapper = new ObjectMapper();
      String json = intent.getStringExtra("COURSE");
      Course courseFromSummary = mapper.readValue(json, Course.class);
      summary = mapper.readValue(json, Summary.class);


      System.out.println(summary.getDepartment());

      binding.titleView.setText(courseFromSummary.nameString());


      chickenNugget = (CourseableApplication) getApplication();

      myRating = (RatingBar) findViewById(R.id.rating);
      clientID = chickenNugget.getClientID();
      chickenNugget.getCourseClient().getRating(summary, clientID, this);
      binding.rating.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
        @Override
        public void onRatingChanged(final RatingBar ratingBar, final float rating, final boolean fromUser) {
          chickenNugget.getCourseClient().postRating(summary, new Rating(clientID, rating), CourseActivity.this);
          myRating.setRating(rating);
        }
      });
      chickenNugget.getCourseClient().getCourse(summary, this);
    } catch (Exception e) {
      Log.d("Uh-Oh", e + "thrown");
    }
  }

  /**
   * this sets my description.
   * @param setSummary
   * @param setCourse
   */
  @Override
  public void courseResponse(final Summary setSummary, final Course setCourse) {
    myCourse = setCourse;
    binding.descriptionView.setText(myCourse.getDescription());
  }

  /**
   * this is a youRating.
   * @param sum
   * @param rating
   */
  @Override
  public void yourRating(final Summary sum, final Rating rating) {
    rate = rating;
    float num = (float) rate.getRating();
    myRating.setRating(num);
  }
}
