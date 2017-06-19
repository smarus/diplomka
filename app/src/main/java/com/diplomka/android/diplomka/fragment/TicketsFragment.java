package com.diplomka.android.diplomka.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.diplomka.android.diplomka.R;
import com.diplomka.android.diplomka.activity.MovieListActivity;


public class TicketsFragment extends Fragment {

    TextView textManasCinema;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_seans,container,false);
        textManasCinema =(TextView) view.findViewById(R.id.manas_cinema);
        textManasCinema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), MovieListActivity.class);
                intent.putExtra("cinema","manas");
                startActivity(intent);
            }
        });
        return view;
    }
}
