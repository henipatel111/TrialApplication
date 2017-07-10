package com.example.heni.bannersonhomepage.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.heni.bannersonhomepage.fragments.BannerHomeFragment;
import com.example.heni.bannersonhomepage.fragments.MenuFragment;
import com.example.heni.bannersonhomepage.fragments.NotificationFragment;
import com.example.heni.bannersonhomepage.fragments.PostsFragment;

/**
 * Created by heni on 8/7/17.
 */

public class HomePagerAdapter extends FragmentStatePagerAdapter{
    int tabCount;

    public HomePagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                BannerHomeFragment bannerHomeFragment=new BannerHomeFragment();
                return bannerHomeFragment;
            case 1:
                PostsFragment postsFragment =new PostsFragment();
                return postsFragment;
            case 2:
                NotificationFragment notificationFragment=new NotificationFragment();
                return notificationFragment;
            case 3:
                MenuFragment menuFragment = new MenuFragment();
                return menuFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "HOME";
            case 1:
                return "POST";
            case 2:
                return "NOTIFICATION";
            case 3:
                return "MENU";
        }
        return "Unnamed";
    }
}
