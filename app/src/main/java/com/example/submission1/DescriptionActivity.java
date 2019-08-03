package com.example.submission1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.submission1.Model.Movie;

public class DescriptionActivity extends AppCompatActivity {

    TextView movieTitle,
            movieRating,
            movieReleaseDate,
            movieDuration,
            movieGenre,
            movieDescription;
    ImageView moviePoster,
            movieBackdrop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        movieTitle = findViewById(R.id.title);
        movieRating = findViewById(R.id.rating);
        movieReleaseDate = findViewById(R.id.release_date);
        movieDuration = findViewById(R.id.duration);
        movieGenre = findViewById(R.id.genre);
        movieDescription = findViewById(R.id.description);
        moviePoster = findViewById(R.id.image_movie);
        movieBackdrop = findViewById(R.id.backdrop_image);

        Movie movie = getIntent().getParcelableExtra("extra_movie");

        assert movie != null;
        movieBackdrop.setImageResource(movie.getPoster());
        moviePoster.setImageResource(movie.getPoster());
        movieTitle.setText(movie.getName());
        movieRating.setText(movie.getRating());
        movieReleaseDate.setText(movie.getReleaseDate());
        movieDuration.setText(movie.getDuration());
        movieGenre.setText(movie.getGenre());
        movieDescription.setText(movie.getDescription());


    }
}
