package com.github.eragontuan.cinema_project03_11_2018.Models;

import android.content.Context;
import android.graphics.Movie;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.eragontuan.cinema_project03_11_2018.R;
import com.squareup.picasso.Picasso;


import java.util.List;

public class MovieAdapter extends BaseAdapter {

    private List<com.github.eragontuan.cinema_project03_11_2018.Models.Movie> mMovieList;
    private Context mContext;

    //constructor
    public MovieAdapter(List<com.github.eragontuan.cinema_project03_11_2018.Models.Movie> movieList, Context context) {
        mMovieList = movieList;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mMovieList.size();
    }

    @Override
    public Object getItem(int position) {
        return mMovieList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rootView = convertView;
        if(rootView==null){
            LayoutInflater inflater = LayoutInflater.from(mContext);
            View rowView = inflater.inflate(R.layout.layout_item, null);

            //TODO: references_to_widgets from layout_item
            TextView name = (TextView) rowView.findViewById(R.id.label);
            ImageView imageView = (ImageView)rowView.findViewById(R.id.image);

            //TODO: Set Data
            Picasso.get().load(mMovieList.get(position).getImageURL()).into(imageView);
            name.setText(mMovieList.get(position).getName());
            return rowView;
        }
        return rootView;
    }
}
