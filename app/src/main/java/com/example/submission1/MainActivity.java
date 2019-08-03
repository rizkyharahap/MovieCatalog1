package com.example.submission1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.submission1.Model.MovieAdapter;
import com.example.submission1.Model.Movie;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] movieTitle, movieRating, movieYear, movieReleaseDate, movieDuration, movieGenre, movieDescription;
    private TypedArray moviePoster;
    private MovieAdapter adapter;
    private ArrayList<Movie> movies;
    ListView listMovie;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MovieAdapter(this);
        listMovie = findViewById(R.id.lv_movie);
        listMovie.setAdapter(adapter);

        resource();
        itemList();

        listMovie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DescriptionActivity.class);
                intent.putExtra("extra_movie", movies.get(i));
                startActivity(intent);
            }
        });
    }

    public void resource () {

        movieTitle = getResources().getStringArray(R.array.movie_title);
        movieRating = getResources().getStringArray(R.array.movie_rating);
        movieYear = getResources().getStringArray(R.array.movie_year);
        movieReleaseDate = getResources().getStringArray(R.array.movie_release_date);
        movieDuration = getResources().getStringArray(R.array.movie_duration);
        movieGenre = getResources().getStringArray(R.array.movie_genre);
        movieDescription = getResources().getStringArray(R.array.movie_description);
        moviePoster = getResources().obtainTypedArray(R.array.movie_poster);

    }

    public void itemList() {
        movies = new ArrayList<>();

        for (int i = 0; i < movieTitle.length; i++) {
            Movie movie = new Movie();
            movie.setPoster(moviePoster.getResourceId(i, -1));
            movie.setName(movieTitle[i]);
            movie.setRating(movieRating[i]);
            movie.setYear(movieYear[i]);
            movie.setReleaseDate(movieReleaseDate[i]);
            movie.setDuration(movieDuration[i]);
            movie.setGenre(movieGenre[i]);
            movie.setDescription(movieDescription[i]);
            movies.add(movie);
        }
        adapter.setMovie(movies);
    }
}
