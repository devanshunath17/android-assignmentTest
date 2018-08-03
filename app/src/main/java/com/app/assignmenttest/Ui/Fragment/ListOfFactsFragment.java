package com.app.assignmenttest.Ui.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.app.assignmenttest.Data.Adapters.AdapterofFactsActivity;
import com.app.assignmenttest.Ui.Activity.ListOfFactsActivity;
import com.app.assignmenttest.R;
import com.app.assignmenttest.Ui.Entity.ListItem;
import com.app.assignmenttest.Utils.Preference;
import com.app.assignmenttest.Utils.StaticData;
import com.app.assignmenttest.Data.Db.database.AppDatabase;
import com.app.assignmenttest.Observer.Event.GetList;
import com.app.assignmenttest.Observer.Job.FetchListFromserver;
import com.app.assignmenttest.Observer.Manager.AppJobManager;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Devanshu Nath Tripathi on 17/7/18.
 */

public class ListOfFactsFragment extends Fragment {
    private View view;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private ArrayList<ListItem> factsList = new ArrayList<ListItem>();
    private AdapterofFactsActivity mAdapter;
    private ProgressBar progress;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list, container, false);

        inItView(view);

        String title = Preference.getInstance(getActivity()).getString(StaticData.TITLE);
        if (!TextUtils.isEmpty(title)) {
            if (getActivity() != null) {
                ((ListOfFactsActivity) getActivity()).onTitle(title);
            }
        }

        AppDatabase db = AppDatabase.getAppDatabase(getActivity());
        List<ListItem> listItemList = db.userDao().getAll();
        if (listItemList.size() > 0) {
            factsList.clear();
            factsList.addAll(listItemList);
            UpdateUI();
        } else {
            fireJob();
        }
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    /*
   * here we define  the each  Id
   * */
    private void inItView(View view) {

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.simpleSwipeRefreshLayout);
        recyclerView = (RecyclerView) view.findViewById(R.id.factsList);
        progress = (ProgressBar) view.findViewById(R.id.progress);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);

        /*for refreshing the List
        * */
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // implement Handler to wait for 3 seconds and then update UI means update value of TextView
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // cancle the Visual indication of a refresh
                        swipeRefreshLayout.setRefreshing(false);
                        AppDatabase db = AppDatabase.getAppDatabase(getActivity());
                        List<ListItem> listItemList = db.userDao().getAll();
                        if (listItemList.size() > 0) {
                            factsList.clear();
                            factsList.addAll(listItemList);
                            UpdateUI();
                        } else {
                            AppJobManager.getJobManager().addJobInBackground(new FetchListFromserver(getActivity(), false, true));

                        }
                    }
                }, 3000);
            }
        });


    }

    /*
     * this event call when we retrive the data from server
     * */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(GetList event) {
        factsList.clear();
        List<ListItem> list = event.getListItemList();
        factsList.addAll(list);
        UpdateUI();
    }

    /*
    *
    * here we update the UI*/
    public void UpdateUI() {
        progress.setVisibility(View.GONE);
        String title = Preference.getInstance(getActivity()).getString(StaticData.TITLE);
        if (!TextUtils.isEmpty(title)) {
            if (getActivity() != null) {
                ((ListOfFactsActivity) getActivity()).onTitle(title);
            }
        }
        mAdapter = new AdapterofFactsActivity(getActivity(), factsList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }

    /*
    * fire Job for Retriving the list from server and save into the Database .
    * */
    public void fireJob() {
        progress.setVisibility(View.VISIBLE);
        AppJobManager.getJobManager().addJobInBackground(new FetchListFromserver(getActivity(), false, true));

    }

}
