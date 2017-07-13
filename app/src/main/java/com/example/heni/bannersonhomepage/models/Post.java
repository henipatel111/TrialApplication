package com.example.heni.bannersonhomepage.models;

/**
 * Created by heni on 12/7/17.
 */

public class Post {
    private String title;
    private String description;
    private int image;

    public Post(String title,String description, int image) {
        this.title = title;
        this.description = description;
        this.image = image;
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

    public void setImage(int image){
        this.image = image;
    }

    public int getImage(){
        return image;
    }

}
