package com.example.heni.MyApp.viewholders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.heni.MyApp.R;
import com.example.heni.MyApp.utilities.CommonCardTitleOption;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by heni on 19/7/17.
 */

public class CommonCardTitleViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.cardTitleHolder)
    RelativeLayout cardTitleHolder;
    @BindView(R.id.cardHeaderIcon)
    ImageView cardHeaderIcon;
    @BindView(R.id.textViewCardTitle)
    TextView textViewCardTitle;
    @BindView(R.id.cardActionText)
    TextView cardActionText;

    public CommonCardTitleViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void bind(Context context, CommonCardTitleOption cardTitleOption) {
        //res drawable
        try {
            cardHeaderIcon.setImageDrawable(context.getResources().getDrawable(cardTitleOption.getDrawableResID()));
        } catch (Exception e) {
            //if anything goes wrong, hide icon
            cardHeaderIcon.setVisibility(View.GONE);
        }

        //title
        if (cardTitleOption.getTitle() != null) {
            textViewCardTitle.setText(cardTitleOption.getTitle());
        }

        //action
        if (cardTitleOption.getActionClickListener() != null && cardTitleOption.getActionText() != null) {
            cardActionText.setText(cardTitleOption.getActionText());
            cardActionText.setOnClickListener(cardTitleOption.getActionClickListener());
            cardTitleHolder.setOnClickListener(cardTitleOption.getActionClickListener());
        } else {
            cardActionText.setVisibility(View.GONE);
            cardTitleHolder.setClickable(false);
        }
    }
}
