package edu.cnm.deepdive.smartcheff.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import edu.cnm.deepdive.smartcheff.model.entity.entity.User;

@Entity
public class Ingredient {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "ingredient_id")
  private Long id;

  @ColumnInfo(name = "quantity_available")
  private int quantityAvailable;

  private String upc;

  @ColumnInfo(name = "user_id")
  private long userid;

}
