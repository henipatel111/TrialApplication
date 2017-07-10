package com.example.heni.bannersonhomepage.viewholders;

import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.heni.bannersonhomepage.R;
import com.example.heni.bannersonhomepage.fragments.BannerFragment;
import com.example.heni.bannersonhomepage.fragments.MyFragment;
import com.example.heni.bannersonhomepage.models.Banner;
import com.example.heni.bannersonhomepage.utilities.CommonRecyclerItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by heni on 8/7/17.
 */

public class BannerViewHolder extends RecyclerView.ViewHolder {

    /**ButterKnife Code
     *
     */

    @BindView(R.id.ll_holder)
    LinearLayout llHolder;
    @BindView(R.id.banner_view_pager)
    ViewPager viewPager;
    @BindView(R.id.img_reference)
    ImageView imgReference;
    @BindView(R.id.circle_indicator)
    me.relex.circleindicator.CircleIndicator circleIndicator;
    CountDownTimer countDownTimer;
    List<Banner> bannerList;
    AppCompatActivity appCompatActivity;
    PagerAdapter pagerAdapter;

    /**Butterknife Code ends
     *
     */

    public BannerViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);

        countDownTimer = new CountDownTimer(10000, 10000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                autoScrollNextPage();
            }
        };
    }

    private void autoScrollNextPage() {
        if (pagerAdapter != null && viewPager != null) {
            if (viewPager.getCurrentItem() == bannerList.size() - 1) {
                viewPager.setCurrentItem(0);
            } else {
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            }
        }
        countDownTimer.start();
    }

    public void bindItem(CommonRecyclerItem commonRecyclerItem){
        if(pagerAdapter == null){
            bannerList = (List<Banner>) commonRecyclerItem.getItem();
            appCompatActivity = (AppCompatActivity) commonRecyclerItem.getOptions().get(0);
            pagerAdapter = new PagerAdapter(appCompatActivity.getSupportFragmentManager());
            viewPager.setAdapter(pagerAdapter);
            viewPager.setOffscreenPageLimit(bannerList.size());
            circleIndicator.setViewPager(viewPager);

            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    countDownTimer.cancel();
                    countDownTimer.start();
                }

                @Override
                public void onPageSelected(int position) {
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
            countDownTimer.start();

        }
    }

    public class PagerAdapter extends FragmentStatePagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);


        }
        /*@Override
        public Fragment getItem(int position) {
            switch (bannerList.get(position).getTitle()) {
                case "weblink1":
                    return MyFragment.newInstance(bannerList.get(position));
                case "lesson1":
                    return MyFragment.newInstance(bannerList.get(position));
                case "course1":
                    return MyFragment.newInstance(bannerList.get(position));
            }
            return MyFragment.newInstance(bannerList.get(position));
        }*/

        @Override
        public Fragment getItem(int position) {
            switch (bannerList.get(position).getTitle()) {
                case "weblink1":
                    return BannerFragment.newInstance(bannerList.get(position));
                case "lesson1":
                    return BannerFragment.newInstance(bannerList.get(position));
                case "course1":
                    return BannerFragment.newInstance(bannerList.get(position));
            }
            return BannerFragment.newInstance(bannerList.get(position));
        }
        @Override
        public int getCount() {
            return bannerList.size();
        }
    }

}
