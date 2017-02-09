package com.codeup.models;

import javax.persistence.*;

/**
 * Created by kevinjones on 2/9/17.
 */

public class Ad {

    private long id;
    private String title;
    private String description;


    public Ad(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Ad() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
