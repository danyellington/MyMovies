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

    public Movie(String title, String imageUrl) {}

    public Movie(String title, String overview, String imageUrl) {
        this.title = title;
        this.overview = overview;
//        this.cast = cast;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public String getOverview() {
//        return overview;
//    }
//
//    public void setOverview(String tagline) {
//        this.overview = tagline;
//    }

//    public String getGenre() {
//        return genre;
//    }
//
//    public void setGenre(String genre) {
//        this.genre = genre;
//    }

//    public String getCast() {
//        return cast;
//    }
//
//    public void setCast(String cast) {
//        this.cast = cast;
//    }

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
