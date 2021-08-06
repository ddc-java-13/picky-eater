package edu.cnm.deepdive.pickyeater.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.pickyeater.adapter.SearchResultsAdapter.Holder;
import edu.cnm.deepdive.pickyeater.databinding.ItemRecipeBinding;
import edu.cnm.deepdive.pickyeater.model.pojo.RecipeWithIngredients;
import java.text.DateFormat;
import java.util.List;

public class SearchResultsAdapter extends RecyclerView.Adapter<Holder> {

  private final Context context;
  private final List<RecipeWithIngredients> recipes;
  private final OnRecipeClickListener listener;
  private final LayoutInflater inflater;
  private final DateFormat dateFormat;

  public SearchResultsAdapter(Context context,
      List<RecipeWithIngredients> recipes,
      OnRecipeClickListener listener) {
    this.context = context;
    this.recipes = recipes;
    this.listener = listener;
    inflater = LayoutInflater.from(context);
    dateFormat = android.text.format.DateFormat.getDateFormat(context);
  }


  @NonNull
  @Override
  public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return new Holder(ItemRecipeBinding.inflate(inflater, parent, false));
  }

  @Override
  public void onBindViewHolder(@NonNull Holder holder, int position) {
    holder.bind(position);
  }

  @Override
  public int getItemCount() {
    return recipes.size();
  }

  class Holder extends RecyclerView.ViewHolder {

    private ItemRecipeBinding binding;

    public Holder(@NonNull ItemRecipeBinding binding) {
      super(binding.getRoot());
      this.binding = binding;
    }

    private void bind(int position) {
      RecipeWithIngredients recipe = recipes.get(position);
      binding.name.setText(recipe.getName());
      binding.created.setText(dateFormat.format(recipe.getCreated()));
      binding.getRoot().setOnClickListener((v) -> listener.onRecipeClick(v, position, recipe));

    }

  }

  @FunctionalInterface
  public interface OnRecipeClickListener {

    void onRecipeClick(View view, int position, RecipeWithIngredients recipe);
  }

}
