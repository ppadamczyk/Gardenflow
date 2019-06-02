package com.example.gardenflow.services;

public class Plant {
  // Store the id of the  movie poster
  private String plantName;
  // Store the name of the movie
  private String plantSpecies;
  // Store the release date of the movie
  private String plantAge;
  private String plantImage;


  // Constructor that is used to create an instance of the Movie object
  public Plant( String plantImage, String plantName, String plantSpecies) {
    this.plantName = plantName;
    this.plantSpecies = plantSpecies;
    this.plantImage = plantImage;
  }

  public String getPlantImage() {
    return plantImage;
  }

  public void setPlantImage(String plantImage) {
    this.plantImage = plantImage;
  }

  public String getPlantSpecies() {
    return plantSpecies;
  }

  public void setPlantSpecies(String plantSpecies) {
    this.plantSpecies = plantSpecies;
  }

  public String getPlantAge() {
    return plantAge;
  }

  public void setPlantAge(String plantAge) {
    this.plantAge = plantAge;
  }

  public String getPlantName() {
    return plantName;
  }

  public void setPlantName(String plantName) {
    this.plantName = plantName;
  }
}
