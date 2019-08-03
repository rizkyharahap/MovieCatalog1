package com.example.submission1.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.submission1.R;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Movie> movies;

    public void setMovie(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public MovieAdapter(Context context) {
        this.context = context;
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
    public View getView(int i, View view, ViewGroup parent) {

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        }

        ViewHolder holder = new ViewHolder(view);
        Movie movie = (Movie) getItem(i);
        holder.binding(movie);

        return view;
    }

    private class ViewHolder {

        private ImageView poster;
        private TextView name;
        private TextView rating;
        private TextView year;
        private TextView description;

        ViewHolder(View view) {
            poster = view.findViewById(R.id.image_movie);
            name = view.findViewById(R.id.title);
            rating = view.findViewById(R.id.rating);
            year = view.findViewById(R.id.year);
            description = view.findViewById(R.id.description);
        }

        void binding(Movie movie) {
            poster.setImageResource(movie.getPoster());
            name.setText(movie.getName());
            rating.setText(movie.getRating());
            year.setText(movie.getYear());
            description.setText(movie.getDescription());

        }
    }
}
