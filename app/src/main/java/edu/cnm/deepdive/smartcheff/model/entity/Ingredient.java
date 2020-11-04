package edu.cnm.deepdive.smartcheff.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import io.reactivex.annotations.Nullable;


@Entity(
    foreignKeys = {
        @ForeignKey(entity = User.class,parentColumns = "user_id",childColumns = "user_id", onDelete = ForeignKey.CASCADE,onUpdate = ForeignKey.CASCADE)

})
public class Ingredient {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "ingredient_id")
  private long id;


  @NonNull
  @ColumnInfo(name = "user_id",index = true)
  private long userid;

  @NonNull
  @ColumnInfo(name = "quantity_available")
  private int quantityAvailable;

  @Nullable
  @ColumnInfo(name = "upc")
  private String upc;

  @NonNull
  @ColumnInfo(name = "name")
  private String name;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getUserid() {
    return userid;
  }

  public void setUserid(long userid) {
    this.userid = userid;
  }

  public int getQuantityAvailable() {
    return quantityAvailable;
  }

  public void setQuantityAvailable(int quantityAvailable) {
    this.quantityAvailable = quantityAvailable;
  }

  @Nullable
  public String getUpc() {
    return upc;
  }

  public void setUpc(@Nullable String upc) {
    this.upc = upc;
  }

  @NonNull
  public String getName() {
    return name;
  }

  public void setName(@NonNull String name) {
    this.name = name;
  }
}
