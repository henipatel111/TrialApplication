package com.example.heni.bannersonhomepage.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.heni.bannersonhomepage.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by heni on 8/7/17.
 */

public class MenuFragment extends Fragment {

   /* @BindView(R.id.rv_rlholder)
    RelativeLayout relativeLayout;
    @BindView(R.id.m_recyclerview)
    RecyclerView recyclerView;*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes
        View rootView = inflater.inflate(R.layout.menu_fragment, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
