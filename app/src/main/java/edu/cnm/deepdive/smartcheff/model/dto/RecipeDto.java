package edu.cnm.deepdive.smartcheff.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RecipeDto {

  //  "id": 987595,
//      "title": "Apple Ginger Kombucha Cocktail",
//      "readyInMinutes": 2,
//      "servings": 1,
//      "sourceUrl": "https://www.afamilyfeast.com/apple-ginger-kombucha-cocktail/",
//      "image": "https://spoonacular.com/recipeImages/987595-556x370.jpg",
//      "imageType": "jpg",
//      "summary": "The recipe Apple Ginger Kombucha Cocktail can be made <b>in about 2 minutes</b>. This recipe serves 1 and costs 64 cents per serving. One portion of this dish contains around <b>1g of protein</b>, <b>1g of fat</b>, and a total of <b>96 calories</b>. 17 people were glad they tried this recipe. Head to the store and pick up schonauer apple liquor, gt's ginger kombucha, apples, and a few other things to make it today. It works well as a very reasonably priced beverage. It is brought to you by A Family Feast . It is a good option if you're following a <b>caveman, gluten free, dairy free, and lacto ovo vegetarian</b> diet. Taking all factors into account, this recipe <b>earns a spoonacular score of 87%</b>, which is awesome. Similar recipes are <a href=\"https://spoonacular.com/recipes/10-things-you-need-to-know-about-kombucha-+-apple-ginger-kombucha-512583\">10 Things You Need to Know About Kombucha + Apple Ginger Kombucha</a>, <a href=\"https://spoonacular.com/recipes/apple-ginger-sparkle-cocktail-620273\">Apple Ginger Sparkle Cocktail</a>, and <a href=\"https://spoonacular.com/recipes/matcha-ginger-kombucha-fizz-863769\">Matcha Ginger Kombucha Fizz</a>.",
  @Expose
  private long id;

  @Expose
  private String title;

  @Expose
  @SerializedName("readyInMinutes")
  private int prepTime;

  @Expose
  private int servings;

  @Expose
  private String sourceUrl;

  @Expose
  private String image;

  @Expose
  private String summary;

  @Expose
  @SerializedName("extendedIngredients")
  private List<ExtendedIngredientDto> extendedIngredients;

  private final Map<Long, List<ExtendedIngredientDto>> ingredients = new LinkedHashMap<>();

  @Expose
  private String instructions;

  @Expose
  private List<AnalyzedInstructionDto> analyzedInstructions;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getPrepTime() {
    return prepTime;
  }

  public void setPrepTime(int prepTime) {
    this.prepTime = prepTime;
  }

  public int getServings() {
    return servings;
  }

  public void setServings(int servings) {
    this.servings = servings;
  }

  public String getSourceUrl() {
    return sourceUrl;
  }

  public void setSourceUrl(String sourceUrl) {
    this.sourceUrl = sourceUrl;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public List<ExtendedIngredientDto> getExtendedIngredients() {
    return extendedIngredients;
  }

  public void setExtendedIngredients(
      List<ExtendedIngredientDto> extendedIngredients) {
    this.extendedIngredients = extendedIngredients;
  }

  public Map<Long, List<ExtendedIngredientDto>> getIngredients() {
    return ingredients;
  }

  public String getInstructions() {
    return instructions;
  }

  public void setInstructions(String instructions) {
    this.instructions = instructions;
  }

  public List<AnalyzedInstructionDto> getAnalyzedInstructions() {
    return analyzedInstructions;
  }

  public void setAnalyzedInstructions(
      List<AnalyzedInstructionDto> analyzedInstructionDtos) {
    this.analyzedInstructions = analyzedInstructionDtos;
  }
}
