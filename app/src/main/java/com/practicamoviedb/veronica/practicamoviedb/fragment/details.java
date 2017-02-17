package com.practicamoviedb.veronica.practicamoviedb.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.practicamoviedb.veronica.practicamoviedb.R;
import com.practicamoviedb.veronica.practicamoviedb.adapter.MoviesAdapter;
import com.practicamoviedb.veronica.practicamoviedb.model.ImageDownloader;
import com.practicamoviedb.veronica.practicamoviedb.model.Movie;
import com.practicamoviedb.veronica.practicamoviedb.model.MoviesResponse;
import com.practicamoviedb.veronica.practicamoviedb.rest.ApiClient;
import com.practicamoviedb.veronica.practicamoviedb.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class details extends Fragment {
    Integer id;
    static Bundle bundle ;
    // TODO - insert your themoviedb.org API KEY here
    private final static String API_KEY = "7e8f60e325cd06e164799af1e317d7a7";

    public static final String TAG = "ExampleFragment";
        private Button boton;
        private EditText edit;
        private TextView text;

    public static details newInstance(Bundle arguments){
        details f = new details();
        bundle = arguments;
        if(arguments != null){
            f.setArguments(arguments);
        }
        return f;
    }

    public details(){

    }

    //El fragment se ha adjuntado al Activity
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }




        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.activity_details, container, false);

            //Nuevos parametros para el view del fragmento
            RelativeLayout.LayoutParams params =    new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.MATCH_PARENT);
            //Nueva Regla: EL fragmento estara debajo del boton add_fragment
           // params.addRule(RelativeLayout.BELOW, R.id.add_fragment);
            //Margenes: top:41dp
            params.setMargins(0,41,0,0);
            //Setear los parametros al view
            view.setLayoutParams(params);



            ImageView imageView = (ImageView) view.findViewById(R.id.icono);

            final TextView tt1 = (TextView) view.findViewById(R.id.tvTitle);
            final ImageView tt2 = (ImageView) view.findViewById(R.id.ivItem);
            final TextView tt3 = (TextView) view.findViewById(R.id.tvValoracion);
            final TextView tt4 = (TextView) view.findViewById(R.id.tvDuracion);
            final TextView tt5 = (TextView) view.findViewById(R.id.tvSinopsis);
            final TextView tt6 = (TextView) view.findViewById(R.id.tvAno);
            final TextView tt7 = (TextView) view.findViewById(R.id.tvVotos);
            ApiInterface  apiService = ApiClient.getClient().create(ApiInterface.class);

             id = getArguments().getInt("id");
            Call<MoviesResponse> call = apiService.getTopRatedMovies(API_KEY);
            call.enqueue(new Callback<MoviesResponse>() {
                             @Override
                             public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                                 int statusCode = response.code();
                                 List<Movie> result =  response.body().getResults();
                                 System.out.println("FECHA: "+result.get(0).getReleaseDate());
                                 MoviesAdapter m = new MoviesAdapter(getActivity(),result);
                                 System.out.println("TAMAÑO: "+result.get(0).getTitle()+"ID: "+id+" "+result.get(0).getId());
                                 for(int i=0; i<result.size(); i++){
                                     System.out.println("ID LISTA: "+result.get(i).getId()+"ID: "+id);
                                     if((int)result.get(i).getId()==id){
                                         tt1.setText(result.get(i).getTitle());
                                         new ImageDownloader(tt2).execute("https://image.tmdb.org/t/p/w500/" + result.get(i).getPosterPath());
                                         tt3.setText(result.get(i).getVoteAverage().toString());
                                         tt5.setText(result.get(i).getOverview());
                                         //Cortamos de la fecha solo el año
                                         String f = result.get(i).getReleaseDate();
                                         String [] fecha = f.split("-");
                                         String anio = fecha[0];
                                         tt6.setText(anio);
                                         //tt7.setText(result.get(i).getVoteCount());

                                     }
                                 }
                             }

                             @Override
                             public void onFailure(Call<MoviesResponse> call, Throwable t) {
                                 // Log error here since request failed
                                 Log.e(TAG, t.toString());
                             }


        });
            return view;
        }

    //La vista de layout ha sido creada y ya está disponible
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    //La vista ha sido creada y cualquier configuración guardada está cargada
    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
    }

    //El Activity que contiene el Fragment ha terminado su creación
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    //El Fragment ha sido quitado de su Activity y ya no está disponible
    @Override
    public void onDetach() {
        super.onDetach();
    }



    }