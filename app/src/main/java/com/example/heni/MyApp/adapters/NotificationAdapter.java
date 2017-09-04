package com.example.heni.MyApp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.heni.MyApp.R;
import com.example.heni.MyApp.utilities.CommonRecyclerItem;
import com.example.heni.MyApp.viewholders.NotificationViewHolder;
import com.example.heni.MyApp.viewholders.PostViewHolder;

import java.util.List;

import static com.example.heni.MyApp.utilities.CommonRecyclerItem.ItemType.NOTIFIACTION;

/**
 * Created by heni on 2/9/17.
 */

public class NotificationAdapter extends Adapter {

    Context context;
    List<CommonRecyclerItem> recyclerItems;
    LayoutInflater layoutInflater;

    public NotificationAdapter(Context context, List<CommonRecyclerItem> recyclerItems){
        this.context = context;
        this.recyclerItems = recyclerItems;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.notification_view_holder, parent, false);
        if (itemView != null) {
            return new NotificationViewHolder(itemView);
        } else {
            RecyclerView.ViewHolder viewHolder = null;
            View rootView;
            if (NOTIFIACTION.matches(viewType)) {
                rootView = layoutInflater.inflate(R.layout.notification_view_holder, parent, false);
                viewHolder = new NotificationViewHolder(rootView);
            }
            return viewHolder;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((NotificationViewHolder) holder).bindCRItem(context,recyclerItems.get(position));
    }

    @Override
    public int getItemCount() {
        return recyclerItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        return recyclerItems.get(position).getItemType().getId();
    }
}
