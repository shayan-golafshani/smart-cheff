package edu.cnm.deepdive.smartcheff.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import com.squareup.picasso.Picasso;
import edu.cnm.deepdive.smartcheff.R;
import edu.cnm.deepdive.smartcheff.databinding.FragmentRecipesBinding;
import edu.cnm.deepdive.smartcheff.databinding.ItemRecipeBinding;
import edu.cnm.deepdive.smartcheff.model.dto.RecipeDto;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is the adapter for the list view in the recipe fragment.
 */
public class RecipeAdapter extends ArrayAdapter<RecipeDto> {

  /**
   * This field is a reference to the layout inflater.
   */
  private final LayoutInflater inflater;

  /**
   * This field is a list of RecipeDto.
   */
  private final List<RecipeDto> recipes;

  /**
   * This is the constructor for the RecipeAdapter.
   * @param context is the recipe adapter context.
   * @param recipes is the list of RecipeDto
   */
  public RecipeAdapter(Context context, List<RecipeDto> recipes){
    super(context, R.layout.item_recipe, recipes);
    inflater = LayoutInflater.from(context);
    this.recipes = recipes;

  }


  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
     ItemRecipeBinding binding = (convertView != null)
        ? ItemRecipeBinding.bind(convertView)
        : ItemRecipeBinding.inflate(inflater);
    RecipeDto recipe = getItem(position);
    binding.name.setText(recipe.getTitle());
    Picasso.get().load(recipe.getImage()).into(binding.image);
    return binding.getRoot();
  }
}
