package com.example.heni.bannersonhomepage.viewholders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.heni.bannersonhomepage.R;
import com.example.heni.bannersonhomepage.utilities.CommonRecyclerItem;

/**
 * Created by heni on 20/7/17.
 */

public class ScrollingViewAllViewHolder extends RecyclerView.ViewHolder {

    RelativeLayout relativeHolder;
    TextView textViewAction;

    public ScrollingViewAllViewHolder(View itemView) {
        super(itemView);
        bindViews(itemView);
    }

    private void bindViews(View rootView) {
        relativeHolder = (RelativeLayout) rootView.findViewById(R.id.relativeHolder);
        textViewAction = (TextView) rootView.findViewById(R.id.textViewAction);
    }

    public void bindIWItem(Context context, CommonRecyclerItem commonRecyclerItem) {
        //click
        relativeHolder.setOnClickListener((View.OnClickListener) commonRecyclerItem.getItem());

        //text
        if (commonRecyclerItem.getOptions() != null) {
            try {
                String text = (String) commonRecyclerItem.getOptions().get(0);
                if (text == null || text.length() == 0) {
                    textViewAction.setVisibility(View.GONE);
                } else {
                    textViewAction.setVisibility(View.VISIBLE);
                    textViewAction.setText(text);
                }
            } catch (Exception e) {
                textViewAction.setVisibility(View.GONE);
            }
        } else {
            textViewAction.setVisibility(View.GONE);
        }
    }
}
