package edu.cnm.deepdive.smartcheff.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import com.squareup.picasso.Picasso;
import edu.cnm.deepdive.smartcheff.R;
import edu.cnm.deepdive.smartcheff.databinding.ItemRecipeBinding;
import edu.cnm.deepdive.smartcheff.databinding.ItemStepsBinding;
import edu.cnm.deepdive.smartcheff.model.dto.AnalyzedInstructionDto;
import edu.cnm.deepdive.smartcheff.model.dto.RecipeDto;
import edu.cnm.deepdive.smartcheff.model.dto.StepDto;
import java.util.List;
/**
 * This class is currently unimplemented.
 * This class is the adapter for the list view in the current recipe fragment.
 */
public class CurrentRecipeAdapter extends ArrayAdapter<AnalyzedInstructionDto> {

  private final LayoutInflater inflater;
  private final List<AnalyzedInstructionDto> steps;

  /**
   * This is the constructor for the CurrentRecipeAdapter.
   * @param context is the current recipe adapter context.
   * @param steps is the list of StepDto
   */
  public CurrentRecipeAdapter(Context context, List<AnalyzedInstructionDto> steps) {
    super(context, R.layout.item_steps, steps);
    inflater = LayoutInflater.from(context);
    this.steps = steps;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    ItemStepsBinding binding = (convertView != null)
        ? ItemStepsBinding.bind(convertView)
        : ItemStepsBinding.inflate(inflater);
    AnalyzedInstructionDto steps = getItem(position);
    binding.steps.setText((CharSequence) steps.getSteps());
    return binding.getRoot();
  }



}
