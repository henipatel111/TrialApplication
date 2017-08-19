package com.example.heni.MyApp.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.heni.MyApp.R;

/**
 * Created by heni on 20/7/17.
 */

public class CommonSpaceViewHolder extends RecyclerView.ViewHolder {

    TextView textView_interSection_space;

    public CommonSpaceViewHolder(View itemView) {
        super(itemView);
        textView_interSection_space = (TextView) itemView.findViewById(R.id.textView_interSection_space);
    }

    public TextView getTextView_interSection_space() {
        return textView_interSection_space;
    }

    public void setTextView_interSection_space(TextView textView_interSection_space) {
        this.textView_interSection_space = textView_interSection_space;
    }


}
