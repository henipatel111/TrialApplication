package com.example.heni.bannersonhomepage.views;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.heni.bannersonhomepage.R;
import com.example.heni.bannersonhomepage.utilities.CommonRecyclerItem;
import com.example.heni.bannersonhomepage.utilities.MyHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.example.heni.bannersonhomepage.utilities.CommonRecyclerItem.ItemType.LOADING;

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

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public List<CommonRecyclerItem> getRecyclerItems() {
        return recyclerItems;
    }


}
