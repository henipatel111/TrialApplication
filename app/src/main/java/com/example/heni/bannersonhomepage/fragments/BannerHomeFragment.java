package com.example.heni.bannersonhomepage.fragments;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.heni.bannersonhomepage.R;
import com.example.heni.bannersonhomepage.adapters.BannerAdapter;
import com.example.heni.bannersonhomepage.models.Banner;
import com.example.heni.bannersonhomepage.utilities.CommonRecyclerItem;
import com.example.heni.bannersonhomepage.utilities.MyHelper;
import com.example.heni.bannersonhomepage.views.CommonRecyclerScreen;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.heni.bannersonhomepage.utilities.CommonRecyclerItem.ItemType.BANNER_PAGER;


/**
 * Created by heni on 8/7/17.
 */

public class BannerHomeFragment extends Fragment {

    /**
     * ButterKnife code starts
     **/
     @BindView(R.id.r_mainHolder)
     RelativeLayout rMainHolder;
     @BindView(R.id.crs_holder)
     RelativeLayout crsHolder;

     CommonRecyclerItem crBannerPager;
     List<Banner> banners;
     boolean bannerLoaded= false;
     BannerAdapter bannerAdapter;
     CommonRecyclerScreen crs;

    String TAG = "BannerHomeFragment";
    /**
     * ButterKnife code end
     **/

    public BannerHomeFragment(){
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.banner_home_fragment, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        crs = CommonRecyclerScreen.setupWithActivity(getActivity());
        resetScreen();
    }

    private void resetScreen(){
        reloadHomeData();
    }

    private void reloadHomeData(){
        //reset flags
        bannerLoaded = false;
        loadNextCard();
    }


    private void loadNextCard(){
        if (!bannerLoaded) {
            loadBannerPagerCard();
        }
    }

    private void loadBannerPagerCard(){
        banners = getDummyBanners();
        bannerAdapter = new BannerAdapter(getContext(),crs.getRecyclerItems());
        crs.getRecyclerView().setLayoutManager(new LinearLayoutManager(getContext()));
        crs.getRecyclerView().setAdapter(bannerAdapter);

        crBannerPager = new CommonRecyclerItem(BANNER_PAGER,banners,BannerHomeFragment.this.getActivity());
        crs.getRecyclerItems().add(crBannerPager);
        bannerAdapter.setRecyclerItems(crs.getRecyclerItems());
        bannerAdapter.notifyItemInserted(crs.getRecyclerItems().size());

        bannerLoaded = true;
    }

    private List<Banner> getDummyBanners() {
        List<Banner> dummyBanners = new ArrayList<>();
        Banner weblink1 = new Banner("weblink1", "http://henipatel.com","1st Banner weblink");
        Banner lesson1 = new Banner("lesson1", "http://henipatel.com","2nd Banner Lesson");
        Banner course1 = new Banner("course1", "http://henipatel.com","3rd Banner course");
        Banner weblink2 = new Banner("weblink2", "http://henipatel.com","3st Banner weblink");
        Banner lesson2 = new Banner("lesson2", "http://henipatel.com","3nd Banner lesson");
        Banner course2 = new Banner("course2", "http://henipatel.com","3rd Banner course");
        dummyBanners.add(weblink1);
        dummyBanners.add(lesson1);
        dummyBanners.add(course1);
        dummyBanners.add(weblink2);
        dummyBanners.add(lesson2);
        dummyBanners.add(course2);
        return dummyBanners;
    }


}
