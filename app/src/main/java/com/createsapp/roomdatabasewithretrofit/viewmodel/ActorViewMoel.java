package com.createsapp.roomdatabasewithretrofit.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.createsapp.roomdatabasewithretrofit.model.Actor;
import com.createsapp.roomdatabasewithretrofit.repository.ActorRespository;

import java.util.List;

public class ActorViewMoel extends AndroidViewModel {
    private ActorRespository actorRespository;
    private LiveData<List<Actor>> getallAcotrs;

    public ActorViewMoel(@NonNull Application application) {
        super(application);

        actorRespository = new ActorRespository(application);
        getallAcotrs = actorRespository.getAllActors();
    }

    public void insert(List<Actor> list) {
        actorRespository.insert(list);
    }

    public LiveData<List<Actor>> getAllActor() {
        return getallAcotrs;
    }
}
