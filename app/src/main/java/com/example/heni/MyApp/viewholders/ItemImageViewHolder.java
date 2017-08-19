package com.example.heni.MyApp.viewholders;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.heni.MyApp.R;
import com.example.heni.MyApp.activities.ImageFullScreenActivity;
import com.example.heni.MyApp.models.Post;
import com.example.heni.MyApp.utilities.CommonRecyclerItem;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by heni on 15/7/17.
 */

public class ItemImageViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.cardView_item)
    CardView cardView;
    @BindView(R.id.relative_details)
    RelativeLayout relativeDetails;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.img_retry)
    ImageView imgRetry;
    @BindView(R.id.imageView_image_thumb)
    ImageView imgThumb;
    @BindView(R.id.relative_thumb_overlay)
    RelativeLayout relative_thumbOverlay;
    @BindView(R.id.textView_itemTitle)
    TextView postTitle;
    @BindView(R.id.textView_itemDesc)
    TextView postDescription;

    Post post;

    public ItemImageViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bindItem(final Context context, CommonRecyclerItem commonRecyclerItem){
        post = (Post) commonRecyclerItem.getItem();

        postTitle.setText(post.getTitle());
        postDescription.setText(post.getDescription());
        imgRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadImage(context);
            }
        });
        loadImage(context);

        relative_thumbOverlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ImageFullScreenActivity.class);
                intent.putExtra("POST Data1", post.getImage());
                intent.putExtra("POST Data2",post.getTitle());
                intent.putExtra("POST Data3",post.getDescription());
                context.startActivity(intent);
            }
        });

    }

    private void loadImage(Context context) {
        //sets thumb
            relative_thumbOverlay.setVisibility(View.VISIBLE);
           // Picasso.with(context).load(post.getImage()).into(imgThumb);
            imgThumb.setImageResource(post.getImage());
        }

}
