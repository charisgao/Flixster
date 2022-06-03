package com.example.flixster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.flixster.models.Movie;

import org.parceler.Parcels;

public class MovieDetailsActivity extends AppCompatActivity {

    // Movie to display
    Movie movie;

    // View objects
    TextView tvDetailsTitle;
    TextView tvDetailsOverview;
    RatingBar rbVoteAverage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        tvDetailsTitle = (TextView) findViewById(R.id.tvDetailsTitle);
        tvDetailsOverview = (TextView) findViewById(R.id.tvDetailsOverview);
        rbVoteAverage = (RatingBar) findViewById(R.id.rbVoteAverage);

        // Unwrap the movie passed in via intent, using its simple name as a key
        movie = (Movie) Parcels.unwrap(getIntent().getParcelableExtra(Movie.class.getSimpleName()));
        Log.d("MovieDetailsActivity", String.format("Showing details for '%s'", movie.getTitle()));

        // Set the title and overview
        tvDetailsTitle.setText(movie.getTitle());
        tvDetailsOverview.setText(movie.getOverview());

        float voteAverage = movie.getVoteAverage().floatValue();
        rbVoteAverage.setRating(voteAverage / 2.0f);



//        String imageUrl;
//        int imagePlaceholder;
//
//        // Landscape
//        if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            imageUrl = movie.getBackdropPath();
//            imagePlaceholder = R.drawable.flicks_backdrop_placeholder;
//        }
//        //Portrait
//        else {
//            imageUrl = movie.getPosterPath();
//            imagePlaceholder = R.drawable.flicks_movie_placeholder;
//        }
//
//        Glide.with(context).load(imageUrl).placeholder(imagePlaceholder).error(imagePlaceholder).into(ivPoster);
    }
}