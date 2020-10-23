package edu.cnm.deepdive.smartcheff.model.entity.entity;

import androidx.room.ColumnInfo;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import edu.cnm.deepdive.smartcheff.model.entity.Ingredient;

public class RecipeIngredient {
  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "recipe_ingredient_id")
  private Long Id;

  @ForeignKey(entity = )
  @ColumnInfo(name = "ingredient_id")
  private Long ingredientId;

  @ForeignKey(entity = )
  @ColumnInfo(name = "recipe_id")
  private Long recipeId;

}
