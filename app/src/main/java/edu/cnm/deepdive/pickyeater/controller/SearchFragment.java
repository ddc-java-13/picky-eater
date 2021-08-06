package edu.cnm.deepdive.pickyeater.controller;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import edu.cnm.deepdive.pickyeater.adapter.SearchResultsAdapter;
import edu.cnm.deepdive.pickyeater.databinding.FragmentSearchBinding;
import edu.cnm.deepdive.pickyeater.viewmodel.RecipeViewModel;

public class SearchFragment extends Fragment {

  private FragmentSearchBinding binding;
  private RecipeViewModel viewModel;


  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    binding = FragmentSearchBinding.inflate(inflater, container, false);
    binding.search.setOnClickListener((v) ->
        viewModel.setIngredientName(binding.searchText.getText().toString().trim()));
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    //noinspection ConstantConditions
    viewModel = new ViewModelProvider(getActivity()).get(RecipeViewModel.class);
    viewModel.getSearchResults().observe(getViewLifecycleOwner(), (recipes) -> {
      SearchResultsAdapter adapter =
          new SearchResultsAdapter(getContext(), recipes, (v, pos, recipe) ->
              Log.d(getClass().getSimpleName(), recipe.getName()));
      binding.recipes.setAdapter(adapter);
    });
  }
}