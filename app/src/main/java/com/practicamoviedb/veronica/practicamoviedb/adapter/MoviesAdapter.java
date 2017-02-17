package com.practicamoviedb.veronica.practicamoviedb.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.practicamoviedb.veronica.practicamoviedb.R;
import com.practicamoviedb.veronica.practicamoviedb.model.Movie;
import com.practicamoviedb.veronica.practicamoviedb.model.ImageDownloader;

import java.util.List;

public class MoviesAdapter extends BaseAdapter {

    private List<Movie> movies;
    private int rowLayout;

    private boolean isThereMoreToLoad = true;
    private int currantPage = 0;
    private Context context;


    public MoviesAdapter(Context context, List<Movie> items) {
        this.context = context;
        this.movies = items;
    }

    @Override
    public int getCount() {
        return this.movies.size();
    }

    @Override
    public Object getItem(int position) {
        return this.movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.listitem_principal, parent, false);
        }

            TextView tt1 = (TextView) v.findViewById(R.id.tvTitle);
            ImageView tt2 = (ImageView) v.findViewById(R.id.ivItem);

            Movie item = this.movies.get(position);
            tt1.setText(item.getTitle());
            new ImageDownloader(tt2).execute("https://image.tmdb.org/t/p/w500/" + item.getPosterPath());

        return v;
    }

}