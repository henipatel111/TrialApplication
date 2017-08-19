package com.example.heni.MyApp.viewholders;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.heni.MyApp.R;
import com.example.heni.MyApp.adapters.HorizontalScrollerAdapter;
import com.example.heni.MyApp.models.Lesson;
import com.example.heni.MyApp.utilities.CommonCardTitleOption;
import com.example.heni.MyApp.utilities.CommonRecyclerItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by heni on 19/7/17.
 */

public class LessonScrollerViewHolder extends RecyclerView.ViewHolder {

    Context context;
    @BindView(R.id.cardTitleHolder)
    RelativeLayout cardTitleHolder;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    HorizontalScrollerAdapter scrollerAdapter;

    CommonCardTitleViewHolder cardTitleViewHolder;
    List<Lesson> currentRecentLessonList = null;

    public LessonScrollerViewHolder(View itemView) {
      super(itemView);
        ButterKnife.bind(this,itemView);
        cardTitleViewHolder = new CommonCardTitleViewHolder(cardTitleHolder);
    }

    public static CommonRecyclerItem generateIWRecyclerView(Context context, List<?> lessonsOrCourses, int drawableResID, String title, String actionText, View.OnClickListener actionClickListener) {
       CommonRecyclerItem commonRecyclerItem= new CommonRecyclerItem(CommonRecyclerItem.ItemType.LESSONS_COURSES_SCROLLER, getScrollingIWItems(context, lessonsOrCourses, actionText, actionClickListener));
        CommonCardTitleOption commonCardTitleOption = new CommonCardTitleOption(drawableResID, title, actionText, actionClickListener);
        List<Object> options = new ArrayList<>();
        options.add(commonCardTitleOption); //title as option object
        commonRecyclerItem.setOptions(options);
        return commonRecyclerItem;
    }

    public static List<CommonRecyclerItem> getScrollingIWItems(Context context, List<?> lessonsOrCourses, String actionText, View.OnClickListener actionClickListener) {
        //prepare IW items
        List<CommonRecyclerItem> recyclerItems = new ArrayList<>();
        for (Object lessonsOrCourse : lessonsOrCourses) {
            if (lessonsOrCourse instanceof Lesson) {
                recyclerItems.add(new CommonRecyclerItem(CommonRecyclerItem.ItemType.LESSON_TILE, lessonsOrCourse));
            }
        }

        //view all
        if (actionClickListener != null && lessonsOrCourses.size() == context.getResources().getInteger(R.integer.scrollableLessonCourseNo)) {
            CommonRecyclerItem scrollingViewAll = new CommonRecyclerItem(CommonRecyclerItem.ItemType.SCROLLING_VIEW_ALL, actionClickListener);
            List<Object> options = new ArrayList<>();
            options.add(actionText); //to show below the arrow
            scrollingViewAll.setOptions(options);
            recyclerItems.add(scrollingViewAll);
        }

        return recyclerItems;
    }

    public void bindIWitem(Context context, CommonRecyclerItem commonRecyclerItem){
        setHeader(context, commonRecyclerItem);
        this.context = context;
        scrollerAdapter = new HorizontalScrollerAdapter(context, (List<CommonRecyclerItem>) commonRecyclerItem.getItem());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(scrollerAdapter);

    }

    private void setHeader(final Context context, CommonRecyclerItem iwRecyclerItem) {
        CommonCardTitleOption commonCardTitleOption = null;
        try {
            commonCardTitleOption = (CommonCardTitleOption) iwRecyclerItem.getOptions().get(0);

        } catch (Exception e) {
        }
        cardTitleViewHolder.bind(context, commonCardTitleOption);
    }

}
