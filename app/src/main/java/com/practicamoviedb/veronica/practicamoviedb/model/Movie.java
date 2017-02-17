package com.practicamoviedb.veronica.practicamoviedb.model;

//import com.google.gson.annotations.SerializedName;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;


public class Movie {

    public enum MovieType {
        LATEST("latest"),
        POPULAR ("popular"),
        UPCOMING("upcoming"),
        TOP_RATED("top_rated"),
        NOW_PLAYING("now_playing"),

        FAVORITES("FAVORITES");

        private final String text;
        MovieType(final String text) {
            this.text = text;
        }
        public String getTitle(){
            return text.replace("_"," ");
        }

        @Override
        public String toString() {
            return text;
        }
    }

    public static final String KEY_MOVIE_ID = "movie_id";
    //@SerializedName("poster_path")
    //IMAGEN
    public String poster_path;
    //@SerializedName("adult")
    public boolean adult;
    //@SerializedName("overview")
    public String overview;
   // @SerializedName("release_date")
    public String release_date;
    // @SerializedName("genre_ids")
    public List<Integer> genre_ids = new ArrayList<Integer>();
    //  @SerializedName("id")
    public Integer id;
    // @SerializedName("original_title")
    public String original_title;
    //  @SerializedName("original_language")
    public String original_language;
    // @SerializedName("title")
    public String title;
    // @SerializedName("backdrop_path")
    public String backdrop_path;
    // @SerializedName("popularity")
    public Double popularity;
    //  @SerializedName("vote_count")
    public Integer vote_count;
    //  @SerializedName("video")
    public Boolean video;
    //  @SerializedName("vote_average")
    public Double vote_average;

    public String url;
    public int imagen;

    public Movie() {

    }

    public static Movie newInstance(long movieId) {
        Movie movie = new Movie();

        Bundle bundle = new Bundle();
        bundle.putLong(movie.KEY_MOVIE_ID, movieId);

        //movie.setArguments(bundle);
      //  this.MainActivity.onStart();

        return movie;
    }

    public Movie(String posterPath, boolean adult, String overview, String releaseDate, List<Integer> genreIds, Integer id,
                 String originalTitle, String originalLanguage, String title, String backdropPath, Double popularity,
                 Integer voteCount, Boolean video, Double voteAverage) {
        this.poster_path = posterPath;
        this.adult = adult;
        this.overview = overview;
        this.release_date = releaseDate;
        this.genre_ids = genreIds;
        this.id = id;
        this.original_title = originalTitle;
        this.original_language = originalLanguage;
        this.title = title;
        this.backdrop_path = backdropPath;
        this.popularity = popularity;
        this.vote_count = voteCount;
        this.video = video;
        this.vote_average = voteAverage;
    }

    public Movie(String title, String originalTitle, String originalLanguage){
        this.title = title;
        this.original_language = originalLanguage;
        this.original_title  = originalTitle;
    }

    public Movie(int image,String title, String url){
        this.title = title;
        this.url = url;
        this.imagen  = image;
    }

    public int getImagen(){
        return imagen;
    }

    public String getPosterPath() {
        return poster_path;
    }

    public void setPosterPath(String posterPath) {
        this.poster_path = posterPath;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return release_date;
    }

    public void setReleaseDate(String releaseDate) {
        this.release_date = releaseDate;
    }

    public List<Integer> getGenreIds() {
        return genre_ids;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genre_ids = genreIds;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOriginalTitle() {
        return original_title;
    }

    public void setOriginalTitle(String originalTitle) {
        this.original_title = originalTitle;
    }

    public String getOriginalLanguage() {
        return original_language;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.original_language = originalLanguage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBackdropPath() {
        return backdrop_path;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdrop_path = backdropPath;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public Integer getVoteCount() {
        return vote_count;
    }

    public void setVoteCount(Integer voteCount) {
        this.vote_count = voteCount;
    }

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public Double getVoteAverage() {
        return vote_average;
    }

    public void setVoteAverage(Double voteAverage) {
        this.vote_average = voteAverage;
    }
}
