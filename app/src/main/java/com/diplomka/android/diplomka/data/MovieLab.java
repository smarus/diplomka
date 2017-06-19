package com.diplomka.android.diplomka.data;

import java.util.ArrayList;

/**
 * Created by ruslan on 5/30/17.
 */

public class MovieLab {
    private static MovieLab movieLab;
    private ArrayList<Movie> movies = new ArrayList<>();

    public static MovieLab getInstance(){
        if (movieLab==null)
            movieLab = new MovieLab();
        return  movieLab;
    }
    private MovieLab(){

    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }
}
