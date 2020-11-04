package edu.cnm.deepdive.smartcheff.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import io.reactivex.annotations.Nullable;

@Entity(
    foreignKeys =
        {@ForeignKey(entity = User.class,parentColumns = "user_id",childColumns = "user_id",
    onDelete = ForeignKey.CASCADE,onUpdate = ForeignKey.CASCADE)
    })
public class Recipe {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "recipe_id")
  private Long id;

  @NonNull
  @ColumnInfo(name = "user_id", index = true)
  private Long userid;

  @NonNull
  @ColumnInfo(name = "instructions")
  private String instructions;


  @NonNull
  @ColumnInfo(name = "name")
  private String name;

  @Nullable
  @ColumnInfo(name = "prep_time")
  private int prepTime;

  @Nullable
  @ColumnInfo(name = "skill_level")
  private int skillLevel;

  @Nullable
  @ColumnInfo(name = "serving_quantity")
  private int servingQuantity;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @NonNull
  public Long getUserid() {
    return userid;
  }

  public void setUserid(@NonNull Long userid) {
    this.userid = userid;
  }

  @NonNull
  public String getInstructions() {
    return instructions;
  }

  public void setInstructions(@NonNull String instructions) {
    this.instructions = instructions;
  }

  @NonNull
  public String getName() {
    return name;
  }

  public void setName(@NonNull String name) {
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
}
