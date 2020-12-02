package edu.cnm.deepdive.smartcheff.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.smartcheff.model.dao.UserDao;
import edu.cnm.deepdive.smartcheff.model.entity.Ingredient;
import edu.cnm.deepdive.smartcheff.model.entity.Recipe;
import edu.cnm.deepdive.smartcheff.model.entity.User;
import io.reactivex.Completable;

/**
 * This class holds the logic for the queries to the SmartCheff database involving a user.
 * This class contains a get get all method. As of now the get all method will not be used
 * because there is no need to get all the users.
 *
 */
public class UserRepository {

  private final Context context;

  private final UserDao userDao;

  /**
   * This is the constructor for the UserRepository.
   * @param context is reference to a Context object.
   */
  public UserRepository(Context context) {
    this.context = context;
    userDao = SmartCheffDatabase.getInstance().getUserDao();
  }

  /**
   * This is the method used to save a user to the SmartCheff database.
   * @param user is a reference to a User object.
   * @return a saved user.
   */
  public Completable save(User user) {
    return (user.getId() == 0)
        ? userDao.insert(user)
        .doAfterSuccess(user::setId)
        .ignoreElement()
        : userDao.update(user)
            .ignoreElement();
  }

  /**
   * This is the method used to delete a user from the SmartCheff database.
   * @param user is a reference to a User object.
   * @return a deleted recipe.
   */
  public Completable delete(User user) {
    return (user.getId() == 0)
        ? Completable.complete()
        : userDao.delete(user)
            .ignoreElement();
  }

  /**
   * This method is user to find the current user.
   * @param user a reference to a User object.
   * @return the current user.
   */
  public LiveData<User> findCurrentUser(User user) {
    return userDao.findCurrentUser(user.getId());
  }

  /**
   * This method is user to get all the users in the SmartCheff database.
   * @param user is a reference to a User object.
   * @return all the users.
   */
  public LiveData<User> getAll(User user) {
    return userDao.findCurrentUser(user.getId());
  }
}
