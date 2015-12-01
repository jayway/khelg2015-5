package se.jayway.databinding;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by carl on 12/1/15.
 */

public class MyAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    private List<String> mWeekDayList;

    public MyAdapter(Context context, List<String> weekDays) {
        this.mWeekDayList = weekDays;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.my_text_layout, null);

        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {
        String weekDay = mWeekDayList.get(i);
        customViewHolder.mTextView.setText(Html.fromHtml(weekDay));
    }

    @Override
    public int getItemCount() {
        return (null != mWeekDayList ? mWeekDayList.size() : 0);
    }
}