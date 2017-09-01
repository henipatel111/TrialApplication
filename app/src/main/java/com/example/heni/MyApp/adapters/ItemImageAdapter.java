package com.example.heni.MyApp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.heni.MyApp.R;
import com.example.heni.MyApp.models.Post;
import com.example.heni.MyApp.utilities.CommonRecyclerItem;
import com.example.heni.MyApp.viewholders.ItemImageViewHolder;
import com.example.heni.MyApp.viewholders.ItemVideoViewHolder;

import java.util.List;

/**
 * Created by heni on 15/7/17.
 */

public class ItemImageAdapter extends RecyclerView.Adapter {

    Context context;
    Post postList;
    LayoutInflater layoutInflater;
    List<CommonRecyclerItem> recyclerItems;

    private final int TYPE_POST_CARD_IMAGE=0,TYPE_POST_CARD_VIDEO=1;

    public ItemImageAdapter(Context context,List<CommonRecyclerItem> recyclerItems){
        this.context = context;
        this.recyclerItems = recyclerItems;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /*View itemView = layoutInflater.inflate(R.layout.layout_item_image, parent, false);
        return new ItemImageViewHolder(itemView);*/

        View itemView;
        RecyclerView.ViewHolder viewHolder;
        switch (viewType) {
            case TYPE_POST_CARD_IMAGE:
                itemView = layoutInflater.inflate(R.layout.layout_item_image, parent, false);
                viewHolder = new ItemImageViewHolder(itemView);
                break;
            case TYPE_POST_CARD_VIDEO:
                itemView = layoutInflater.inflate(R.layout.layout_item_video, parent, false);
                viewHolder = new ItemVideoViewHolder(itemView);
                break;
            default:
                viewHolder = null;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
       // ((ItemImageViewHolder) holder).bindItem(context,recyclerItems.get(position));
        switch (getItemViewType(position)) {

            case TYPE_POST_CARD_IMAGE:
                ItemImageViewHolder itemImageViewHolder  = (ItemImageViewHolder) holder;
                itemImageViewHolder.bindItem(context,recyclerItems.get(position));
                break;
            case TYPE_POST_CARD_VIDEO:
                ItemVideoViewHolder itemVideoViewHolder = (ItemVideoViewHolder) holder;
                itemVideoViewHolder.bindItem(context,recyclerItems.get(position));
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
            case POST_IMAGE:
                return TYPE_POST_CARD_IMAGE;
            case POST_VIDEO:
                return TYPE_POST_CARD_VIDEO;

            default:
                return TYPE_POST_CARD_IMAGE;
        }
    }

    public List<CommonRecyclerItem> getRecyclerItems() {
        return recyclerItems;
    }

    public void setRecyclerItems(List<CommonRecyclerItem> recyclerItems) {
        this.recyclerItems = recyclerItems;
    }
}
