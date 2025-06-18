package dev.rabiulhassan.explore_llms.model;

public class LLM {
    private String name;
    private String description;
    private int imageResourceId;
    private float rating;
    private String releaseDate;

    public LLM(String name, String description, int imageResourceId, String releaseDate) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
        this.releaseDate = releaseDate;
        this.rating = 0.0f;
    }

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

    public String getReleaseDate() {
        return releaseDate;
    }
}
