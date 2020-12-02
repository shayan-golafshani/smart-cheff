package edu.cnm.deepdive.smartcheff.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * This class is a DTO object for storing data from the Spoonacular api.
 */
public class StepDto {

  /**
   * This field is the order of steps in the instructions.
   */
  @Expose
  @SerializedName("number")
  private int order;

  /**
   * This field is the text of the step in the instructions.
   */
  @Expose
  @SerializedName("step")
  private String text;

  /**
   * This field is a list of ingredients used in the recipe.
   */
  @Expose
  private List<ExtendedIngredientDto> ingredients;

//  @Expose
//  private List<Equipment> equipment;

  /**
   * Gets the order.
   */
  public int getOrder() {
    return order;
  }

  /**
   * Sets the order.
   */
  public void setOrder(int order) {
    this.order = order;
  }

  /**
   * Gets the text.
   */
  public String getText() {
    return text;
  }

  /**
   * Sets the text.
   */
  public void setText(String text) {
    this.text = text;
  }

  /**
   * Gets the list of ExtendedIngredients.
   */
  public List<ExtendedIngredientDto> getIngredients() {
    return ingredients;
  }

  /**
   * Sets the list of ExtendedIngredients.
   */
  public void setIngredients(
      List<ExtendedIngredientDto> ingredients) {
    this.ingredients = ingredients;
  }
}
