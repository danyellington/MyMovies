package com.epicodus.moviedb.services;


import android.util.Log;

import com.epicodus.moviedb.models.Movie;
import com.epicodus.moviedb.Constants;
import com.epicodus.moviedb.models.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MovieService {

    public static void findMovies(Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.MOVIE_BASE_URL).newBuilder();
        String url = urlBuilder.build().toString();
        Log.d(url, "URL");
        Request request= new Request.Builder()
                .url(url)
                .header("Authorization", Constants.MOVIE_TOKEN)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Movie> processResults(Response response) {
        ArrayList<Movie> movies = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            JSONObject movieJSON = new JSONObject(jsonData);
            JSONArray titlesJSON = movieJSON.getJSONArray("results");
            for (int i = 0; i < titlesJSON.length(); i++) {
                JSONObject movieListJSON = titlesJSON.getJSONObject(i);
                String title = movieListJSON.getString("title");
                String overview = movieListJSON.getString("overview");
                String imageUrl = movieListJSON.getString("poster_path");

                Movie movie = new Movie(title, overview, imageUrl);
                movies.add(movie);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (JSONException e){
            e.printStackTrace();
        }
        return movies;
    }

}