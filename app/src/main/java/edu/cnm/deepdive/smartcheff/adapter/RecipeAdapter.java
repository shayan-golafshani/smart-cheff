package edu.cnm.deepdive.smartcheff.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import edu.cnm.deepdive.smartcheff.R;
import edu.cnm.deepdive.smartcheff.databinding.FragmentRecipesBinding;
import edu.cnm.deepdive.smartcheff.model.dto.RecipeDto;
import java.util.ArrayList;


public class RecipeAdapter extends ArrayAdapter<RecipeDto> {

  private final LayoutInflater inflater;

  public RecipeAdapter(Context context){
    super(context, R.layout.item_recipe, new ArrayList<RecipeDto>());
    inflater = LayoutInflater.from(context);
  }


  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
     FragmentRecipesBinding binding = (convertView != null)
        ? FragmentRecipesBinding.bind(convertView)
        : FragmentRecipesBinding.inflate(inflater);

    return binding.getRoot();
  }
}
