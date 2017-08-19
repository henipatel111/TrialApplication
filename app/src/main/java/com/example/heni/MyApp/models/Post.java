package com.example.heni.MyApp.models;

/**
 * Created by heni on 12/7/17.
 */

public class Post {
    private String title;
    private String description;
    private int image;
    private String postType;

    public Post(String title,String description, int image, String postType ) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.postType = postType;
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

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public static class PostType {
        public static final String IMAGE = "IMAGE", VIDEO = "VIDEO";
        private String code;

        public String getCode() {
            return code;
        }
        public void setCode(String code) {
            this.code = code;
        }

    }


}
