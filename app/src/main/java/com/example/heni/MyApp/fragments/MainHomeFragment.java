package com.example.heni.MyApp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.heni.MyApp.R;
import com.example.heni.MyApp.adapters.MainHomeAdapter;
import com.example.heni.MyApp.models.Banner;
import com.example.heni.MyApp.models.Lesson;
import com.example.heni.MyApp.utilities.CommonRecyclerItem;
import com.example.heni.MyApp.views.CommonRecyclerScreen;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.heni.MyApp.utilities.CommonRecyclerItem.ItemType.BANNER_PAGER;

/**
 * Created by heni on 20/7/17.
 */

public class MainHomeFragment extends Fragment {

    /**
     * ButterKnife code starts
     **/
    @BindView(R.id.r_mainHolder)
    RelativeLayout rMainHolder;
    @BindView(R.id.crs_holder)
    RelativeLayout crsHolder;
    MainHomeAdapter mainHomeAdapter;
    CommonRecyclerItem crBannerPager, lessonCard;
    List<Banner> banners;
    List<Lesson> lessons;
    boolean isBannerLoaded= false, isLessonLoaded = false;
    CommonRecyclerScreen crs;

    String TAG = "BannerHomeFragment";
    /**
     * ButterKnife code end
     **/

    public MainHomeFragment(){
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
        crs = new CommonRecyclerScreen(this.getContext(),view);
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
        reloadHomeData();
    }


    private void reloadHomeData(){
        //reset flags
        isBannerLoaded = false;
        isLessonLoaded = false;

        //reset adapter
        mainHomeAdapter = new MainHomeAdapter(getContext(),crs.getRecyclerItems());
        crs.getRecyclerView().setLayoutManager(new LinearLayoutManager(getContext()));

        loadNextCard();
    }


    private void loadNextCard(){
        if (!isBannerLoaded) {
            loadBannerPagerCard();
        }else if(!isLessonLoaded){
            loadLessonCard();
        }
    }

    private void loadBannerPagerCard(){
        banners = getDummyBanners();
        crs.getRecyclerView().setAdapter(mainHomeAdapter);

        crBannerPager = new CommonRecyclerItem(BANNER_PAGER,banners,MainHomeFragment.this.getActivity());
        crs.getRecyclerItems().add(crBannerPager);
        mainHomeAdapter.setRecyclerItems(crs.getRecyclerItems());
        mainHomeAdapter.notifyItemInserted(crs.getRecyclerItems().size());
        isBannerLoaded = true;
        loadNextCard();
        crs.setSwipeRefreshing(false);
    }

    public void loadLessonCard(){
        lessons = getDummyLessons();
        crs.getRecyclerView().setAdapter(mainHomeAdapter);

        lessonCard = Lesson.getRecentLessonIWItem(getContext(),"RECENT LESSON",lessons);
        crs.getRecyclerItems().add(lessonCard);
        mainHomeAdapter.setRecyclerItems(crs.getRecyclerItems());
        mainHomeAdapter.notifyItemInserted(crs.getRecyclerItems().size());
        isLessonLoaded = true;
        crs.setSwipeRefreshing(false);
        loadNextCard();
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

    private List<Lesson> getDummyLessons(){
        List<Lesson> dummyLessonList = new ArrayList<>();
        Lesson lesson1 = new Lesson(1,"Lesson1", "First Lesson","This is about Java",R.drawable.shinchan1,"12","S.K",5,true);
        Lesson lesson2 = new Lesson(2,"Lesson2","Second Lesson","This is about Android",R.drawable.shinchan1,"12","S.K",5,true);
        Lesson lesson3 = new Lesson(3,"Lesson3", "Third Lesson","This is about .Net",R.drawable.shinchan1,"12","S.K",5,true);
        Lesson lesson4 = new Lesson(4,"Lesson4","Fourth Lesson","This is about Ruby On Rails",R.drawable.shinchan1,"12","S.K",5,true);
        Lesson lesson5 = new Lesson(5, "Lesson5","Fifth Lesson","This about Python",R.drawable.shinchan1,"12","S.K",5,true);

        dummyLessonList.add(lesson1);
        dummyLessonList.add(lesson2);
        dummyLessonList.add(lesson3);
        dummyLessonList.add(lesson4);
        dummyLessonList.add(lesson5);

        return dummyLessonList;
    }

}
