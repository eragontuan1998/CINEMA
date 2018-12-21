package com.github.eragontuan.cinema_project03_11_2018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.github.eragontuan.cinema_project03_11_2018.Models.Common;
import com.github.eragontuan.cinema_project03_11_2018.Models.Movie;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class MovieDetail extends AppCompatActivity {
    KenBurnsView movie_image;
    TextView movie_title, movie_summary;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        //TODO: references_to_widget_layout

        references_to_widget();
        if (getIntent() != null) {
            int movie_index = getIntent().getIntExtra("movie_index", -1);
            if (movie_index != -1) {
                loadMovieDetail(movie_index);
            }
        }
    }

    private void references_to_widget() {
        movie_image = (KenBurnsView) findViewById(R.id.movie_image);
        movie_title = (TextView) findViewById(R.id.movie_title);
        movie_summary = (TextView) findViewById(R.id.movie_summary);
    }

    private void loadMovieDetail(int movie_index) {
        Movie movie = Common.mMovieList.get(movie_index);

        //Load images
        Picasso.get().load(movie.getImageURL()).into(movie_image);
        movie_title.setText(movie.getName());
        movie_summary.setText(movie.getSummary());
        movie_summary.setMovementMethod(new ScrollingMovementMethod()); //make your TextView can scroll
    }


}
