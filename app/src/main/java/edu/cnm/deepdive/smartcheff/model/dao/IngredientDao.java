package edu.cnm.deepdive.smartcheff.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import edu.cnm.deepdive.smartcheff.model.entity.Ingredient;
import edu.cnm.deepdive.smartcheff.model.entity.User;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;
@Dao
public interface IngredientDao {

  @Insert
  Single<Long> insert(Ingredient ingredients);

  @Insert
  Single<List<Long>> insert(Ingredient...users);

  @Insert
  Single<List<Long>> insert(Collection<Ingredient> users);

  @Delete
  Single<Integer> delete(Ingredient user);

  @Delete
  Single<Integer> delete(Ingredient...users);

  @Delete
  Single<Integer>delete(Collection<Ingredient> users);

}
