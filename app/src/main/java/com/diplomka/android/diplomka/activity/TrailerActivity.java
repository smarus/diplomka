package com.diplomka.android.diplomka.activity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.diplomka.android.diplomka.R;
import com.diplomka.android.diplomka.data.Movie;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.vov.vitamio.LibsChecker;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class TrailerActivity extends AppCompatActivity {
    @BindView(R.id.surface_view)
    VideoView trailerPlayer;
    @BindView(R.id.text_description)
    TextView textDescription;
    @BindView(R.id.play_image_button)
    ImageButton trailerPlayButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trailer);
        if (!LibsChecker.checkVitamioLibs(this))
            return;
        ButterKnife.bind(this);
        Movie movie = getIntent().getExtras().getParcelable("movie");
        textDescription.setText(movie.getDescription());
        trailerPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playTrailer(movie.getTrailer());
            }
        });


    }

    public void playTrailer(String url){
        trailerPlayer.setVideoPath(url);
        trailerPlayer.setMediaController(new MediaController(this));
        trailerPlayer.requestFocus();
        trailerPlayer.setOnPreparedListener(mediaPlayer -> {
            // optional need Vitamio 4.0
            mediaPlayer.setPlaybackSpeed(1.0f);
        });
        trailerPlayButton.setVisibility(View.GONE);
        trailerPlayer.start();

    }


}
