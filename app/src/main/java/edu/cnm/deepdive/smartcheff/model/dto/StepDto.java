package edu.cnm.deepdive.smartcheff.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class StepDto {

  @Expose
  @SerializedName("number")
  private int order;

  @Expose
  @SerializedName("step")
  private String text;

  @Expose
  private List<ExtendedIngredientDto> ingredients;

//  @Expose
//  private List<Equipment> equipment;


  public int getOrder() {
    return order;
  }

  public void setOrder(int order) {
    this.order = order;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public List<ExtendedIngredientDto> getIngredients() {
    return ingredients;
  }

  public void setIngredients(
      List<ExtendedIngredientDto> ingredients) {
    this.ingredients = ingredients;
  }
}
