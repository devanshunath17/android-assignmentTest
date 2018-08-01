package com.app.assignmenttest.Ui.Activity;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.app.assignmenttest.Ui.Fragment.ListOfFactsFragment;
import com.app.assignmenttest.Utils.SetTitle;
import com.app.assignmenttest.R;


/**
 * Created by Devanshu Nath Tripathi on 17/7/18.
 */

public class ListOfFactsActivity extends AppCompatActivity implements SetTitle {

    private ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facts_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();

        ListOfFactsFragment myFragment = new ListOfFactsFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        replaceFragment(R.id.container, myFragment, ListOfFactsFragment.class.getSimpleName());
        transaction.commit();

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    /* common method replace the fragment
    * */
    protected void replaceFragment(@IdRes int container, Fragment fragment, String tag) {
        getFragmentManager().beginTransaction().replace(container, fragment, tag).commit();

    }

    @Override
    public void onTitle(String Title) {
        actionBar.setTitle(Title);
    }

    @Override
    public void onBackPressed() {

        // Build an AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // Set a title for alert dialog
        builder.setTitle(getResources().getString(R.string.app_name));

        // Ask the final question
        builder.setMessage(getResources().getString(R.string.alert));

        // Set the alert dialog yes button click listener
        builder.setPositiveButton(getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Do something when user clicked the Yes button
                // Set the TextView visibility GONE

                finish();

            }
        });

        // Set the alert dialog no button click listener
        builder.setNegativeButton(getResources().getString(R.string.no), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Do something when No button clicked
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        // Display the alert dialog on interface
        dialog.show();

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

}
