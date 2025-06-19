package dev.rabiulhassan.explore_llms;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;

public class LandingActivity extends AppCompatActivity {
    private static final String TAG = "LandingActivity";
    private MediaPlayer mediaPlayer;
    private boolean isNavigating = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            Log.d(TAG, "Starting onCreate");
            setContentView(R.layout.activity_landing);
            Log.d(TAG, "Content view set");

            // Initialize background music
            try {
                mediaPlayer = MediaPlayer.create(this, R.raw.background_music);
                if (mediaPlayer != null) {
                    mediaPlayer.setLooping(true);
                    mediaPlayer.start();
                    Log.d(TAG, "MediaPlayer started successfully");
                } else {
                    Log.w(TAG, "MediaPlayer creation returned null");
                }
            } catch (Exception e) {
                Log.e(TAG, "Error initializing MediaPlayer", e);
            }

            // Set button click to navigate
            Button proceedButton = findViewById(R.id.proceed_button);
            if (proceedButton != null) {
                proceedButton.setOnClickListener(v -> navigateToList());
                Log.d(TAG, "Proceed button listener set");
            }

            // Animate title and button
            TextView titleView = findViewById(R.id.app_title);
            Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.bounce_in_bottom);
            if (titleView != null) titleView.startAnimation(fadeIn);
            if (proceedButton != null) proceedButton.startAnimation(fadeIn);

        } catch (Exception e) {
            Log.e(TAG, "Error in onCreate", e);
            finish();
        }
    }

    private void navigateToList() {
        if (!isFinishing() && !isNavigating) {
            try {
                isNavigating = true;
                Log.d(TAG, "Starting navigation to ListActivity");
                Intent intent = new Intent(this, ListActivity.class);
                startActivity(intent);
                finish();
                Log.d(TAG, "Navigation to ListActivity complete");
            } catch (Exception e) {
                Log.e(TAG, "Error navigating to ListActivity", e);
                isNavigating = false;
            }
        }
    }

    @Override
    protected void onDestroy() {
        try {
            super.onDestroy();
            if (mediaPlayer != null) {
                mediaPlayer.release();
                mediaPlayer = null;
                Log.d(TAG, "MediaPlayer released");
            }
        } catch (Exception e) {
            Log.e(TAG, "Error in onDestroy", e);
        }
    }
}
