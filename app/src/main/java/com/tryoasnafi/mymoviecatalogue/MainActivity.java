package com.tryoasnafi.mymoviecatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.tryoasnafi.mymoviecatalogue.adapter.MovieAdapter;
import com.tryoasnafi.mymoviecatalogue.model.Movie;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] dataTitle;
    private String[] dataRelease;
    private String[] dataGenre;
    private String[] dataRuntime;
    private String[] dataDescription;
    private TypedArray dataPhoto;

    private MovieAdapter adapter;
    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MovieAdapter(this);
        ListView listView = findViewById(R.id.lv_movies);
        listView.setAdapter(adapter);

        prepare();

        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Details " + movies.get(i).getTitle(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, DetailMovieActivity.class);
                intent.putExtra("Movies", movies.get(i));
                startActivity(intent);
            }
        });

    }

    private void prepare() {
        dataTitle = getResources().getStringArray(R.array.data_title);
        dataRelease = getResources().getStringArray(R.array.data_release);
        dataGenre = getResources().getStringArray(R.array.data_genre);
        dataRuntime = getResources().getStringArray(R.array.data_runtime);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }

    private void addItem() {
        movies = new ArrayList<>();

        for (int i = 0; i < dataTitle.length; i++) {
            Movie movie = new Movie();
            movie.setPhoto(dataPhoto.getResourceId(i, -1));
            movie.setTitle(dataTitle[i]);
            movie.setRelease(dataRelease[i]);
            movie.setGenre(dataGenre[i]);
            movie.setRuntime(dataRuntime[i]);
            movie.setDescription(dataDescription[i]);
            movies.add(movie);
        }
        adapter.setMovies(movies);
    }
}
