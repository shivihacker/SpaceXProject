package com.example.spacexproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private CrewViewModel crewViewModel;
    private List<Model> getmodel;
    private RecyclerView recyclerView;
    private CrewAdapter crewAdapter;
    private CrewRepository repository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        repository=new CrewRepository(getApplication());
        recyclerView=findViewById(R.id.recycler_view);
        getmodel=new ArrayList<>();
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        crewViewModel=new ViewModelProvider(this).get(CrewViewModel.class);

        crewAdapter=new CrewAdapter(getmodel,this);
        makeRequest();
        crewViewModel.getAllCrews().observe(this, new Observer<List<Model>>() {
            @Override
            public void onChanged(List<Model> models) {
                recyclerView.setAdapter(crewAdapter);
                Log.d("success","some data ");
                crewAdapter.getAllCrews(models);
                Log.d("main", "onChanged: "+ models);
            }
        });
    }

    private void makeRequest() {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.spacexdata.com/v4/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GetDataService api=retrofit.create(GetDataService.class);
        Call<List<Model>> call=api.getCrewMember();
        Log.d("hii","gjbkbnk");
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                if(response.isSuccessful()) {
                    repository.insert(response.body());

                    Log.d("successssss","Load data");
                }
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                Log.d("main", "onFailure: "+t.getMessage());
            }
        });
    }
}