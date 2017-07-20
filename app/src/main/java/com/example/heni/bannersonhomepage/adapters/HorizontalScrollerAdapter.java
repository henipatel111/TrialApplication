package com.example.heni.bannersonhomepage.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.heni.bannersonhomepage.R;
import com.example.heni.bannersonhomepage.models.Lesson;
import com.example.heni.bannersonhomepage.utilities.CommonRecyclerItem;
import com.example.heni.bannersonhomepage.viewholders.CommonSpaceViewHolder;
import com.example.heni.bannersonhomepage.viewholders.LessonTileViewHolder;
import com.example.heni.bannersonhomepage.viewholders.ScrollingViewAllViewHolder;

import java.util.List;

/**
 * Created by heni on 20/7/17.
 */

public class HorizontalScrollerAdapter extends RecyclerView.Adapter {

    Context context;
    private final int TYPE_LESSON_TILE = 1;
    private final int TYPE_SCROLLING_VIEW_MORE = 2;
    private final int TYPE_SPACE = 3;
    List<CommonRecyclerItem> commonRecyclerItems;

    public HorizontalScrollerAdapter(Context context, List<CommonRecyclerItem> iwRecyclerItems) {
        this.context = context;
        this.commonRecyclerItems = iwRecyclerItems;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView;
        RecyclerView.ViewHolder viewHolder;
        switch (viewType) {
            case TYPE_LESSON_TILE:
                rootView = LayoutInflater.from(context).inflate(R.layout.layout_fixedsize_lessonholder, parent, false);
                viewHolder = new LessonTileViewHolder(rootView);
                break;
            case TYPE_SCROLLING_VIEW_MORE:
                rootView = LayoutInflater.from(context).inflate(R.layout.layout_scrolling_viewall, parent, false);
                viewHolder = new ScrollingViewAllViewHolder(rootView);
                break;
            case TYPE_SPACE:
                rootView = LayoutInflater.from(context).inflate(R.layout.learnapt_recycler_space, parent, false);
                viewHolder = new CommonSpaceViewHolder(rootView);
                break;
            default:
                rootView = LayoutInflater.from(context).inflate(R.layout.learnapt_recycler_space, parent, false);
                viewHolder = new CommonSpaceViewHolder(rootView);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TYPE_LESSON_TILE:
                LessonTileViewHolder lessonTileViewHolder = (LessonTileViewHolder) holder;
                lessonTileViewHolder.attachLesson(context, (Lesson) commonRecyclerItems.get(position).getItem());
                break;

            case TYPE_SCROLLING_VIEW_MORE:
                ScrollingViewAllViewHolder scrollingViewAllViewHolder = (ScrollingViewAllViewHolder) holder;
                scrollingViewAllViewHolder.bindIWItem(context, commonRecyclerItems.get(position));
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        switch (commonRecyclerItems.get(position).getItemType()) {
            case LESSON_TILE:
                return TYPE_LESSON_TILE;

            case SCROLLING_VIEW_ALL:
                return TYPE_SCROLLING_VIEW_MORE;

            default:
                return TYPE_SPACE;
        }
    }

    @Override
    public int getItemCount() {
        return commonRecyclerItems.size();
    }
}
