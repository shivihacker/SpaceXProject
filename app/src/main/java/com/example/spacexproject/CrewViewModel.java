package com.example.spacexproject;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class CrewViewModel extends AndroidViewModel {

    private CrewRepository repository;
    private LiveData<List<Model>> allCrews;

    public CrewViewModel(@NonNull Application application) {
        super(application);
        repository=new CrewRepository(application);
        allCrews =repository.getAllCrews();
    }
    public void insert(List<Model> model){
        repository.insert(model);
    }

//    public void delete(Model model){
//        repository.delete(model);
//    }

    public LiveData<List<Model>> getAllCrews(){
        return allCrews;
    }
}
