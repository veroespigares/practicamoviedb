package com.practicamoviedb.veronica.practicamoviedb;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.practicamoviedb.veronica.practicamoviedb.adapter.MoviesAdapter;
import com.practicamoviedb.veronica.practicamoviedb.model.Movie;
import com.practicamoviedb.veronica.practicamoviedb.model.MoviesResponse;
import com.practicamoviedb.veronica.practicamoviedb.rest.ApiClient;
import com.practicamoviedb.veronica.practicamoviedb.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity {

    private ListView listView;
    private ProgressDialog progressDialog;
    MoviesAdapter madapter;
    Movie item;

    // TODO - insert your themoviedb.org API KEY here
    private final static String API_KEY = "7e8f60e325cd06e164799af1e317d7a7";
    private static final String TAG = MainActivity.class.getSimpleName();
    private ArrayList<Movie> results = new ArrayList<>();
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Display a indeterminate progress bar on title bar
        requestWindowFeature(0);

        this.setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);


        //CONSULTA PELÍCULAS POPULARES:
        if (API_KEY.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please obtain your API KEY from themoviedb.org first!", Toast.LENGTH_LONG).show();
            return;
        }

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<MoviesResponse> call = apiService.getTopRatedMovies(API_KEY);
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                int statusCode = response.code();
                List<Movie> results = response.body().getResults();
                //Cuando usamos un Call se pasa getBaseContext();
                MoviesAdapter m = new MoviesAdapter(getBaseContext(),results);
                listView.setAdapter(m);
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view,
                                    int position, long arg) {

                // Show progress dialog
                progressDialog = ProgressDialog.show(MainActivity.this,
                        "ProgressDialog", "Loading!");

                // Loads the given URL
              item = (Movie) listView.getAdapter().getItem(position);
                System.out.println("FECHA: "+item.getId());
                Intent ii = new Intent(MainActivity.this, MovieDetails.class);
                Integer id = item.getId();
                ii.putExtra("pelicula", id);
                ii.putExtra("pos", position);
                startActivity(ii);
            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
    public void iniciarActivity() {
        Intent ii = new Intent(MainActivity.this, MovieDetails.class);
       /*Integer id = item.getId();
        i.putExtra("pelicula", id);*/
        startActivity(ii);
    }
}

