package com.example.heni.bannersonhomepage.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.example.heni.bannersonhomepage.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by heni on 19/7/17.
 */

public class ViewAllListActivity extends AppCompatActivity {

    public static String EXTRA_SCREEN_TYPE = "screenType";
    public static String EXTRA_LANDING_TAB = "landingTabType";
    ScreenType currentScreenType;

    @BindView(R.id.relativeCustomAppbar)
    RelativeLayout relativeCustomAppbar;
    @BindView(R.id.relative_header_search)
    RelativeLayout relativeHeaderSearch;
    @BindView(R.id.imgSrc)
    ImageView imgSrc;
    @BindView(R.id.editText_search)
    EditText editTextSearch;
    @BindView(R.id.relative_optionHolder)
    RelativeLayout relativeOptionHolder;
    @BindView(R.id.image_option_go)
    ImageView imageOptionGo;
    @BindView(R.id.image_option_cancel)
    ImageView imageOptionCancel;
    @BindView(R.id.viewSearchOverlay)
    View searchOverlay;
    @BindView(R.id.search_progress)
    ProgressBar searchProgress;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_list);
        ButterKnife.bind(this);
    }

    public static void openRecentLessons(Context context) {
        Intent intent = new Intent(context, ViewAllListActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(ViewAllListActivity.EXTRA_SCREEN_TYPE, ScreenType.USER_RECENT_LESSONS_COURSES.getValue());
        intent.putExtra(ViewAllListActivity.EXTRA_LANDING_TAB, TabType.USER_RECENT_LESSONS.getId());
       /* intent.putExtra(User.EXTRA_USER_ID, userID);
        intent.putExtra(User.EXTRA_FULL_NAME, userFullName);*/
        context.startActivity(intent);
    }

    public enum ScreenType {
        USER_RECENT_COURSES(1),
        USER_RECENT_LESSONS_COURSES(2);

        private final int value;

        ScreenType(int value) {
            this.value = value;
        }

        public static ScreenType getTypeForID(int id) {
            switch (id) {
                case 1:
                    return USER_RECENT_COURSES;
                case 2:
                    return USER_RECENT_LESSONS_COURSES;
            }
            return USER_RECENT_COURSES;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum TabType {
        USER_RECENT_LESSONS(1, "Lessons");


        private final String title;
        private final int id;

        TabType(int id, String title) {
            this.id = id;
            this.title = title;
        }

        public static TabType getTabTypeForID(int id) {
            switch (id) {
                case 1:
                    return USER_RECENT_LESSONS;
            }
            return USER_RECENT_LESSONS;
        }

        public int getId() {
            return id;
        }

        public String getTitle() {
            return this.title;
        }

    }
    }
