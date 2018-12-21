package com.github.eragontuan.cinema_project03_11_2018.Models;

public class Movie {
    int running_time;
    private String Name, ImageURL, summary,director,cast,genre,release_date,rated_URL,language;

    public Movie(String name, String imageURL) {
        Name = name;
        ImageURL = imageURL;
    }

    public Movie(String name, String imageURL, String summary) {
        Name = name;
        ImageURL = imageURL;
        this.summary = summary;
    }

    public Movie(int running_time, String name, String imageURL, String summary, String director, String cast, String genre, String release_date, String rated_URL, String language) {
        this.running_time = running_time;
        Name = name;
        ImageURL = imageURL;
        this.summary = summary;
        this.director = director;
        this.cast = cast;
        this.genre = genre;
        this.release_date = release_date;
        this.rated_URL = rated_URL;
        this.language = language;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImageURL() {
        return ImageURL;
    }

    public void setImageURL(String imageURL) {
        ImageURL = imageURL;
    }

    public int getRunning_time() {
        return running_time;
    }

    public void setRunning_time(int running_time) {
        this.running_time = running_time;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getRated_URL() {
        return rated_URL;
    }

    public void setRated_URL(String rated_URL) {
        this.rated_URL = rated_URL;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
