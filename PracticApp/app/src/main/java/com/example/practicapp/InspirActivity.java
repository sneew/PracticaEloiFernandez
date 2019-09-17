package com.example.practicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.practicapp.model.Ghibli;
import com.example.practicapp.model.Pelicula;
import com.example.practicapp.retrofit.MyService;
import com.example.practicapp.retrofit.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InspirActivity extends AppCompatActivity {

    ListView listViewGhibli;
    ArrayList<Ghibli> ghiblis;
    GhibliAdapter adapter;
    ProgressBar pbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspir);

        pbar = findViewById(R.id.progresBar);
        listViewGhibli = findViewById(R.id.listViewGhibli);
        ghiblis = new ArrayList<>();
        adapter = new GhibliAdapter(this, R.layout.row2, ghiblis);
        listViewGhibli.setAdapter(adapter);

        getSupportActionBar().setTitle(R.string.inspira);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getGhibliFromServer();
    }

    private void getGhibliFromServer() {
        pbar.setVisibility(View.VISIBLE);
        MyService service = RetrofitClientInstance.getRetrofitInstance().create(MyService.class);

        Call<List<Ghibli>> call = service.listGhiblis();

        call.enqueue(new Callback<List<Ghibli>>() {
            @Override
            public void onResponse(Call<List<Ghibli>> call, Response<List<Ghibli>> response) {
                if(response.body() != null){
                    ghiblis.clear();
                    ghiblis.addAll(response.body());

                    adapter.notifyDataSetChanged();
                    pbar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<List<Ghibli>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),R.string.errorGhibli, Toast.LENGTH_LONG).show();
            }
        });
    }
}
