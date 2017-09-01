package com.example.heni.MyApp.models;

/**
 * Created by heni on 12/7/17.
 */

public class Post {
    private String title;
    private String description;
    private int image;
    private String postType;
    private String videoURL;
    private String youtubeVideoId;


    public Post(String title,String description, int image, String postType, String videoURL, String youtubeVideoId ) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.postType = postType;
        this.videoURL = videoURL;
        this.youtubeVideoId = youtubeVideoId;
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

    public String getVideoURL() {
        return videoURL;
    }

    public String getYoutubeVideoId() {
        return youtubeVideoId;
    }

    public void setYoutubeVideoId(String youtubeVideoId) {
        this.youtubeVideoId = youtubeVideoId;
    }


    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
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
