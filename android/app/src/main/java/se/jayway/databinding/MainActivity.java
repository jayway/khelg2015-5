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
    private List<WeekDay> mFeedsList;
    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        // Initialize recycler view
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mFeedsList = new ArrayList<>();

        for (String s : Data.map.values()) {
            WeekDay weekDay = new WeekDay();
            weekDay.setTitle(s);
            mFeedsList.add(weekDay);
        }

        mAdapter = new MyAdapter(this, mFeedsList);
        mRecyclerView.setAdapter(mAdapter);

        final Data data = new Data();

        Timer myTimer = new Timer();
        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
            }
        }, 0, 1000);

    }
}
