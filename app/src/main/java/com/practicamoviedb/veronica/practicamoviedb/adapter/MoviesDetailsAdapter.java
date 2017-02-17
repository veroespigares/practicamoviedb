
/**
 * Created by Verónica on 14/02/2017.
 */

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

    public class MoviesDetailsAdapter extends BaseAdapter {

        private Movie movies;
        private int rowLayout;

        private boolean isThereMoreToLoad = true;
        private int currantPage = 0;
        private Context context;


        public MoviesDetailsAdapter(Context context,Movie items) {
            this.context = context;
            this.movies = items;
        }

        @Override
        public int getCount() {
            return 1;
        }

        @Override
        public Object getItem(int position) {
            return movies;
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
                v = inflater.inflate(R.layout.activity_details, parent, false);
            }

            TextView tt1 = (TextView) v.findViewById(R.id.tvTitle);
            ImageView tt2 = (ImageView) v.findViewById(R.id.ivItem);
            /*TextView tt3 = (TextView) v.findViewById(R.id.tvValoracion);
            TextView tt4 = (TextView) v.findViewById(R.id.tvDuracion);
            TextView tt5 = (TextView) v.findViewById(R.id.tvSinopsis);
            TextView tt6 = (TextView) v.findViewById(R.id.tvAno);
            TextView tt7 = (TextView) v.findViewById(R.id.tvVotos);


            tt1.setText(movies.getTitle());
            new ImageDownloader(tt2).execute("https://image.tmdb.org/t/p/w500/" + movies.getPosterPath());
            tt3.setText(movies.getVoteAverage().toString());
         //   tt4.setText(movies.get);
            tt5.setText(movies.getOverview());
            //Cortamos de la fecha solo el año
            String f = movies.getReleaseDate();
            String [] fecha = f.split("-");
            String anio = fecha[0];
            tt6.setText(anio);
            System.out.println("Valoracion: "+tt3+" sinopsis "+tt5+" año "+tt6+" votos "+tt7);
            tt7.setText(movies.getVoteCount());*/

            return v;
        }

    }

