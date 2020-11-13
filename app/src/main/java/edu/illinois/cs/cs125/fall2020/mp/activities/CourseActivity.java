package edu.illinois.cs.cs125.fall2020.mp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.illinois.cs.cs125.fall2020.mp.R;
import edu.illinois.cs.cs125.fall2020.mp.databinding.ActivityCourseBinding;
import edu.illinois.cs.cs125.fall2020.mp.models.Course;
import edu.illinois.cs.cs125.fall2020.mp.models.Summary;


/**
 * Opens new Activity.
 */
public class CourseActivity extends AppCompatActivity {
  private static final String TAG = CourseActivity.class.getSimpleName();

  private ActivityCourseBinding binding;

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
      Log.d("hi", "2?!");
      ObjectMapper mapper = new ObjectMapper();
      Log.d("hi", "3?!");
      String json = intent.getStringExtra("COURSE");
      System.out.println(json);
      Log.d("hi", "4?!");
      Course courseFromSummary = mapper.readValue(json, Course.class);
      Log.d("hi", "5?!");
      //binding.textView.setText(courseFromSummary.nameString());
    } catch (Exception e) { }
  }
}
