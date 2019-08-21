package com.example.android.foodrecipes.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.android.foodrecipes.models.Recipe;
import com.example.android.foodrecipes.repositories.RecipeRepository;

public class RecipeViewModel extends ViewModel {
    private RecipeRepository mRecipeRepository;
    private String mRecipeId;

    public RecipeViewModel() {
        mRecipeRepository = RecipeRepository.getInstance();
    }

    public LiveData<Recipe> getRecipe(){
        return mRecipeRepository.getRecipe();
    }

    public void searchRecipeById(String recipeId){
        mRecipeId = recipeId;
        mRecipeRepository.searchRecipeById(recipeId);
    }

    public String getRecipeId() {
        return mRecipeId;
    }
}
