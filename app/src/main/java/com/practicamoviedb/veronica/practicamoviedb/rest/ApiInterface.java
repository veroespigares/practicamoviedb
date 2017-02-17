package com.practicamoviedb.veronica.practicamoviedb.rest;

import com.practicamoviedb.veronica.practicamoviedb.model.MoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiInterface {
    @GET("movie/top_rated")
    Call<MoviesResponse> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("movie/{id}")
    Call<MoviesResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
    @GET("/movie/{movie_id}")
   Call <MoviesResponse> getMovieDetail(@Path("movie_id") int movieId, @Query("api_key") String apiKey);

    @GET("movie/popular")
    Call<MoviesResponse> getPopularMovies(@Query("api_key") String apiKey, String lenguage, int page);

}
