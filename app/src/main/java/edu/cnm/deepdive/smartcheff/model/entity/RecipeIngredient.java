package edu.cnm.deepdive.smartcheff.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

/**
 * This class is a joining table in the SmartCheff data base between ingredient and recipe.
 */
@SuppressWarnings("NullableProblems")
@Entity(
    foreignKeys = {
        @ForeignKey(
            entity = Ingredient.class,
            parentColumns = "ingredient_id",
            childColumns = "ingredient_id",
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE),
        @ForeignKey(entity = Recipe.class,
            parentColumns = "recipe_id",
            childColumns = "recipe_id",
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE)
    }
)
public class RecipeIngredient {

  /**
   * This is the primary key for the recipe ingredient joining table.
   */
  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "recipe_ingredient_id")
  private long id;

  /**
   * This field is what connects ingredients to this table.
   */
  @NonNull
  @ColumnInfo(name = "ingredient_id", index = true)
  private long ingredientId;

  /**
   * This field is what connects recipes to this table.
   */
  @NonNull
  @ColumnInfo(name = "recipe_id", index = true)
  private long recipeId;

  /**
   * Gets the id of the RecipeIngredient table.
   */
  public long getId() {
    return id;
  }

  /**
   *  Sets the id of the RecipeIngredient table.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Gets the id for an ingredient.
   */
  public long getIngredientId() {
    return ingredientId;
  }

  /**
   * Sets the id for an ingredient.
   * @param ingredientId
   */
  public void setIngredientId(long ingredientId) {
    this.ingredientId = ingredientId;
  }

  /**
   * Gets the recipe id.
   */
  public long getRecipeId() {
    return recipeId;
  }

  /**
   * Sets the recipe id.
   */
  public void setRecipeId(long recipeId) {
    this.recipeId = recipeId;
  }
}
