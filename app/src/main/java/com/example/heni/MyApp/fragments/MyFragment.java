package com.example.heni.MyApp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.heni.MyApp.R;
import com.example.heni.MyApp.models.Banner;
import com.google.gson.Gson;
import com.google.gson.JsonParser;

/**
 * Created by heni on 10/7/17.
 */

public class MyFragment extends Fragment {
    private Banner banner;
    TextView textView;
    TextView textView1;
    TextView textView2;

    private void bindViews(View rootView){
        textView = (TextView) rootView.findViewById(R.id.textView);
        textView1 = (TextView) rootView.findViewById(R.id.textView1);
        textView2 = (TextView) rootView.findViewById(R.id.textView2);
    }

    public static final String ARG_BANNER = "ARG_BANNER";
    public static final MyFragment newInstance(Banner banner)
    {
        MyFragment fragment = new MyFragment();
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
        View rootView = inflater.inflate(R.layout.my_fragment, container, false);
        bindViews(rootView);
        textView.setText(banner.getTitle());
        textView1.setText(banner.getLinkUrl());
        textView2.setText(banner.getDescription());
        return rootView;
    }


}

