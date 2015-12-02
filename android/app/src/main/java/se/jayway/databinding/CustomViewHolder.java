package se.jayway.databinding;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

/**
 * Created by carl on 12/1/15.
 */
public class CustomViewHolder extends RecyclerView.ViewHolder {

  private ViewDataBinding mViewDataBinding;

    public CustomViewHolder( ViewDataBinding viewDataBinding) {
        super(viewDataBinding.getRoot());

        mViewDataBinding = viewDataBinding;
        mViewDataBinding.executePendingBindings();
    }

    public ViewDataBinding getViewDataBinding() {
        return mViewDataBinding;
    }
}
