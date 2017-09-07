package com.example.heni.MyApp.models;

/**
 * Created by heni on 4/9/17.
 */

public class MyNotification {
    private int id;

    private String title;

    private String description;

    private String imageUrl;

    private int imageId;

    private String datetime;

    private NotificationType notificationType;

    public NotificationType TYPE_POST = new NotificationType(1,"POST");

    public MyNotification(String title, String description,String datetime, int imageId){
        this.title = title;
        this.description = description;
        this.datetime = datetime;
        this.imageId = imageId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public class NotificationType {

        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public NotificationType(int id,String name){
            this.id=id;
            this.name=name;
        }

    }

}
