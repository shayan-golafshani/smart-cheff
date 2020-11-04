package edu.cnm.deepdive.smartcheff.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
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

  @Update
  Single<Integer> update(Ingredient ingredient);

  @Update
  Single<Integer> update(Ingredient... ingredients);

  @Update
  Single<Integer> update(Collection<Ingredient> ingredients);

  @Delete
  Single<Integer> delete(Ingredient ingredients);

  @Delete
  Single<Integer> delete(Ingredient...ingredients);

  @Delete
  Single<Integer>delete(Collection<Ingredient> ingredients);


  @Query("SELECT * FROM Ingredient WHERE upc = :upc")
  LiveData<Ingredient> selectUsingUpc(String upc);

  @Query("SELECT * FROM Ingredient WHERE name = :name")
  LiveData<Ingredient> selectName(String name);

  @Query("SELECT * FROM Ingredient WHERE quantity_available = :quantity_available")
  LiveData<Ingredient> selectUsingQuantity(String quantity_available);


}
