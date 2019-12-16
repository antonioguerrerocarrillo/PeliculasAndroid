package com.cescristorey.appmovie.retrofit;


import com.cescristorey.appmovie.ModeloPelicula.CreditsFeed;
import com.cescristorey.appmovie.ModeloPelicula.MovieDetail;
import com.cescristorey.appmovie.ModeloPelicula.MovieFeed;
import com.cescristorey.appmovie.ModeloPelicula.TVShowDetail;
import com.cescristorey.appmovie.ModeloPelicula.TVShowFeed;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieService {

    //MOVIES
    @GET("movie/top_rated")
    Call<MovieFeed> getTopRated(@Query("api_key") String apiKey, @Query("language") String language);

    @GET("movie/popular")
    Call<MovieFeed> getMovieLatest(@Query("api_key") String apiKey, @Query("language") String language);

    @GET("movie/{movie_id}")
    Call<MovieDetail> getMovie(@Path("movie_id") int id , @Query("api_key") String apiKey, @Query("language") String language);

    @GET("movie/{movie_id}/credits")
    Call<CreditsFeed> getCast(@Path("movie_id") int id , @Query("api_key") String apiKey, @Query("language") String language);

    //TVSHOW
    @GET("tv/top_rated")
    Call<TVShowFeed> getTopRatedTvShow(@Query("api_key") String apiKey, @Query("language") String language);

    @GET("tv/popular")
    Call<TVShowFeed> getTvShowLatest(@Query("api_key") String apiKey, @Query("language") String language);

    @GET("tv/{tv_id}")
    Call<TVShowDetail> getTvShow(@Path("tv_id") int id , @Query("api_key") String apiKey, @Query("language") String language);

    @GET("tv/{tv_id}/credits")
    Call<CreditsFeed> getCastTvShow(@Path("tv_id") int id , @Query("api_key") String apiKey, @Query("language") String language);





}