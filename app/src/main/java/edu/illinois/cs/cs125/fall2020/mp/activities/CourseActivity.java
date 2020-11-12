package edu.illinois.cs.cs125.fall2020.mp.activities;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


/**
 * Opens new Activity.
 */
public class CourseActivity extends AppCompatActivity {
  private static final String TAG = CourseActivity.class.getSimpleName();

  /**
   * do it.
   * @param savedInstanceState
   */
  @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
    Log.i(TAG, "Course Activity Started");

    super.onCreate(savedInstanceState);
  }
}
