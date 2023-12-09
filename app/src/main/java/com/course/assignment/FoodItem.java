package com.course.assignment;

public class FoodItem {
    String food_name, food_count, content, place, date, time;
    byte[] image;
    int id;

    public FoodItem(int id, String food_name, String food_count, String content, String place, String date, String time, byte[] image) {
        this.id = id;
        this.food_name = food_name;
        this.food_count = food_count;
        this.content = content;
        this.place = place;
        this.date = date;
        this.time = time;
        this.image = image;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getFood_count() {
        return food_count;
    }

    public void setFood_count(String food_count) {
        this.food_count = food_count;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
