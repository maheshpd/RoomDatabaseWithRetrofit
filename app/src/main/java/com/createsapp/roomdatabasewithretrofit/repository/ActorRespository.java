package com.createsapp.roomdatabasewithretrofit.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.createsapp.roomdatabasewithretrofit.dao.ActorDao;
import com.createsapp.roomdatabasewithretrofit.database.ActorDatabase;
import com.createsapp.roomdatabasewithretrofit.model.Actor;

import java.util.List;

public class ActorRespository {
    private ActorDatabase database;
    private LiveData<List<Actor>> getAllActors;

    public ActorRespository(Application application) {
        database = ActorDatabase.getInstance(application);
        getAllActors = database.actorDao().getAllActors();
    }

    public void insert(List<Actor> actorList) {
        new InsertAsyncTask(database).execute(actorList);
    }

    public LiveData<List<Actor>> getAllActors() {
        return getAllActors;
    }

    static class InsertAsyncTask extends AsyncTask<List<Actor>, Void, Void> {
        private ActorDao actorDao;

        InsertAsyncTask(ActorDatabase actorDatabase) {
            actorDao = actorDatabase.actorDao();
        }

        @Override
        protected Void doInBackground(List<Actor>... lists) {
            actorDao.insert(lists[0]);
            return null;
        }

    }

}
