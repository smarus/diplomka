package com.diplomka.android.diplomka.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.diplomka.android.diplomka.R;
import com.diplomka.android.diplomka.activity.MapActivity;
import com.diplomka.android.diplomka.activity.MapsActivity;


public class SettingsFragment extends Fragment {
    Button button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.item_settings,container,false);
        button = (Button)view.findViewById(R.id.map_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
            Intent intent = new Intent(getActivity(), MapsActivity.class);
            getActivity().startActivity(intent);
                Toast.makeText(SettingsFragment.
                        this.getContext(), "djfgldkfjg", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
