package com.tmarat.instagramclient.about;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.transition.ChangeBounds;
import android.transition.TransitionManager;
import android.view.View;
import android.view.animation.AnticipateOvershootInterpolator;
import com.tmarat.instagramclient.R;

public class AboutActivity extends AppCompatActivity {

  private boolean show = false;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_about);

    findViewById(R.id.backgroundImage).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        if (show) {
          hideComponents();
        } else {
          showComponents();
        }
      }
    });
  }

  private void showComponents() {
    show = true;

    ConstraintSet constraintSet = new ConstraintSet();
    constraintSet.clone(this, R.layout.activity_about_detail);

    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {

      ChangeBounds transition = new ChangeBounds();
      transition.setInterpolator(new AnticipateOvershootInterpolator(1.0f));
      transition.setDuration(1200);

      ConstraintLayout constraintLayout = findViewById(R.id.constraint);
      TransitionManager.beginDelayedTransition(constraintLayout, transition);

      //here constraint is the name of view to which we are applying the constraintSet
      constraintSet.applyTo(constraintLayout);
    }
  }

  private void hideComponents() {
    show = false;

    ConstraintSet constraintSet = new ConstraintSet();
    constraintSet.clone(this, R.layout.activity_about);

    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
      ChangeBounds transition = new ChangeBounds();
      transition.setInterpolator(new AnticipateOvershootInterpolator(1.0f));
      transition.setDuration(1200);

      ConstraintLayout constraintLayout = findViewById(R.id.constraint);
      TransitionManager.beginDelayedTransition(constraintLayout, transition);

      //here constraint is the name of view to which we are applying the constraintSet
      constraintSet.applyTo(constraintLayout);
    }
  }
}
