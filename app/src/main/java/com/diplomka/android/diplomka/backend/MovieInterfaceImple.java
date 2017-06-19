package com.diplomka.android.diplomka.backend;

import com.diplomka.android.diplomka.data.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by ruslan on 5/30/17.
 */

public class MovieInterfaceImple {
    private static MovieInterfaceImple provider;
    private final String baseUrl = "http://private-f235ee-cinema13.apiary-mock.com";
    private final String apiKey = "1d46e7a56d26a4a324adb2a6ceec5d2d";
    private MovieApiInterface movieApiInterface;
    public static String baseApiPoster ="http://image.tmdb.org/t/p/w185/";


    private MovieInterfaceImple() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();
        movieApiInterface = retrofit.create(MovieApiInterface.class);
    }
    public static MovieInterfaceImple getInstance(){
        if (provider==null){
            provider = new MovieInterfaceImple();
        }
        return provider;
    }

    public Observable<ArrayList<Movie>> getMovies(){
       return movieApiInterface.getMovies();
   }

}
