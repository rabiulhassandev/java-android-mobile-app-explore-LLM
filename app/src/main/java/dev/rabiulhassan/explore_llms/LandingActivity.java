package dev.rabiulhassan.explore_llms;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class LandingActivity extends AppCompatActivity {
    private static final String TAG = "LandingActivity";
    private static final int SPLASH_TIMEOUT = 3000; // 3 seconds
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

            // Set click listener to skip splash screen
            View rootView = findViewById(R.id.landing_root);
            if (rootView != null) {
                rootView.setOnClickListener(v -> navigateToList());
                Log.d(TAG, "Click listener set");
            } else {
                Log.e(TAG, "Could not find landing_root view");
            }

            // Auto navigate after timeout
            new Handler().postDelayed(this::navigateToList, SPLASH_TIMEOUT);
            Log.d(TAG, "Auto-navigation timer set");
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
