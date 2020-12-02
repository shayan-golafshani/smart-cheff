package edu.cnm.deepdive.smartcheff.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.cnm.deepdive.smartcheff.BuildConfig;

import edu.cnm.deepdive.smartcheff.model.dto.RecipeDto;
import io.reactivex.Single;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * This class is the proxy service to Spoonacular api service.
 */
public interface SpoonacularServiceProxy {

  /**
   * This method is the @Get request to the api service for a collection of recipes.
   * @param ingredients is used to find a recipe that include those ingredients.
   * @param apiKey is part of required params for a search using the api service.
   * @return a collection of recipes.
   */
  @GET("recipes/findByIngredients")
  Single<List<RecipeDto>> search(@Query("ingredients") String ingredients, @Query("apiKey") String apiKey);

  /**
   * This method gets the details of a single recipe using the id.
   * @param id is the id of a specific recipe.
   * @param apiKey is part of required params for a search using the api service.
   * @return the details of a recipe.
   */
  @GET("recipes/{id}/information")
  Single<RecipeDto> get(@Path("id") long id, @Query("apiKey") String apiKey);

  /**
   * This is the getter fot the SpoonacularServiceProxy instance.
   */
  static SpoonacularServiceProxy getInstance() {
    return InstanceHolder.INSTANCE;
  }

  /**
   * This class contains the Gson and retofit builders
   */
  class InstanceHolder {

    private static final SpoonacularServiceProxy INSTANCE;


    static {
      Gson gson = new GsonBuilder()
          .excludeFieldsWithoutExposeAnnotation()
          .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
          .create();

      HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
      interceptor.setLevel(BuildConfig.DEBUG ? Level.BODY : Level.NONE);
      OkHttpClient client = new OkHttpClient.Builder()
          .addInterceptor(interceptor)
          .build();

      Retrofit retrofit = new Retrofit.Builder()
          .addConverterFactory(GsonConverterFactory.create(gson))
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .client(client)
          .baseUrl(BuildConfig.BASE_URL)
          .build();
      INSTANCE = retrofit.create(SpoonacularServiceProxy.class);
    }
  }

}
