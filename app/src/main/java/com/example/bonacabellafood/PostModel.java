package com.example.bonacabellafood;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedList;

public class PostModel {
    private String title, content, date, excerpt;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }


    public PostModel(String title, String content, String date, String excerpt) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.excerpt = excerpt;
    }

    public PostModel() {
    }

    public static PostModel parseJSONObject(JSONObject object) {
        PostModel post = new PostModel();

        try {

            if (object.has("title")) {
                post.setTitle(object.getJSONObject("title").getString("rendered"));
            }

            if (object.has("content")) {
                post.setContent(object.getJSONObject("content").getString("rendered"));
            }
            if (object.has("excerpt")) {
                post.setExcerpt(object.getJSONObject("excerpt").getString("rendered"));
            }
            if (object.has("date")) {
                post.setDate(object.getString("date"));
            }

        } catch (Exception e) {

        }

        return post;
    }

    public static LinkedList<PostModel> parseJSONArray(JSONArray array) {
        LinkedList<PostModel> list = new LinkedList<>();

        try {
            for (int i = 0; i < array.length(); i++) {
                PostModel post = parseJSONObject(array.getJSONObject(i));
                list.add(post);
            }

        } catch (Exception e) {

        }

        return list;
    }
}
