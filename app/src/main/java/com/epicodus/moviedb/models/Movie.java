package com.epicodus.moviedb.models;


import org.parceler.Parcel;

@Parcel
public class Movie {
    String title;
    String overview;
    String genre;
    String cast;
    String imageUrl;

    public Movie(){}


//    public Movie(String title, String imageUrl) {
//        this.title = title;
//        this.imageUrl = "https://image.tmdb.org/t/p/original" + imageUrl;
//    }

    public Movie(String title, String overview, String imageUrl) {
        this.title = title;
        this.imageUrl = "https://image.tmdb.org/t/p/original" + imageUrl;
        this.overview = overview;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String tagline) {
        this.overview = tagline;
    }


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLargeImageUrl(String imageUrl) {
        String largeImageUrl = imageUrl.substring(0, imageUrl.length() - 6).concat("o.jpg");
        return largeImageUrl;
    }
}
