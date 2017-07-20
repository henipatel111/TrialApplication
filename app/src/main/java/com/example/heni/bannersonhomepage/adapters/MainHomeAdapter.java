package com.example.heni.bannersonhomepage.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.heni.bannersonhomepage.R;
import com.example.heni.bannersonhomepage.utilities.CommonCardTitleOption;
import com.example.heni.bannersonhomepage.utilities.CommonRecyclerItem;
import com.example.heni.bannersonhomepage.viewholders.BannerViewHolder;
import com.example.heni.bannersonhomepage.viewholders.CardEndViewHolder;
import com.example.heni.bannersonhomepage.viewholders.CommonCardTitleViewHolder;
import com.example.heni.bannersonhomepage.viewholders.LessonScrollerViewHolder;

import java.util.List;

/**
 * Created by heni on 20/7/17.
 */

public class MainHomeAdapter extends RecyclerView.Adapter {

    final int TYPE_SECTION = 2, TYPE_CATEGORY = 3, TYPE_BLANK = 0, TYPE_ACK = 6, TYPE_LOADING = 7, TYPE_CARD_END = 8, TYPE_PRIMARY_CATEGORY = 9, TYPE_SET_PRIMARY = 10, TYPE_LESSON_COURSE_SCROLLER = 12, TYPE_CHILDREN = 13, TYPE_STANDALONE_CARD_HEADER = 14, TYPE_BANNER_PAGER = 11, TYPE_POST_CARD = 8;
    List<CommonRecyclerItem> recyclerItems;
    LayoutInflater inflater;
    Context context;
    RecyclerView.ViewHolder viewHolder;
    View rootView;

    public MainHomeAdapter(Context context, List<CommonRecyclerItem> recyclerItems) {
        if (context != null) {
            this.context = context;
            this.recyclerItems = recyclerItems;
            inflater = LayoutInflater.from(context);
        }
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {

            case TYPE_CARD_END:
                rootView = inflater.inflate(R.layout.layout_bottomcard_holder, parent, false);
                viewHolder = new CardEndViewHolder(rootView);
                break;
            case TYPE_LESSON_COURSE_SCROLLER:
                rootView = inflater.inflate(R.layout.layout_recycler_scroller, parent, false);
                viewHolder = new LessonScrollerViewHolder(rootView);
                break;
            case TYPE_STANDALONE_CARD_HEADER:
                rootView = inflater.inflate(R.layout.layout_standalone_card_header, parent, false);
                viewHolder = new CommonCardTitleViewHolder(rootView);
                break;
            case TYPE_BANNER_PAGER:
                rootView = inflater.inflate(R.layout.vh_banner_pager,parent,false);
                viewHolder = new BannerViewHolder(rootView);
                break;
        }

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {

            case TYPE_LESSON_COURSE_SCROLLER:
                LessonScrollerViewHolder lessonsCoursesScrollerViewHolder = (LessonScrollerViewHolder) holder;
                lessonsCoursesScrollerViewHolder.bindIWitem(context, recyclerItems.get(position));
                break;
            case TYPE_STANDALONE_CARD_HEADER:
                CommonCardTitleViewHolder cardTitleViewHolder = (CommonCardTitleViewHolder) holder;
                cardTitleViewHolder.bind(context, (CommonCardTitleOption) recyclerItems.get(position).getItem());
                break;
            case TYPE_BANNER_PAGER:
                BannerViewHolder bannerViewHolder = (BannerViewHolder) holder;
                bannerViewHolder.bindItem(context, recyclerItems.get(position));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return recyclerItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        switch (recyclerItems.get(position).getItemType()) {
            case CATEGORY_SECTION:
                return TYPE_SECTION;
            case CATEGORY_LIST_ITEM:
                return TYPE_CATEGORY;
            case CARD_ACK:
                return TYPE_ACK;
            case MORE_LOADING:
                return TYPE_LOADING;
            case CARD_END:
                return TYPE_CARD_END;
            case CATEGORY_PRIMARY_CARD:
                return TYPE_PRIMARY_CATEGORY;
            case LESSONS_COURSES_SCROLLER:
                return TYPE_LESSON_COURSE_SCROLLER;
            case CHILDREN_HOME:
                return TYPE_CHILDREN;
            case STANDALONE_CARD_HEADER:
                return TYPE_STANDALONE_CARD_HEADER;
            case BANNER_PAGER:
                return TYPE_BANNER_PAGER;
            default:
                return TYPE_BLANK;
        }
    }

    public List<CommonRecyclerItem> getRecyclerItems() {
        return recyclerItems;
    }

    public void setRecyclerItems(List<CommonRecyclerItem> recyclerItems) {
        this.recyclerItems = recyclerItems;
    }
}
