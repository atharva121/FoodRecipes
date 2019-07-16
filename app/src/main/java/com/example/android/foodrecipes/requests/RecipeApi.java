package com.example.android.foodrecipes.requests;

import com.example.android.foodrecipes.requests.responses.RecipeResponse;
import com.example.android.foodrecipes.requests.responses.RecipeSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RecipeApi {
    // Search
    @GET("api/search")
    Call<RecipeSearchResponse> searchRecipe(
            @Query("key") String key,
            @Query("q") String query,
            @Query("page") String page
    );

    // Get
    @GET("api/get")
    Call<RecipeResponse> getRecipe(
            @Query("key") String key,
            @Query("rId") String recipe_id
    );
}
