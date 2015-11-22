package se.kjellstrand.k_dag52015databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import se.kjellstrand.k_dag52015databinding.databinding.MainActivityBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        MainActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.main_activity);
        Data data = new Data();
        binding.setData(data);
    }
}
