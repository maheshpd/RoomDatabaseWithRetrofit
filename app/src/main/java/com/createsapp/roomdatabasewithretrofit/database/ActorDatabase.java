package com.createsapp.roomdatabasewithretrofit.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.createsapp.roomdatabasewithretrofit.dao.ActorDao;
import com.createsapp.roomdatabasewithretrofit.model.Actor;

@Database(entities = {Actor.class}, version = 1)
public abstract class ActorDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "ActorDatabase";
    private static volatile ActorDatabase INSTANCE;
    static Callback callback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateAsyncTask(INSTANCE);
        }
    };

    public static ActorDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (ActorDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, ActorDatabase.class,
                            DATABASE_NAME)
                            .addCallback(callback).build();
                }
            }
        }

        return INSTANCE;
    }

    public abstract ActorDao actorDao();

    static class PopulateAsyncTask extends AsyncTask<Void, Void, Void> {
        private ActorDao actorDao;

        PopulateAsyncTask(ActorDatabase actorDatabase) {
            actorDao = actorDatabase.actorDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            actorDao.delete();
            return null;
        }
    }

}
