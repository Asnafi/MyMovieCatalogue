package com.tryoasnafi.mymoviecatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.tryoasnafi.mymoviecatalogue.model.Movie;

public class DetailMovieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        ImageView imgPhoto = findViewById(R.id.img_photo);
        TextView tvTitle = findViewById(R.id.tv_title);
        TextView tvRelease = findViewById(R.id.tv_release_value);
        TextView tvGenre = findViewById(R.id.tv_genre_value);
        TextView tvRuntime = findViewById(R.id.tv_runtime_value);
        TextView tvDescription = findViewById(R.id.tv_description);

        Movie movie = getIntent().getParcelableExtra("Movies");
        tvTitle.setText(movie.getTitle());
        tvRelease.setText(movie.getRelease());
        tvGenre.setText(movie.getGenre());
        tvRuntime.setText(movie.getRuntime());
        tvDescription.setText(movie.getDescription());

        Glide.with(this)
                .load(movie.getPhoto())
                .apply(new RequestOptions().override(140, 200))
                .into(imgPhoto);


    }
}
