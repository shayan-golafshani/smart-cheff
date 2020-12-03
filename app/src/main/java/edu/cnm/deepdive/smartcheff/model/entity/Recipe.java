package edu.cnm.deepdive.smartcheff.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import io.reactivex.annotations.Nullable;

/**
 * This is an @Entity class that makes a table in the SmartCheff data base.
 */
@SuppressWarnings("NotNullFieldNotInitialized")
@Entity(
    foreignKeys = {
        @ForeignKey(
            entity = User.class,
            parentColumns = "user_id",
            childColumns = "user_id",
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE)
    },
    indices = {
        @Index(value = {"external_key"}, unique = true)
    }
)
public class Recipe {

  /**
   * This is the primary key for a recipe.
   */
  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "recipe_id")
  private Long id;

  /**
   * This field is what connects the user to a recipe.
   */
  @NonNull
  @ColumnInfo(name = "user_id", index = true)
  private Long userid;

  /**
   * This field is the id for the recipe that comes from the api service.
   */
  @ColumnInfo(name = "external_key")
  @Expose
  @SerializedName("id")
  private long externalKey;

  /**
   * This field is the instruction of a recipe.
   */
  private String instructions;

  /**
   * This is the name of the recipe that comes from the api service.
   */
  @NonNull
  @ColumnInfo(name = "name")
  @Expose
  @SerializedName("title")
  private String name;

  /**
   * This is the image for a recipe that comes from the api service.
   */
  @Expose
  private String image;

  /**
   * This is the prep time of a recipe.
   */
  @ColumnInfo(name = "prep_time")
  private int prepTime;

  /**
   * This is the skill level of a recipe.
   */
  @ColumnInfo(name = "skill_level")
  private int skillLevel;

  /**
   * This is the serving size of a recipe.
   */
  @ColumnInfo(name = "serving_quantity")
  private int servingQuantity;

  /**
   * Gets the recipe id.
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets the recipe id.
   * @param id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Gets the user id.
   */
  @NonNull
  public Long getUserid() {
    return userid;
  }

  /**
   * Sets the user id.
   */
  public void setUserid(@NonNull Long userid) {
    this.userid = userid;
  }

  /**
   * Gets the external key.
   */
  public long getExternalKey() {
    return externalKey;
  }

  /**
   * Set the external key
   * @param externalKey
   */
  public void setExternalKey(long externalKey) {
    this.externalKey = externalKey;
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
   * Gets the name.
   */
  @NonNull
  public String getName() {
    return name;
  }

  /**
   * Sets the name.
   */
  public void setName(@NonNull String name) {
    this.name = name;
  }

  /**
   * Gets the image.
   */
  public String getImage() {
    return image;
  }

  /**
   * Sets the image.
   */
  public void setImage(String image) {
    this.image = image;
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
   * Gets the skill level.
   */
  public int getSkillLevel() {
    return skillLevel;
  }

  /**
   * Sets the skill level.
   */
  public void setSkillLevel(int skillLevel) {
    this.skillLevel = skillLevel;
  }

  /**
   * Gets the serving quantity.
   */
  public int getServingQuantity() {
    return servingQuantity;
  }

  /**
   * Sets the serving quanity.
   */
  public void setServingQuantity(int servingQuantity) {
    this.servingQuantity = servingQuantity;
  }
}
