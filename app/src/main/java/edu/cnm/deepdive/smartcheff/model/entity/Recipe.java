package edu.cnm.deepdive.smartcheff.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {@ForeignKey(entity = User.class,parentColumns = "user_id",childColumns = "user_id",
    onDelete = ForeignKey.CASCADE,onUpdate = ForeignKey.CASCADE)})
public class Recipe {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "recipe_id")
  private Long id;

  @ColumnInfo(name = "name_id")
  private Long userid;

  @ColumnInfo(name = "instructions")
  private String instructions;

  @ColumnInfo(name = "name")
  private String name;

  @ColumnInfo(name = "prep_time")
  private int prepTime;

  @ColumnInfo(name = "skill_level")
  private int skillLevel;

  @ColumnInfo(name = "serving_quantity")
  private int servingQuantity;

  public String getInstructions() {
    return instructions;
  }

  public void setInstructions(String instructions) {
    this.instructions = instructions;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrepTime() {
    return prepTime;
  }

  public void setPrepTime(int prepTime) {
    this.prepTime = prepTime;
  }

  public int getSkillLevel() {
    return skillLevel;
  }

  public void setSkillLevel(int skillLevel) {
    this.skillLevel = skillLevel;
  }

  public int getServingQuantity() {
    return servingQuantity;
  }

  public void setServingQuantity(int servingQuantity) {
    this.servingQuantity = servingQuantity;
  }

  public Long getId() {
    return id;
  }

  public Long getUserid() {
    return userid;
  }
}
