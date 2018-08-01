package com.app.assignmenttest.Observer.Manager;

import android.support.annotation.NonNull;
import com.birbit.android.jobqueue.JobManager;
import com.birbit.android.jobqueue.scheduling.GcmJobSchedulerService;

/**
 * Created by Devanshu 26 july 2018
 */
public class AppGcmJobService extends GcmJobSchedulerService {

    @NonNull
    @Override
    protected JobManager getJobManager() {
        return AppJobManager.getJobManager();
    }
}
