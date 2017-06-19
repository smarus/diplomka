package com.diplomka.android.diplomka.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.diplomka.android.diplomka.R;
import com.diplomka.android.diplomka.data.Movie;

import java.util.ArrayList;

/**
 * Created by ruslan on 5/30/17.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    ArrayList<Movie> movieList;
    Context context;
    MovieInterface movieInterface;

    public interface MovieInterface{
        void clickMovie(Movie movie);
    }

    public MovieAdapter(Context context, ArrayList<Movie> movieList,MovieInterface movieInterface) {
        this.movieList = movieList;
        this.context = context;
        this.movieInterface = movieInterface;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycle_movie,parent,false);
        return new MovieViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        holder.titleName.setText(movieList.get(position).getTitle());
        Glide.with(context).load(movieList.get(position).getPoster()).asBitmap().centerCrop()
                .into(holder.imagePoster);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imagePoster;
        TextView titleName;

        public MovieViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            imagePoster = (ImageView) itemView.findViewById(R.id.movie_poster);
            titleName = (TextView) itemView.findViewById(R.id.movie_name);
        }

        @Override
        public void onClick(View view) {
            movieInterface.clickMovie(movieList.get(getAdapterPosition()));
        }
    }
}
