package edu.cnm.deepdive.smartcheff.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.smartcheff.model.dao.UserDao;
import edu.cnm.deepdive.smartcheff.model.entity.Ingredient;
import edu.cnm.deepdive.smartcheff.model.entity.Recipe;
import edu.cnm.deepdive.smartcheff.model.entity.User;
import io.reactivex.Completable;

/**
 * This Repository contains a get get all method. As of now the get all method will not be used
 * because there is no need to get all the users.
 *
 */
public class UserRepository {

  private final Context context;

  private final UserDao userDao;

  public UserRepository(Context context) {
    this.context = context;
    userDao = SmartCheffDatabase.getInstance().getUserDao();
  }

  public Completable save(User user) {
    return (user.getId() == 0)
        ? userDao.insert(user)
        .doAfterSuccess(user::setId)
        .ignoreElement()
        : userDao.update(user)
            .ignoreElement();
  }

  public Completable delete(User user) {
    return (user.getId() == 0)
        ? Completable.complete()
        : userDao.delete(user)
            .ignoreElement();
  }


  public LiveData<User> findCurrentUser(User user) {
    return userDao.findCurrentUser(user.getId());
  }

  public LiveData<User> getAll(User user) {
    return userDao.findCurrentUser(user.getId());
  }
}
