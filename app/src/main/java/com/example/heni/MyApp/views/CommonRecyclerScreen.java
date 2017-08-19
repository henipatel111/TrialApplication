package com.example.heni.MyApp.views;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.heni.MyApp.R;
import com.example.heni.MyApp.utilities.CommonRecyclerItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by heni on 8/7/17.
 */

public class CommonRecyclerScreen {

    private static final String TAG = "CRS";

    public List<CommonRecyclerItem> recyclerItems;
    RelativeLayout relative_recyclerHolder;
    SwipeRefreshLayout swipeRefreshLayout;
    Context context;
    private android.support.v7.widget.RecyclerView recyclerView;
    private ImageView imageView_retryButton;
    private LinearLayout llProgressHolder;

    private void bindViews(View rootView) {
        recyclerView = (android.support.v7.widget.RecyclerView) rootView.findViewById(R.id.recyclerView);
        imageView_retryButton = (ImageView) rootView.findViewById(R.id.imageview_retry);
        llProgressHolder = (LinearLayout) rootView.findViewById(R.id.ll_iw_progress_holder);
        relative_recyclerHolder = (RelativeLayout) rootView.findViewById(R.id.common_recycler_screen);
        swipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipeRefreshLayout);
    }

    public CommonRecyclerScreen(Context context, View view) {
        this.context = context;
        this.recyclerItems = new ArrayList<>();
        bindViews(view);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setColorSchemeResources(R.color.google_blue_50, R.color.google_blue_100, R.color.google_blue_200);
        }
    }

    public static CommonRecyclerScreen setupWithFragment(Fragment fragment) {
        return new CommonRecyclerScreen(fragment.getContext(), fragment.getView());
    }

    public void setSwipeRefreshing(boolean b) {
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setRefreshing(b);
        }
    }

    public void setSwipeListener(SwipeRefreshLayout.OnRefreshListener swipeRefreshListener) {
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setOnRefreshListener(swipeRefreshListener);
        }
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public List<CommonRecyclerItem> getRecyclerItems() {
        return recyclerItems;
    }


}
