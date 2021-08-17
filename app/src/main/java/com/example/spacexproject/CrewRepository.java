package com.example.spacexproject;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class CrewRepository {

    private CrewDao crewDao;
    private LiveData<List<Model>> allCrews;

    public CrewRepository(Application application) {
        CrewDatabase database= CrewDatabase.getInstance(application);
        crewDao =database.crewDao();
        allCrews = crewDao.getMemberList();
    }

    public void insert(List<Model> model){
        new InsertContactAsyncTask(crewDao).execute(model);
    }

//    public void delete(Model model){
//        new DeleteContactAsyncTask(crewDao).execute(model);
//    }

    public LiveData<List<Model>> getAllCrews(){
        return allCrews;
    }

    public static class InsertContactAsyncTask extends AsyncTask<List<Model>, Void, Void> {
        private CrewDao crewDao;

        public InsertContactAsyncTask(CrewDao crewDao) {
            this.crewDao = crewDao;
        }

        @Override
        protected Void doInBackground(List<Model>... lists) {
            crewDao.insert(lists[0]);
            return null;
        }
    }

//    public static class DeleteContactAsyncTask extends AsyncTask<Model, Void, Void> {
//        private CrewDao crewDao;
//
//        public DeleteContactAsyncTask(CrewDao crewDao) {
//            this.crewDao = crewDao;
//        }
//
//        @Override
//        protected Void doInBackground(Model... models) {
//            crewDao.delete(models[0]);
//            return null;
//        }
//    }
}
