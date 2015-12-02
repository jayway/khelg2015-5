package se.jayway.databinding;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        // Initialize recycler view
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new MyAdapter(Data.list);
        mRecyclerView.setAdapter(mAdapter);

        final Handler h;

        h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                int index = (int) ((System.currentTimeMillis() / 1000) % Data.list.size());
                MyModel myModel = Data.list.get(index);
                myModel.setData(myModel.getData() + ".");
                h.postDelayed(this, 1000);
            }
        }, 1000);

    }
}
