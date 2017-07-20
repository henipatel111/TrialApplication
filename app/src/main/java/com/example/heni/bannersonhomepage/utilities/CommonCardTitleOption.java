package com.example.heni.bannersonhomepage.utilities;

import android.view.View;

/**
 * Created by heni on 19/7/17.
 */

public class CommonCardTitleOption {

    String title;
    String actionText;
    View.OnClickListener actionClickListener;
    int drawableResID;

    public CommonCardTitleOption(int drawableResID, String title, String actionText, View.OnClickListener actionClickListener) {
        this.drawableResID = drawableResID;
        this.title = title;
        this.actionText = actionText;
        this.actionClickListener = actionClickListener;
    }
    public static CommonRecyclerItem getStandaloneHeaderIWItem(int drawableResID, String title, String actionText, View.OnClickListener actionClickListener) {
        return new CommonRecyclerItem(CommonRecyclerItem.ItemType.STANDALONE_CARD_HEADER, new CommonCardTitleOption(drawableResID, title, actionText, actionClickListener));
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getActionText() {
        return actionText;
    }

    public void setActionText(String actionText) {
        this.actionText = actionText;
    }

    public View.OnClickListener getActionClickListener() {
        return actionClickListener;
    }

    public void setActionClickListener(View.OnClickListener actionClickListener) {
        this.actionClickListener = actionClickListener;
    }

    public int getDrawableResID() {
        return drawableResID;
    }

    public void setDrawableResID(int drawableResID) {
        this.drawableResID = drawableResID;
    }


}
