package se.jayway.databinding;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "RecyclerViewExample";
    private List<WeekDay> feedsList;
    private RecyclerView mRecyclerView;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        // Initialize recycler view
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        feedsList = new ArrayList<>();
        for (String s : Data.map.values()) {
            WeekDay weekDay = new WeekDay();
            weekDay.setTitle(s);
            feedsList.add(weekDay);
        }

        adapter = new MyAdapter(this, feedsList);
        mRecyclerView.setAdapter(adapter);

        final Data data = new Data();

        Timer myTimer = new Timer();
        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        data.setTime(System.currentTimeMillis());
                    }
                });
            }
        }, 0, 1000);

    }
}
