package dev.rabiulhassan.explore_llms;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    private static final String PREFS_NAME = "LLMRatings";
    private SharedPreferences preferences;
    private String llmName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        
        // Get data from intent
        llmName = getIntent().getStringExtra("llm_name");
        String description = getIntent().getStringExtra("llm_description");
        int imageResId = getIntent().getIntExtra("llm_image", 0);

        // Initialize views
        ImageView imageView = findViewById(R.id.detail_image);
        TextView nameTextView = findViewById(R.id.detail_name);
        TextView descTextView = findViewById(R.id.detail_description);
        RatingBar ratingBar = findViewById(R.id.rating_bar);
        VideoView videoView = findViewById(R.id.video_view);

        // Set data to views
        imageView.setImageResource(imageResId);
        nameTextView.setText(llmName);
        descTextView.setText(description);

        // Load saved rating
        float savedRating = preferences.getFloat(llmName, 0.0f);
        ratingBar.setRating(savedRating);

        // Set up rating listener
        ratingBar.setOnRatingBarChangeListener((ratingBar1, rating, fromUser) -> {
            if (fromUser) {
                saveRating(rating);
            }
        });        // Set up video if available
        if (llmName.equals(getString(R.string.chatgpt_name))) {
            try {
                Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.chatgpt_video);
                videoView.setVideoURI(videoUri);
                videoView.setOnPreparedListener(mp -> {
                    videoView.setVisibility(View.VISIBLE);
                    videoView.start();
                });
                videoView.setOnErrorListener((mp, what, extra) -> {
                    videoView.setVisibility(View.GONE);
                    return true;
                });
            } catch (Exception e) {
                videoView.setVisibility(View.GONE);
            }
        } else {
            videoView.setVisibility(View.GONE);
        }

        // Set up back button
        findViewById(R.id.back_button).setOnClickListener(v -> finish());
    }

    private void saveRating(float rating) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putFloat(llmName, rating);
        editor.apply();
    }
}
