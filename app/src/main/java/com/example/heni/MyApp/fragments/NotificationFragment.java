package com.example.heni.MyApp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.heni.MyApp.R;
import com.example.heni.MyApp.adapters.NotificationAdapter;
import com.example.heni.MyApp.models.MyNotification;
import com.example.heni.MyApp.utilities.CommonRecyclerItem;
import com.example.heni.MyApp.utilities.MyHelper;
import com.example.heni.MyApp.views.CommonRecyclerScreen;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by heni on 8/7/17.
 */

public class NotificationFragment extends Fragment {

    CommonRecyclerScreen crs;
    List<MyNotification> myNotifications;
    NotificationAdapter adapter;
    public NotificationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notification, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fetchData();
    }

    private void fetchData(){
        myNotifications = new ArrayList<>();
        crs = CommonRecyclerScreen.setupWithFragment(this);
        adapter = new NotificationAdapter(getContext(), crs.getRecyclerItems());
        crs.setSwipeListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                fetchData();
            }
        });

        crs.setSwipeListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                fetchData();
            }
        });
        loadNextPage();
    }

    private void loadNextPage(){
        if(MyHelper.isDataAdapterOn(getContext())){
            myNotifications = getDummyNotifications();
            if(myNotifications != null){
                crs.recyclerItems.addAll(CommonRecyclerItem.generate(CommonRecyclerItem.ItemType.NOTIFIACTION, myNotifications));
                adapter.notifyItemRangeInserted(crs.recyclerItems.size() - myNotifications.size(), myNotifications.size());
            }
        }
    }

    public List<MyNotification> getDummyNotifications(){

        List<MyNotification> notificationList = new ArrayList<>();

        MyNotification notification1 = new MyNotification("Post 1", "This is my First Notification.","10th september 2017");
        MyNotification notification2 = new MyNotification("Post 2", "This is my Second Post. :)","11th september 2017");
        MyNotification notification3 = new MyNotification("Post 3", "This is my third Post. :)","12th september 2017");
        MyNotification notification4 = new MyNotification("Post 4", "This is my fourth Post. :)","13th september 2017");
        MyNotification notification5 = new MyNotification("Post 5", "This is my fifth Post. :)","14th september 2017");
        notificationList.add(notification1);
        notificationList.add(notification2);
        notificationList.add(notification3);
        notificationList.add(notification4);
        notificationList.add(notification5);

        return notificationList;
    }




}
