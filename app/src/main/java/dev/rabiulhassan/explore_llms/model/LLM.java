package dev.rabiulhassan.explore_llms.model;

public class LLM {
    private String name;
    private String description;
    private int imageResourceId;
    private float rating;

    public LLM(String name, String description, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
        this.rating = 0.0f;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
