package edu.cnm.deepdive.smartcheff.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import io.reactivex.annotations.Nullable;

/**
 * This is an @Entity class that makes a table in the SmartCheff data base.
 */
@SuppressWarnings("NotNullFieldNotInitialized")
@Entity(
    foreignKeys = {
        @ForeignKey(entity = User.class,
            parentColumns = "user_id",
            childColumns = "user_id",
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE)

})
public class Ingredient {

  /**
   * This field is the the primary key for an ingredient.
   */
  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "ingredient_id")
  private long id;

  /**
   * This is the the field that connect a user to an ingredient.
   */
  @SuppressWarnings("NullableProblems")
  @NonNull
  @ColumnInfo(name = "user_id",index = true)
  private long userid;

  /**
   * This is the quantity on hand of an ingredient
   */
  @ColumnInfo(name = "quantity_available")
  private int quantityAvailable;

  /**
   * This field is the upc that corresponds to an ingredient.
   */
  @Nullable
  @ColumnInfo(name = "upc")
  private String upc;

  /**
   * This field is the name of an ingredient.
   */
  @NonNull
  @ColumnInfo(name = "name")
  private String name;

  /**
   * Gets the ingredient id.
   */
  public long getId() {
    return id;
  }

  /**
   * Sets the ingredient id.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Gets the user id.
   */
  public long getUserid() {
    return userid;
  }

  /**
   * Sets the user id.
   */
  public void setUserid(long userid) {
    this.userid = userid;
  }

  /**
   * Gets the quantity available.
   */
  public int getQuantityAvailable() {
    return quantityAvailable;
  }

  /**
   * Sets the quantity available.
   */
  public void setQuantityAvailable(int quantityAvailable) {
    this.quantityAvailable = quantityAvailable;
  }

  /**
   * Gets the upc.
   */
  @Nullable
  public String getUpc() {
    return upc;
  }

  /**
   * Sets hte upc.
   */
  public void setUpc(@Nullable String upc) {
    this.upc = upc;
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
}
