package com.example.android.foodrecipes.requests;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.android.foodrecipes.AppExecutors;
import com.example.android.foodrecipes.models.Recipe;

import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static com.example.android.foodrecipes.util.Constants.NETWORK_TIMEOUT;

public class RecipeApiClient {
    private static RecipeApiClient instance;
    private MutableLiveData<List<Recipe>> mRecipes;

    public static RecipeApiClient getInstance(){
        if (instance == null){
            instance = new RecipeApiClient();
        }
        return instance;
    }

    private RecipeApiClient(){
        mRecipes = new MutableLiveData<>();
    }

    public LiveData<List<Recipe>> getRecipes(){
        return mRecipes;
    }

    public void searchRecipesApi(){
        final Future handler = AppExecutors.getInstance().networkIO().submit(new Runnable() {
            @Override
            public void run() {
                // retrieve data from rest api
//                mRecipes.postValue();
            }
        });
        AppExecutors.getInstance().networkIO().schedule(new Runnable() {
            @Override
            public void run() {
                // let the user know its timed out
                handler.cancel(true);
            }
        }, NETWORK_TIMEOUT, TimeUnit.MILLISECONDS);
    }
}
