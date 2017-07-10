package com.example.heni.bannersonhomepage.models;

/**
 * Created by heni on 8/7/17.
 */

public class Banner {

   // private int id;
    private String title;
    private String linkUrl;
    private String description;

    public Banner(String title, String linkUrl,String description) {
        this.title = title;
        this.linkUrl = linkUrl;
        this.description = description;
    }

   /* public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }*/

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
