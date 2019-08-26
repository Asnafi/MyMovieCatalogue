package com.tryoasnafi.mymoviecatalogue.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tryoasnafi.mymoviecatalogue.R;
import com.tryoasnafi.mymoviecatalogue.model.Movie;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {

    private Context c;
    private ArrayList<Movie> movies;

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public MovieAdapter(Context c) {
        this.c = c;
        movies = new ArrayList<>();
    }


    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(c).inflate(R.layout.item_movie, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        Movie movie = (Movie) getItem(i);
        viewHolder.bind(movie);
        return view;
    }

    private class ViewHolder {
        private TextView tvTitle, tvRelease, tvGenre, tvDescription;
        private ImageView imgPhoto;

        ViewHolder(View view) {
            tvTitle = view.findViewById(R.id.tv_title);
            tvRelease = view.findViewById(R.id.tv_release);
            tvGenre = view.findViewById(R.id.tv_genre);
            tvDescription = view.findViewById(R.id.tv_description);
            imgPhoto = view.findViewById(R.id.img_photo);
        }

        void bind(Movie movie) {
            tvTitle.setText(movie.getTitle());
            tvRelease.setText(movie.getRelease());
            tvGenre.setText(movie.getGenre());
            tvDescription.setText(movie.getDescription());
            imgPhoto.setImageResource(movie.getPhoto());
        }
    }
}
