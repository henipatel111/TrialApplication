package com.example.heni.bannersonhomepage.fragments;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.heni.bannersonhomepage.R;
import com.example.heni.bannersonhomepage.models.Banner;
import com.google.gson.Gson;
import com.google.gson.JsonParser;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by heni on 8/7/17.
 */

public class BannerFragment extends Fragment {

    /**
     * ButterKnife Code
     */
    @BindView(R.id.rl_holder)
    RelativeLayout rlHolder;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    @BindView(R.id.ll_content_holder)
    LinearLayout llContentHolder;
    /* @BindView(R.id.img_reference)
     ImageView imgReference;
     @BindView(R.id.banner_link_image)
     ImageView bannerLinkImage;*/
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.textView1)
    TextView textView1;
    @BindView(R.id.textView2)
    TextView textView2;

    /**
     * ButterKnife Code end
     */
    Banner banner;
    public static final String ARG_BANNER = "ARG_BANNER";

    public static final BannerFragment newInstance(Banner banner) {
        BannerFragment fragment = new BannerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_BANNER, new Gson().toJson(banner));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            banner = new Gson().fromJson(new JsonParser().parse(getArguments().getString(ARG_BANNER)), Banner.class);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.banner_fragment, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, getView());
        progressBar.setVisibility(View.GONE);
        textView.setText(banner.getTitle());
        textView1.setText(banner.getLinkUrl());
        textView2.setText(banner.getDescription());
    }
}
