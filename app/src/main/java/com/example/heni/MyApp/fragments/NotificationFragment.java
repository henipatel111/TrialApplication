package com.example.heni.MyApp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.heni.MyApp.R;
import com.example.heni.MyApp.adapters.NotificationAdapter;
import com.example.heni.MyApp.models.MyNotification;
import com.example.heni.MyApp.utilities.CommonRecyclerItem;
import com.example.heni.MyApp.utilities.FBInstanceIdService;
import com.example.heni.MyApp.utilities.FBMessagingService;
import com.example.heni.MyApp.utilities.MyHelper;
import com.example.heni.MyApp.views.CommonRecyclerScreen;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by heni on 8/7/17.
 */

public class NotificationFragment extends Fragment {

    CommonRecyclerScreen crs;
    List<MyNotification> myNotifications;
    NotificationAdapter adapter;
    String deviceToken;

    @BindView(R.id.r_mainHolder)
    RelativeLayout rMainHolder;
    @BindView(R.id.crs_holder)
    RelativeLayout crsHolder;

    public NotificationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.notification_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(view);
        deviceToken = FBInstanceIdService.getDeviceToken();
        resetScreen();
    }

    private void resetScreen(){
        crs = CommonRecyclerScreen.setupWithFragment(this);
        crs.setSwipeListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                resetScreen();
            }
        });
        fetchData();
    }

    private void fetchData(){
        myNotifications = new ArrayList<>();
        adapter = new NotificationAdapter(getContext(), crs.getRecyclerItems());
        crs.getRecyclerView().setLayoutManager(new LinearLayoutManager(getContext()));
        crs.getRecyclerView().setAdapter(adapter);
        loadNextPage();
    }

    private void loadNextPage(){
        if(MyHelper.isDataAdapterOn(getContext())){
            myNotifications = getDummyNotifications();
            if(myNotifications != null){
                crs.recyclerItems.addAll(CommonRecyclerItem.generate(CommonRecyclerItem.ItemType.NOTIFIACTION, myNotifications));
                //adapter.notifyItemRangeInserted(crs.recyclerItems.size() - myNotifications.size(), myNotifications.size());
                adapter.notifyDataSetChanged();
                /*adapter.setRecyclerItems(crs.getRecyclerItems());
                adapter.notifyDataSetChanged();*/
            }
        }
        crs.setSwipeRefreshing(false);
    }

    public List<MyNotification> getDummyNotifications(){

        List<MyNotification> notificationList = new ArrayList<>();

        MyNotification notification1 = new MyNotification("Notification 1", "This is my First Notification.","10th september 2017",R.drawable.demo_cube);
        MyNotification notification2 = new MyNotification("Notification 2", "This is my Second Notification.","11th september 2017",R.drawable.demo_cube);
        MyNotification notification3 = new MyNotification("Notification 3", "This is my third Notification.","12th september 2017",R.drawable.demo_cube);
        MyNotification notification4 = new MyNotification("Notification 4", "This is my fourth Notification.","13th september 2017",R.drawable.demo_cube);
        MyNotification notification5 = new MyNotification("Notification 5", "This is my fifth Notification.","14th september 2017",R.drawable.demo_cube);
        notificationList.add(notification1);
        notificationList.add(notification2);
        notificationList.add(notification3);
        notificationList.add(notification4);
        notificationList.add(notification5);

        return notificationList;
    }

}
