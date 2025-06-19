package dev.rabiulhassan.explore_llms;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DetailActivity extends AppCompatActivity {

    private ImageView bannerImageView, logoImageView;
    private TextView titleTextView, releaseDateTextView, descriptionTextView;
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
        ratingBar = findViewById(R.id.llm_rating_bar);

        // Get data from intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("llm_name");
        String description = intent.getStringExtra("llm_description");
        String releaseDate = intent.getStringExtra("llm_release_date");
        int imageRes = intent.getIntExtra("llm_image", R.drawable.ic_info);
        int bannerRes = intent.getIntExtra("llm_banner", R.drawable.banner_default);
        float rating = intent.getFloatExtra("llm_rating", 0.0f);

        // Set data to views
        titleTextView.setText(name);
        releaseDateTextView.setText("Released: " + releaseDate);
        descriptionTextView.setText(description);
        logoImageView.setImageResource(imageRes);
        bannerImageView.setImageResource(bannerRes); // or a separate banner if available
        ratingBar.setRating(rating);
    }
}
