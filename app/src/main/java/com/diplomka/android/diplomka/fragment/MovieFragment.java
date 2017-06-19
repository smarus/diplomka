package com.diplomka.android.diplomka.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.diplomka.android.diplomka.R;
import com.diplomka.android.diplomka.activity.TrailerActivity;
import com.diplomka.android.diplomka.adapter.MovieAdapter;
import com.diplomka.android.diplomka.data.Movie;
import com.diplomka.android.diplomka.data.MovieLab;


public class MovieFragment extends Fragment implements MovieAdapter.MovieInterface {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_movie,container,false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_movie);
        setupRecyclerView(recyclerView);
        return view;
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new MovieAdapter(getContext(), MovieLab.getInstance().getMovies(),this));
    }

    @Override
    public void clickMovie(Movie movie) {
        Intent intent = new Intent(getContext(), TrailerActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("movie",movie);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
