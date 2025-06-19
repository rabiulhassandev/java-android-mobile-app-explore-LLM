package dev.rabiulhassan.explore_llms.model;

public class LLM {
    private String name, description, releaseDate;
    private int imageResourceId, bannerResourceId;
    private float rating;

    public LLM(String name, String description, String releaseDate, int imageResourceId, int bannerResourceId) {
        this.name = name;
        this.description = description;
        this.releaseDate = releaseDate;
        this.imageResourceId = imageResourceId;
        this.bannerResourceId = bannerResourceId;
        this.rating = 0.0f; // Default rating
    }

    // Getters
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getReleaseDate() { return releaseDate; }
    public int getImageResourceId() { return imageResourceId; }
    public int getBannerResourceId() { return bannerResourceId; }
    public float getRating() { return rating; }

    // Setters
    public void setRating(float rating) {
        if (rating >= 0.0f && rating <= 5.0f) {
            this.rating = rating;
        } else {
            throw new IllegalArgumentException("Rating must be between 0.0 and 5.0");
        }
    }
}
