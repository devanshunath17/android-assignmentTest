package com.app.assignmenttest.Observer.Manager;

import android.support.annotation.NonNull;

import com.birbit.android.jobqueue.JobManager;
import com.birbit.android.jobqueue.scheduling.FrameworkJobSchedulerService;

/**
 * Created by Devanshu 26 july 2018
 */

public class AppJobService extends FrameworkJobSchedulerService {

    @NonNull
    @Override
    protected JobManager getJobManager() {
        return AppJobManager.getJobManager();
    }
}