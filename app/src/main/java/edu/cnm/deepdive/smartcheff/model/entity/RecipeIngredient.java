package edu.cnm.deepdive.smartcheff.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(
    foreignKeys = {
        @ForeignKey(entity = Ingredient.class,parentColumns = "ingredient_id", childColumns = "ingredient_id",
        onDelete = ForeignKey.CASCADE,onUpdate = ForeignKey.CASCADE),
        @ForeignKey(entity = Recipe.class,parentColumns = "recipe_id",childColumns = "recipe_id",
        onDelete = ForeignKey.CASCADE,onUpdate = ForeignKey.CASCADE)
    }
)
public class RecipeIngredient {
  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "recipe_ingredient_id")
  private long id;


  @ColumnInfo(name = "ingredient_id", index = true)
  private long ingredientId;

  @ColumnInfo(name = "recipe_id", index = true)
  private long recipeId;

}
