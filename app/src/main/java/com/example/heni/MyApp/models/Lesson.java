package com.example.heni.MyApp.models;

import android.content.Context;
import android.view.View;

import com.example.heni.MyApp.R;
import com.example.heni.MyApp.activities.ViewAllListActivity;
import com.example.heni.MyApp.utilities.CommonRecyclerItem;
import com.example.heni.MyApp.viewholders.LessonScrollerViewHolder;

import java.util.List;

/**
 * Created by heni on 19/7/17.
 */

public class Lesson {

    int lessonId;
    String lessonTitle;
    String shortDesc;
    String longDesc;
    public static String KEY_LESSON_RECENT = "recentLessons";
    public static int COVER_NOT_INITIATED = 0;
    public static int COVER_STATE_FAILED = 1;
    public static int COVER_STATE_IN_PROGRESS = 2;
    public static int COVER_STATE_LOADED = 3;

    public static String TAG = "ItemFetch:";
    public int coverDownloadState = 0;
    private boolean completed;
    private boolean paid;
    private int coverImage;
    private String price;
    private String coverImageUrl;
    private String coverImageThumbUrl;
    String publisherName;
    boolean favourited;
    int rating;


    public Lesson(int lessonId, String lessonTitle, String shortDesc, String longDesc, int coverImage, String price,String publisherName, int rating,boolean paid){
        this.lessonId = lessonId;
        this.lessonTitle = lessonTitle;
        this.shortDesc = shortDesc;
        this.longDesc = longDesc;
        this.coverImage = coverImage;
        this.price = price;
        this.publisherName = publisherName;
        this.rating = rating;
        this.paid = paid;

    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }



    public int getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(int coverImage) {
        this.coverImage = coverImage;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    int imageId;

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public String getLessonTitle() {
        return lessonTitle;
    }

    public void setLessonTitle(String lessonTitle) {
        this.lessonTitle = lessonTitle;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean isFavourited() {
        return favourited;
    }

    public void setFavourited(boolean favourited) {
        this.favourited = favourited;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public String getCoverImageThumbUrl() {
        String imageURL = coverImageThumbUrl;
        return imageURL;
    }

    public void setCoverImageThumbUrl(String coverImageThumbUrl) {
        this.coverImageThumbUrl = coverImageThumbUrl;
    }

    public static CommonRecyclerItem getRecentLessonIWItem(final Context context, String title, List<Lesson> recentLessons) {
        View.OnClickListener viewAllClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewAllListActivity.openRecentLessons(context);
            }
        };
        return LessonScrollerViewHolder.generateIWRecyclerView(context, recentLessons, R.drawable.ic_schedule_white_24dp, title, "View all", viewAllClickListener);
    }



}
