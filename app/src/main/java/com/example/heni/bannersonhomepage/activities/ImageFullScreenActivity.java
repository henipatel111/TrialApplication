package com.example.heni.bannersonhomepage.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.heni.bannersonhomepage.R;
import com.github.chrisbanes.photoview.PhotoView;

/**
 * Created by heni on 15/7/17.
 */

public class ImageFullScreenActivity extends AppCompatActivity{

    PhotoView photoView;
    ImageView thumbPreview;
    RelativeLayout relative_fullIMageHolder;
    RelativeLayout relative_overlay;
    RelativeLayout relative_header;
    TextView textView_title, textViewDesc;
    ProgressBar progressbar;
    boolean lockOnZoom = false;
    View viewWhiteBG;
    Animation animFadeInOverlay, animFadeOutOverlay, animFadeInWhiteBG, animfadeOutWhiteBG, animSlideInFromBottom, animSlideInFromTop, animSlideOutFromBottom, animSlideOutFromTop, floatUp, floatDown;//float up and float down are for comment holder

    private void bindViews(){
        thumbPreview = (ImageView) findViewById(R.id.thumbPreview);
        photoView = (PhotoView) findViewById(R.id.photo_view);
        relative_fullIMageHolder = (RelativeLayout) findViewById(R.id.relative_fullimage_holder);
        relative_overlay = (RelativeLayout) findViewById(R.id.relative_overlay);
        relative_header = (RelativeLayout) findViewById(R.id.relative_header);
        textView_title = (TextView) findViewById(R.id.textView_title);
        textViewDesc = (TextView) findViewById(R.id.textView_desc);
        progressbar = (ProgressBar) findViewById(R.id.progressbar);
        viewWhiteBG = findViewById(R.id.viewWhiteBG);

    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_full_screen_image);
        bindViews();
        loadAnimations();
        bindItem();
    }
    private void loadAnimations() {
        animSlideInFromTop = AnimationUtils.loadAnimation(this, R.anim.slide_in_top);
        animSlideInFromBottom = AnimationUtils.loadAnimation(this, R.anim.slide_in_bottom);
        animSlideOutFromBottom = AnimationUtils.loadAnimation(this, R.anim.slide_out_bottom);
        animSlideOutFromTop = AnimationUtils.loadAnimation(this, R.anim.slide_out_top);
        animFadeInOverlay = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        animFadeInOverlay.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                //relative_overlay.setVisibility(View.VISIBLE);
                lockOnZoom = true;
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                relative_overlay.setVisibility(View.VISIBLE);
                lockOnZoom = false;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        animFadeOutOverlay = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        animFadeOutOverlay.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                lockOnZoom = true;
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                relative_overlay.setVisibility(View.GONE);
                lockOnZoom = false;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        animFadeInWhiteBG = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        animFadeInWhiteBG.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                //relative_overlay.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                viewWhiteBG.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        animfadeOutWhiteBG = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        animfadeOutWhiteBG.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                viewWhiteBG.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }


    private void loadImage() {
        int postImgId = this.getIntent().getIntExtra("POST Data1",1);
        String  postTitle = this.getIntent().getStringExtra("POST Data2");
        String postDescription = this.getIntent().getStringExtra("POST Data3");
        textView_title.setText(postTitle);
        textViewDesc.setText(postDescription);
        photoView.setImageResource(postImgId);
        progressbar.setVisibility(View.GONE);
    }

    private void bindItem(){
        loadImage();
    }


}
