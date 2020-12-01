package edu.cnm.deepdive.smartcheff.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.smartcheff.model.entity.Recipe;
import edu.cnm.deepdive.smartcheff.model.entity.User;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

/**
 * This is an interface that handles all the queries involving users.
 */
@Dao
public interface UserDao {

  /**
   * This method is used to insert one user into the SmartCheff data base.
   * @param user is a reference to the user object.
   * @return user.
   */
  @Insert
  Single<Long> insert(User user);

  /**
   * This method is used to insert more then one user into the SmartCheff database.
   * @param users is a reference to more then one user object.
   * @return users
   */
  @Insert
  Single<List<Long>> insert(User...users);

  /**
   * This method is used insert a collection user into the SmartCheff database.
   * @param users is a reference to a collection user objects.
   * @return users.
   */
  @Insert
  Single<List<Long>> insert(Collection<User> users);

  /**
   * This method is used to update an user in the SmartCeff database.
   * @param user is a reference to the user object.
   * @return user.
   */
  @Update
  Single<Integer> update(User user);

  /**
   * This method is used to update more then one users in the SmartCeff database.
   * @param users is a reference to more then one user object.
   * @return users.
   */
  @Update
  Single<Integer> update(User... users);

  /**
   * This method is used to update a collection of users in the SmartCeff database.
   * @param users  is a reference to a collection of user objects.
   * @return users.
   */
  @Update
  Single<Integer> update(Collection<User> users);

  /**
   * This method is used to delete an user from the SmartCeff database.
   * @param user is a reference to a user object.
   * @return user.
   */
  @Delete
  Single<Integer> delete(User user);

  /**
   * This method is used to delete more the one user from the SmartCeff database.
   * @param users is a reference to more then one user object.
   * @return users.
   */
  @Delete
  Single<Integer> delete(User...users);

  /**
   * This method is used to delete a collection of users from the SmartCeff database.
   * @param users is a reference to a collection of user objects
   * @return users.
   */
  @Delete
  Single<Integer>delete(Collection<User> users);


  /**
   * This method is a query to the Smatcheff database.
   * This query is a way to find a user by the users' id .
   * @param id is a reference to the users' id.
   * @return user.
   */
  @Query("SELECT * FROM User WHERE user_id = :id")
  LiveData<User> findCurrentUser (long id);

  /**
   * This method is a query to the Smatcheff database.
   * This query is a way to find all the users' in the smartCheff database.
   * @return users.
   */
  @Query("SELECT * FROM User ")
  LiveData<User>  getAll ();
}
