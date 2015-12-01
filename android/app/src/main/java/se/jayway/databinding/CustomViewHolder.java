package se.jayway.databinding;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by carl on 12/1/15.
 */
public class CustomViewHolder extends RecyclerView.ViewHolder {

    protected TextView mTextView;

    public CustomViewHolder(View view) {
        super(view);
        this.mTextView = (TextView) view.findViewById(R.id.textView);
    }
}
