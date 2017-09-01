package com.example.heni.MyApp.viewholders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.heni.MyApp.R;
import com.example.heni.MyApp.models.Post;
import com.example.heni.MyApp.utilities.CommonRecyclerItem;
import com.example.heni.MyApp.utilities.MyHelper;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by heni on 19/8/17.
 */

public class ItemVideoViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.relative_details)
    RelativeLayout relativeDetails;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.imageView_image_thumb)
    ImageView imageViewThumb;
    @BindView(R.id.relative_video_thumb_overlay)
    RelativeLayout relativeVideoThumbOverlay;
    @BindView(R.id.textView_itemTitle)
    TextView postTitle;
    @BindView(R.id.textView_itemDesc)
    TextView postDescription;
    Post post;

    public ItemVideoViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(itemView);
    }

    public void bindItem(final Context context, CommonRecyclerItem commonRecyclerItem){
        post = (Post) commonRecyclerItem.getItem();

        postTitle.setText(post.getTitle());
        Toast.makeText(context, post.getTitle(), Toast.LENGTH_SHORT).show();
        postDescription.setText(post.getDescription());

        //sets thumb
        if(post.getVideoURL() == null ){
            progressBar.setVisibility(View.GONE);
            relativeVideoThumbOverlay.setVisibility(View.GONE);
        }else {
           // Picasso.with(context).load(post.getImage()).into(imageViewThumb);
            imageViewThumb.setImageResource(post.getImage());
        }

        relativeVideoThumbOverlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playVideo(context);
            }
        });

    }

    private void playVideo(Context context){
        MyHelper.playVideoForYoutubeID(context,post.getYoutubeVideoId());
    }
}
