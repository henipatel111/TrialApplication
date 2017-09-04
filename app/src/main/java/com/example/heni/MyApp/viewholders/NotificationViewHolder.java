package com.example.heni.MyApp.viewholders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.heni.MyApp.R;
import com.example.heni.MyApp.models.MyNotification;
import com.example.heni.MyApp.utilities.CommonRecyclerItem;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by heni on 2/9/17.
 */

public class NotificationViewHolder extends RecyclerView.ViewHolder {

    public NotificationViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    /**
     * ButterKnife Code
     **/
    @BindView(R.id.rl_top)
    RelativeLayout rlTop;
    @BindView(R.id.ll_right)
    LinearLayout llRight;
    @BindView(R.id.img_thumb)
    ImageView imgThumb;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_date)
    TextView tvDate;
    @BindView(R.id.tv_description)
    TextView tvDescription;
    /**
     * ButterKnife Code
     **/
    MyNotification notification;

    public void bindCRItem(final Context context, CommonRecyclerItem commonRecyclerItem) {
        notification = (MyNotification) commonRecyclerItem.getItem();

        //title
        tvTitle.setText(notification.getTitle());

        //desc
        tvDescription.setText(notification.getDescription());

        //thumb
        Picasso.with(context).load(notification.getImageUrl()).into(imgThumb);

        //location
        tvDate.setText(notification.getDatetime());
    }
}
