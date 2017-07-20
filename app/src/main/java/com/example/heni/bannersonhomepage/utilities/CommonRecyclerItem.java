package com.example.heni.bannersonhomepage.utilities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by heni on 8/7/17.
 */

public class CommonRecyclerItem {

    private ItemType itemType;
    private Object item;
    private List<Object> options;

    public CommonRecyclerItem(ItemType itemType, Object item) {
        this.itemType = itemType;
        this.item = item;
    }

    public CommonRecyclerItem(ItemType itemType, Object item, Object... options) {
        this.itemType = itemType;
        this.item = item;
        this.options = new ArrayList<>();
        for (Object option : options) {
            this.options.add(option);
        }
    }
    public CommonRecyclerItem(ItemType itemType, Object item, List<Object> options) {
        this.itemType = itemType;
        this.item = item;
        this.options = options;
    }

    public CommonRecyclerItem(ItemType itemType, List<Object> options) {
        this.itemType = itemType;
        this.options = options;
    }

    public static List<CommonRecyclerItem> generate(ItemType itemType, List<?> itemList, Object... options) {
        List<CommonRecyclerItem> commonRecyclerItems = new ArrayList<>();
        for (Object item : itemList) {
            commonRecyclerItems.add(new CommonRecyclerItem(itemType, item, options));
        }
        return commonRecyclerItems;
    }

    public static List<CommonRecyclerItem> generate(ItemType itemType, Object item, Object... options) {
        List<CommonRecyclerItem> commonRecyclerItems = new ArrayList<>();
        commonRecyclerItems.add(new CommonRecyclerItem(itemType, item, options));
        return commonRecyclerItems;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }

    public List<Object> getOptions() {
        return options;
    }

    public void setOptions(List<Object> options) {
        this.options = options;
    }

    public enum ItemType {
        LOADING(0),
        BANNER_PAGER(1),
        POST_CARD(2),
        LESSONS_COURSES_SCROLLER(3),
        STANDALONE_CARD_HEADER(4),
        LESSON_TILE(5),
        SCROLLING_VIEW_ALL(7),
        CATEGORY_SECTION(8),
        CARD_ACK(9),
        MORE_LOADING(10),
        CATEGORY_LIST_ITEM(11),
        CARD_END(12),
        CATEGORY_PRIMARY_CARD(13),
        CHILDREN_HOME(14);


        private final int id;

        ItemType(int value) {
            this.id = value;
        }

        public int getId() {
            return id;
        }

        public boolean matches(int id) {
            return this.id == id;
        }
    }
}
