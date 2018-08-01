package com.app.assignmenttest.Utils;


import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;
import com.app.assignmenttest.Data.Db.database.AppDatabase;
import com.app.assignmenttest.Observer.Event.GetList;
import com.app.assignmenttest.Ui.Entity.ListItem;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class DatabaseInitializer {
    ArrayList<ListItem> factsList;
    private static final String TAG = DatabaseInitializer.class.getName();

    public void populateAsync(@NonNull final AppDatabase db, ArrayList<ListItem> factsList) {
        this.factsList = factsList;
        PopulateDbAsync task = new PopulateDbAsync(db);
        task.execute();
    }

    public void populateSync(@NonNull final AppDatabase db) {
        populateWithTestData(db);
    }

    private ListItem addItems(final AppDatabase db, ListItem listItem) {
        db.userDao().insertAll(listItem);
        return listItem;
    }

    public void deleteData(final AppDatabase db) {
        db.userDao().delete();
    }

    private void populateWithTestData(AppDatabase db) {
        for (int i = 0; i < factsList.size(); i++) {
            ListItem listItem = new ListItem();
            if (factsList.get(i).getTitle() != null)
                listItem.setTitle(factsList.get(i).getTitle());

            if (factsList.get(i).getDescription() != null)
                listItem.setDescription(factsList.get(i).getDescription());
            if (factsList.get(i).getImage() != null)
                listItem.setImage(factsList.get(i).getImage());
            addItems(db, listItem);
        }


        List<ListItem> listItemList = db.userDao().getAll();
        Log.d(DatabaseInitializer.TAG, "Rows Count: " + listItemList.size());
        EventBus.getDefault().post(new GetList(listItemList));
    }

    private class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final AppDatabase mDb;

        PopulateDbAsync(AppDatabase db) {
            mDb = db;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithTestData(mDb);
            return null;
        }

    }
}
