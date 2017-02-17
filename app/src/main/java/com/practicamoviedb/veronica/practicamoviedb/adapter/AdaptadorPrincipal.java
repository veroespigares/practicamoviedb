package com.practicamoviedb.veronica.practicamoviedb.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.practicamoviedb.veronica.practicamoviedb.R;
import com.practicamoviedb.veronica.practicamoviedb.model.Movie;

import java.util.List;

public class AdaptadorPrincipal extends ArrayAdapter<Movie> {

    private Context context;
    private List<Movie> items;

    public AdaptadorPrincipal(Context context, List<Movie> movieList) {
        super(context, 0, movieList);
        this.items = movieList;
    }

    @Override
    public int getCount() {
        return this.items.size();
    }

    @Override
    public Movie getItem(int position) {
        return this.items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView = convertView;

        if (convertView == null) {
            // Create a new view into the list.
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.listitem_principal, parent, false);
        }

        // Set data into the view.
        ImageView ivItem = (ImageView) rowView.findViewById(R.id.ivItem);
        TextView tvTitle = (TextView) rowView.findViewById(R.id.tvTitle);

        Movie item = this.items.get(position);
        tvTitle.setText(item.getTitle());
        ivItem.setImageResource(item.getImagen());

        return rowView;
    }

    public AdaptadorPrincipal onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AdaptadorPrincipal(context,items);
    }

}
