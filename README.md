Setup of android databindings

Follow the guide on:
http://developer.android.com/tools/data-binding/guide.html

The important parts are:

Android Plugin for Gradle 1.5.0-beta3 or higher is required.

Add the dataBinding element to your build.gradle file in the app module.
```
android {
    ....
    dataBinding {
        enabled = true
    }
}
```
Use Android Studio 1.3 or later.

----------------------------------

What can we do with Data Bindings?

Bind "time" in Data.java to the_view (this is a TextView in main_activity.xml).

Use "StringUtil.format()" to format the text in the_view.

Make data.time observable, there are three way to do this supported by the Databinding lib. For this
lab to work further on make the Data object observable. Using a ObservableFields will not be flexible
enough for the later steps of this lab.
HINT: you need to make data.time observable by annotating the getter with @Bindable
and letting the setter call: notifyPropertyChanged(se.jayway.databinding.BR.time);

Let visibility of the_view depend on a boolean expression using the ternary operator.
the_view should only be visible if the expression "(data.time / 1000) % 3 == 0" is true.

Bind a handler to the onClick tag of the to handle click events. Change some property of the_view
on every click, for example you could set the background to a random color when the_view is clicked.

Remove the visibility nonsense we put in the_view earlier and make the_view display the value that
corresponds to key "1" in data.map.

the_view should now display "dies Lūnae".

Make data.index observable and change data.setTime() to look like:
```
    public void setTime(long time) {
        this.time = time;
        setIndex(time);
        notifyPropertyChanged(se.jayway.databinding.BR.time);
    }
```
this will make a call to update the index field when time is updated by our timer in MainActivity.

Change the key used in the_view to be data.index. the_view should now rotate through the values
from the data.map HashMap.

Did you notice that the_view goes blank after displaying "dies Saturnī", this is due to the data.map
not having any value for the key "7" resulting in a null being passed back.

When null is pased back make the_view display "No value found for the key.".
The ?? operator might be handy here.

Change the key to be "1" as before we used data.index as key.

Change data.map from HashMap to ObservableArrayMap, this will make the whole map observable and any
changes we make to the map should be reflected in the ui instantaneous.

Now to see that the data.map actually is observed, lets change the timer in MainActivity to:
```
    myTimer.schedule(new TimerTask() {
        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    data.map.setValueAt(data.map.indexOfKey("1"), StringUtil.format(System.currentTimeMillis()));
                }
            });
        }
    }, 0, 1000);
```
and now you should once again see time being displayed ino the_view.

Next step is binding to a RecyclerView, checkout the branch binding_to_a_adapter.
git checkout binding_to_a_adapter

Look in MainActivity and you will see:
```
    int index = (int) ((System.currentTimeMillis() / 1000) % Data.list.size());
    Data.list.set(index, Data.list.get(index) + ".");
```
in the timer class, this will change Data.list every second. 

Your mission Android developer, should you choose to accept it, is to bind the Data.list to the RecyclerView so that we dont have to do this in code in the future, but rather in the layout file itself.

As always, should you or anyone in your Android Team be caught or killed, the Secretary will disavow any knowledge of your actions. This repo will self-destruct in five seconds. Good luck.
