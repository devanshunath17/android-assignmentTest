# Android MVVM Architecture: AssignmentTest
This repository contains a detailed sample app that implements MVVM architecture using Event, Room, job , Retrofit.

#### The app has following packages:
1. **Data**: It contains all the data accessing and manipulating components.
2. **Observer**: it contains Event , Job , JobManager for observing the data.
3. **Ui**: View classes along with their corresponding ViewModel.
4. **utils**: Utility classes.

#### Classes have been designed in such a way that it could be inherited and maximize the code reuse.

### Library reference resources:
1. Android DataBinding : https://developer.android.com/topic/libraries/data-binding/
2. JobScheduler: https://developer.android.com/reference/android/app/job/JobScheduler
3. Event: http://greenrobot.org/eventbus/
4. Room Persistence: https://developer.android.com/topic/libraries/architecture/room
5. Retrofit: http://square.github.io/retrofit/
6. Glide: https://www.androidhive.info/2016/04/android-glide-image-library-building-image-gallery-app/

# Technology used
1. JobScheduler : compile 'com.birbit:android-priority-jobqueue:2.0.0-beta1'
2. Event :  compile 'org.greenrobot:eventbus:3.0.0'
3. Room Persistence :  implementation "android.arch.persistence.room:runtime:1.0.0"
                       annotationProcessor "android.arch.persistence.room:compiler:1.0.0"
4. Retrofit : compile 'com.squareup.retrofit2:converter-gson:2.1.0'
5. Glide : compile 'com.github.bumptech.glide:glide:3.7.0'
6. Android DataBinding

# Android DataBinding
With Data Binding you can write less boilerplate and repetitive code. It moves UI operations out of the activities and fragments to the XML layout.

* Layout variables and expressions
* Binding Adapters, Binding Methods and Binding Converters
* Seamless integration with ViewModels

# Layout variables and expressions
For example, instead of setting text on a TextView in an activity:
```java
TextView textView = findViewById(R.id.txtTitle);
textView.setText(listItem.title);
```
You assign the attribute to a variable, in the XML layout:
```xml
<TextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="@{listItem.title}" />
 ```
 # Binding adapters
 Binding adapters let you customize or create layout attributes. For example:
 ```kotlin
  @BindingAdapter("imageUrl")
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl)
                .into(view);
                 }
```
   
   Using binding adapters lets you move UI calls from the activity to static methods, improving encapsulation.

             
   
 


