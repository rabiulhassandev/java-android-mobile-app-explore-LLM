package dev.rabiulhassan.explore_llms.model;

public class LLM {
    private String name;
    private String description;
    private int imageResourceId;
    private String releaseDate;

    public LLM(String name, String description, int imageResourceId, String releaseDate) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
        this.releaseDate = releaseDate;
    }

    // Getters
    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getImageResourceId() { return imageResourceId; }
    public String getReleaseDate() { return releaseDate; }
}
