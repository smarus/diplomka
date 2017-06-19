package com.diplomka.android.diplomka.backend;

import com.diplomka.android.diplomka.data.Movie;

import java.util.ArrayList;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by ruslan on 5/30/17.
 */

public interface MovieApiInterface {
    @GET("/movies")
    Observable<ArrayList<Movie>> getMovies();
}
