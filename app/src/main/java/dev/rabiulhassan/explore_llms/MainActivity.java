package dev.rabiulhassan.explore_llms;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            Log.d(TAG, "Starting onCreate");
            setContentView(R.layout.activity_main);
            
            // Add a small delay before launching LandingActivity to ensure proper initialization
            new android.os.Handler().postDelayed(() -> {
                try {
                    Log.d(TAG, "Launching LandingActivity");
                    Intent intent = new Intent(MainActivity.this, LandingActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                    Log.e(TAG, "Error launching LandingActivity", e);
                }
            }, 500);
        } catch (Exception e) {
            Log.e(TAG, "Error in onCreate", e);
        }
    }
}