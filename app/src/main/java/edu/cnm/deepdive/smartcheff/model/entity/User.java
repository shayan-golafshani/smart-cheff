package edu.cnm.deepdive.smartcheff.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * This is an @Entity class that makes a User table in the SmartCheff data base.
 */
@Entity
public class User {

  /**
   * This field is the primary key for a User.
   */
  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "user_id")
  private long id;

  /**
   * This field is the oauth key that corresponds to a specific user.
   */
  @ColumnInfo(name = "oauth_key",index = true)
  private String oauthKey;

  /**
   * Gets the user id.
   */
  public long getId() {
    return id;
  }

  /**
   * Sets the id for a user.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Gets the users' oauth key.
   */
  public String getOauthKey() {
    return oauthKey;
  }

  /**
   * Sets the users' oauth key.
   */
  public void setOauthKey(String oauthKey) {
    this.oauthKey = oauthKey;
  }
}
