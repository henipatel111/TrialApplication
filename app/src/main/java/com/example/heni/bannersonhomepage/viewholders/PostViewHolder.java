package com.example.heni.bannersonhomepage.viewholders;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.heni.bannersonhomepage.R;
import com.example.heni.bannersonhomepage.models.Post;
import com.example.heni.bannersonhomepage.utilities.CommonRecyclerItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by heni on 12/7/17.
 */

public class PostViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.post_cardview)
    CardView cardView;
    @BindView(R.id.rl_main_post_holder)
    RelativeLayout rlMainPostHolder;
    @BindView(R.id.post_description)
    TextView postText;
    @BindView(R.id.post_image)
    ImageView postImage;
    Post post;

    public PostViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);

    }

    public void bindItem(CommonRecyclerItem commonRecyclerItem){
        post = (Post) commonRecyclerItem.getItem();
        postText.setText(post.getDescription());
    }
}
