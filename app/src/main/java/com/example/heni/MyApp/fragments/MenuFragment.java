package com.example.heni.MyApp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.heni.MyApp.R;
import com.example.heni.MyApp.activities.VideoPlayerActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by heni on 8/7/17.
 */

public class MenuFragment extends Fragment {

    @BindView(R.id.rv_rlholder)
    RelativeLayout relativeLayout;
    @BindView(R.id.video_button)
    Button videoButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes
        View rootView = inflater.inflate(R.layout.menu_fragment, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setScreen();
    }

    private void setScreen(){
        videoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),VideoPlayerActivity.class);
                getContext().startActivity(intent);
            }
        });
    }
}
