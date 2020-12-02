package edu.cnm.deepdive.smartcheff.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is a DTO object for storing data from the Spoonacular api.
 */
public class RecipeDto {

  /**
   * This field is the id of a recipe.
   */
  @Expose
  private long id;

  /**
   * This field is the title of a recipe.
   */
  @Expose
  private String title;

  /**
   * This field is the prep time of a recipe.
   */
  @Expose
  @SerializedName("readyInMinutes")
  private int prepTime;

  /**
   * This field is the serving size of a recipe.
   */
  @Expose
  private int servings;

  /**
   * This field is the source url for the recipe.
   */
  @Expose
  private String sourceUrl;

  /**
   * This field is the image of a recipe.
   */
  @Expose
  private String image;

  /**
   * This field is the summary of a recipe.
   */
  @Expose
  private String summary;

  /**
   * This field is a list of Extended ingredients.
   */
  @Expose
  @SerializedName("extendedIngredients")
  private List<ExtendedIngredientDto> extendedIngredients;

  /**
   * This field maps a list of Extended ingredients to new hash map.
   */
  private final Map<Long, List<ExtendedIngredientDto>> ingredients = new LinkedHashMap<>();

  /**
   * This field is the instructions that correspond to a specific recipe.
   */
  @Expose
  private String instructions;

  /**
   * This field is a list of AnalyzedInstructions.
   */
  @Expose
  private List<AnalyzedInstructionDto> analyzedInstructions;

  /**
   * Gets the id.
   */
  public long getId() {
    return id;
  }

  /**
   * Sets tthe id.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Gets the title.
   */
  public String getTitle() {
    return title;
  }

  /**
   * Sets the title.
   * @param title
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * Gets the prep time.
   */
  public int getPrepTime() {
    return prepTime;
  }

  /**
   * Sets the prep time.
   */
  public void setPrepTime(int prepTime) {
    this.prepTime = prepTime;
  }

  /**
   * Gets the servings.
   */
  public int getServings() {
    return servings;
  }

  /**
   * Sets the servings.
   */
  public void setServings(int servings) {
    this.servings = servings;
  }

  /**
   * Gets the source url.
   */
  public String getSourceUrl() {
    return sourceUrl;
  }

  /**
   * Sets the the source url.
   */
  public void setSourceUrl(String sourceUrl) {
    this.sourceUrl = sourceUrl;
  }

  /**
   * Gets the recipe image.
   */
  public String getImage() {
    return image;
  }

  /**
   * Sets the recipe image.
   */
  public void setImage(String image) {
    this.image = image;
  }

  /**
   * Gets the summary.
   */
  public String getSummary() {
    return summary;
  }

  /**
   * Sets the summary.
   */
  public void setSummary(String summary) {
    this.summary = summary;
  }

  /**
   * Gets the list of Extended Ingredient Dto.
   */
  public List<ExtendedIngredientDto> getExtendedIngredients() {
    return extendedIngredients;
  }

  /**
   * Sets the Extended Ingredient Dto
   */
  public void setExtendedIngredients(
      List<ExtendedIngredientDto> extendedIngredients) {
    this.extendedIngredients = extendedIngredients;
  }

  /**
   * Gets the mapped list of Extended Ingredients.
   */
  public Map<Long, List<ExtendedIngredientDto>> getIngredients() {
    return ingredients;
  }

  /**
   * Gets the instructions.
   */
  public String getInstructions() {
    return instructions;
  }

  /**
   * Sets the instructions.
   */
  public void setInstructions(String instructions) {
    this.instructions = instructions;
  }

  /**
   * Gets the list of AnalyzedInstructionDto.
   */
  public List<AnalyzedInstructionDto> getAnalyzedInstructions() {
    return analyzedInstructions;
  }

  /**
   * Sets the list of AnalyzedInstructionDtos.
   */
  public void setAnalyzedInstructions(
      List<AnalyzedInstructionDto> analyzedInstructionDtos) {
    this.analyzedInstructions = analyzedInstructionDtos;
  }
}
