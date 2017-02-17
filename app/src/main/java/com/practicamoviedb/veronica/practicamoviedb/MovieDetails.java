package com.practicamoviedb.veronica.practicamoviedb;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.practicamoviedb.veronica.practicamoviedb.fragment.details;
import com.practicamoviedb.veronica.practicamoviedb.rest.ApiClient;
import com.practicamoviedb.veronica.practicamoviedb.rest.ApiInterface;

/**
 * Created by Verónica on 14/02/2017.
 */

public class MovieDetails extends Activity{
    ApiInterface apiService;
    private ImageView imgv;
    static final int REQUEST_CODE=1;
    Integer id;

    // TODO - insert your themoviedb.org API KEY here
    private final static String API_KEY = "7e8f60e325cd06e164799af1e317d7a7";
    private static final String TAG = MainActivity.class.getSimpleName();
    private GoogleApiClient client;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Display a indeterminate progress bar on title bar
        requestWindowFeature(0);

        this.setContentView(R.layout.activity_details);

        imgv = (ImageView) findViewById(R.id.ivItem);
        Bundle bundle = getIntent().getExtras();
        id  = getIntent().getExtras().getInt("pelicula");
        //CONSULTA PELÍCULAS POPULARES:
        if (API_KEY.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please obtain your API KEY from themoviedb.org first!", Toast.LENGTH_LONG).show();
            return;
        }

         apiService = ApiClient.getClient().create(ApiInterface.class);
        System.out.println("hola hola");
        Bundle arguments = new Bundle();
        arguments.putInt("id", bundle.getInt("pelicula"));
        arguments.putInt("pos", bundle.getInt("pos"));
        details fragment = details.newInstance(arguments);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(android.R.id.content, fragment, details.TAG);


        ft.commit();

        System.out.println("ID: "+id);
      /* Call<MoviesResponse> call = apiService.getMovieDetail(id,API_KEY);
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                int statusCode = response.code();
                Movie result = (Movie) response.body().getResults();
                System.out.println("FECHA: "+result.release_date);
                MoviesDetailsAdapter m = new MoviesDetailsAdapter(getBaseContext(),result);
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });*/
       // client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /*protected void onActivityResult(int requestCode, int resultCode, Intent i2){

        System.out.println("Estoy aqui");
        if( apiService==null)
            apiService = ApiClient.getClient().create(ApiInterface.class);

        if(resultCode==RESULT_OK && REQUEST_CODE==requestCode){
            Call<MoviesResponse> call = apiService.getMovieDetails(id,API_KEY);
            call.enqueue(new Callback<MoviesResponse>() {
                @Override
                public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                    int statusCode = response.code();
                    Movie result = (Movie) response.body().getResults();
                    //Cuando usamos un Call se pasa getBaseContext();
                    MoviesDetailsAdapter m = new MoviesDetailsAdapter(getBaseContext(),result);
                }

                @Override
                public void onFailure(Call<MoviesResponse> call, Throwable t) {
                    // Log error here since request failed
                    Log.e(TAG, t.toString());
                }
            });
            System.out.println("ID: "+id);
        }
        super.onActivityResult(requestCode, resultCode, i2);
    }*/
}
