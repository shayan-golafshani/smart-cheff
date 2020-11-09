package edu.cnm.deepdive.smartcheff.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

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
  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "recipe_ingredient_id")
  private long id;

  @NonNull
  @ColumnInfo(name = "ingredient_id", index = true)
  private long ingredientId;

  @NonNull
  @ColumnInfo(name = "recipe_id", index = true)
  private long recipeId;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getIngredientId() {
    return ingredientId;
  }

  public void setIngredientId(long ingredientId) {
    this.ingredientId = ingredientId;
  }

  public long getRecipeId() {
    return recipeId;
  }

  public void setRecipeId(long recipeId) {
    this.recipeId = recipeId;
  }
}
