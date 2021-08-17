package com.example.spacexproject;


import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.List;

import javax.security.auth.callback.Callback;

@Database(entities = {Model.class},version = 5)
public abstract class CrewDatabase extends RoomDatabase {
    private static CrewDatabase instance =null;

    public abstract CrewDao crewDao();

    public static synchronized CrewDatabase getInstance(Context context){
        if (instance==null){
            instance= Room.databaseBuilder(context.getApplicationContext(),
                    CrewDatabase.class,"crew_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallBack)
                    .build();
        }
        return instance;
    }
    private static Callback roomCallBack = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
//            new PopulateDbASyncTask(instance).execute();
            new PopulateDbASyncTask(instance);
        }
    };

    private static class PopulateDbASyncTask extends AsyncTask<Void, Void, Void> {
        //Model data;
        private CrewDao crewDao;
        private PopulateDbASyncTask(CrewDatabase db) {
            crewDao = db.crewDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            crewDao.deleteAll();
            return null;
//            crewDao.insert(new Model();
//            crewDao.insert(new Model("Jimmy Roy","467951625659"));
//            return null;
        }
    }
}
