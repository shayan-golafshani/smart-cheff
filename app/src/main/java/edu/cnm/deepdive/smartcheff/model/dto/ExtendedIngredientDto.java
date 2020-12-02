package edu.cnm.deepdive.smartcheff.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * This class is a DTO object for storing data from the Spoonacular api.
 */
public class ExtendedIngredientDto {

  /**
   * This field is the id of the ingredient that corresponds to a recipe.
   */
  @Expose
  private long id;

  /**
   * This field is the name of the ingredient that corresponds to a recipe.
   */
  @Expose
  private String name;

  /**
   * This field is the details of the ingredient that corresponds to a recipe.
   */
  @Expose
  @SerializedName("originalName")
  private String details;

  /**
   * This field is the amount of an ingredient that is needed to make a recipe
   */
  @Expose
  private float amount;

  /**
   * This field id the unit of messurement needed of an ingredient for a recipe.
   */
  @Expose
  private String unit;

  /**
   * Gets the id.
   */
  public long getId() {
    return id;
  }

  /**
   * Sets the id.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Gets the name.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets the details.
   */
  public String getDetails() {
    return details;
  }

  /**
   * Sets the details.
   */
  public void setDetails(String details) {
    this.details = details;
  }

  /**
   * Gets the amount.
   */
  public float getAmount() {
    return amount;
  }

  /**
   * Sets the amount.
   */
  public void setAmount(float amount) {
    this.amount = amount;
  }

  /**
   * Gets the unit.
   */
  public String getUnit() {
    return unit;
  }

  /**
   * Sets the unit.
   */
  public void setUnit(String unit) {
    this.unit = unit;
  }
}


