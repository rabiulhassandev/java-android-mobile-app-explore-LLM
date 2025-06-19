package dev.rabiulhassan.explore_llms;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DetailActivity extends AppCompatActivity {

    private ImageView bannerImageView, logoImageView;
    private TextView titleTextView, releaseDateTextView, descriptionTextView, historyTextView, ratingValueTextView;
    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Set up toolbar with back navigation
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v -> finish());

        // Bind views
        bannerImageView = findViewById(R.id.llm_banner);
        logoImageView = findViewById(R.id.llm_logo);
        titleTextView = findViewById(R.id.llm_title);
        releaseDateTextView = findViewById(R.id.llm_release_date);
        descriptionTextView = findViewById(R.id.llm_description);
        historyTextView = findViewById(R.id.llm_history);
        ratingBar = findViewById(R.id.llm_rating_bar);
        ratingValueTextView = findViewById(R.id.llm_rating_value);

        // Get data from intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("llm_name");
        String description = intent.getStringExtra("llm_description");
        String releaseDate = intent.getStringExtra("llm_release_date");
        int imageRes = intent.getIntExtra("llm_image", R.drawable.ic_info);
        int bannerRes = intent.getIntExtra("llm_banner", R.drawable.banner_default);
        String history = intent.getStringExtra("llm_history");

        // Load saved rating from SharedPreferences
        SharedPreferences prefs = getSharedPreferences("llm_ratings", MODE_PRIVATE);
        float savedRating = prefs.getFloat(name, 0.0f); // Key = LLM name

        // Set data to views
        titleTextView.setText(name);
        releaseDateTextView.setText("Released: " + releaseDate);
        logoImageView.setImageResource(imageRes);
        bannerImageView.setImageResource(bannerRes);
        ratingBar.setRating(savedRating);
        ratingValueTextView.setText("Rating: " + savedRating + "/5");
        descriptionTextView.setText(description);
        historyTextView.setText(history);


        // Rating change listener
        ratingBar.setOnRatingBarChangeListener((bar, rating, fromUser) -> {
            if (fromUser) {
                ratingValueTextView.setText("Rating: " + rating + "/5");

                // Save to SharedPreferences
                SharedPreferences.Editor editor = prefs.edit();
                editor.putFloat(name, rating);
                editor.apply();
            }
        });
    }
}
