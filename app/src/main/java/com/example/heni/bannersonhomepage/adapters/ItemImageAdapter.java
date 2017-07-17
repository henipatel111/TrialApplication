package com.example.heni.bannersonhomepage.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.heni.bannersonhomepage.R;
import com.example.heni.bannersonhomepage.models.Post;
import com.example.heni.bannersonhomepage.utilities.CommonRecyclerItem;
import com.example.heni.bannersonhomepage.viewholders.ItemImageViewHolder;
import com.example.heni.bannersonhomepage.viewholders.PostViewHolder;

import java.util.List;

/**
 * Created by heni on 15/7/17.
 */

public class ItemImageAdapter extends RecyclerView.Adapter {

    Context context;
    Post postList;
    LayoutInflater layoutInflater;
    List<CommonRecyclerItem> recyclerItems;

    public ItemImageAdapter(Context context,List<CommonRecyclerItem> recyclerItems){
        this.context = context;
        this.recyclerItems = recyclerItems;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.layout_item_image, parent, false);
        return new ItemImageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ItemImageViewHolder) holder).bindItem(context,recyclerItems.get(position));
    }

    @Override
    public int getItemCount() {
        return recyclerItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        return recyclerItems.get(position).getItemType().getId();
    }

    public List<CommonRecyclerItem> getRecyclerItems() {
        return recyclerItems;
    }

    public void setRecyclerItems(List<CommonRecyclerItem> recyclerItems) {
        this.recyclerItems = recyclerItems;
    }
}
