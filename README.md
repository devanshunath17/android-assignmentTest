# Android MVVM Architecture: Sample App
This repository contains a detailed sample app that implements MVVM architecture using Event, Room, job , Retrofit.

#### The app has following packages:
1. **Data**: It contains all the data accessing and manipulating components.
2. **Observer**: it contains Event , Job , JobManager for observing the data.
3. **Ui**: View classes along with their corresponding ViewModel.
4. **utils**: Utility classes.

#### Classes have been designed in such a way that it could be inherited and maximize the code reuse.

### Library reference resources:
1. JobScheduler: https://developer.android.com/reference/android/app/job/JobScheduler
2. Event: http://greenrobot.org/eventbus/
3. Room Persistence: https://developer.android.com/topic/libraries/architecture/room
4. Retrofit: http://square.github.io/retrofit/
5. Glide: https://www.androidhive.info/2016/04/android-glide-image-library-building-image-gallery-app/

#Technology used
1. JobScheduler : compile 'com.birbit:android-priority-jobqueue:2.0.0-beta1'
2. Event :  compile 'org.greenrobot:eventbus:3.0.0'
3. Room Persistence :  implementation "android.arch.persistence.room:runtime:1.0.0"
                       annotationProcessor "android.arch.persistence.room:compiler:1.0.0"
4. Retrofit : compile 'com.squareup.retrofit2:converter-gson:2.1.0'
5. Glide : compile 'com.github.bumptech.glide:glide:3.7.0'

