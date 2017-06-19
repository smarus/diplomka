package com.diplomka.android.diplomka.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.diplomka.android.diplomka.R;
import com.diplomka.android.diplomka.backend.MovieInterfaceImple;
import com.diplomka.android.diplomka.data.MovieLab;
import com.diplomka.android.diplomka.fragment.MovieFragment;
import com.diplomka.android.diplomka.fragment.SettingsFragment;
import com.diplomka.android.diplomka.fragment.TicketsFragment;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    private FragmentManager fragmentManager;
    private Fragment fragment = new MovieFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        MovieInterfaceImple provider = MovieInterfaceImple.getInstance();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.add(R.id.frame_layout,fragment);
//        fragmentTransaction.commit();

        provider.getMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(movies -> {MovieLab.getInstance().setMovies(movies);
                    Log.e("de",movies.get(0).getDescription());
                }, throwable -> {
                    Log.e("Exceptions", throwable.getMessage());
                });


       bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
           int id = item.getItemId();
           switch (id){
               case R.id.menu_movies:
                   fragment = new MovieFragment();
                   break;
               case R.id.menu_seans:
                   fragment = new TicketsFragment();
                   break;
               case R.id.menu_settings:
                   fragment = new SettingsFragment();
                   break;
           }
           final FragmentTransaction transaction = fragmentManager.beginTransaction();
           transaction.replace(R.id.frame_layout, fragment).commit();
           return true;
       });
    }
}

