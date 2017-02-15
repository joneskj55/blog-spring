package com.codeup.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created by kevinjones on 2/8/17.
 */
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    @NotBlank(message = "Title cannot be empty.")
    private String title;

    @Column(nullable = false, length = 2000)
    @NotBlank(message = "Body cannot be empty")
    @Size(min = 5, message = "Body must have at least 5 characters.")
    private String body;

    //will define your foreign key
    //I will use a convention 'the_other_table_name_id'
    @ManyToOne
    @JoinColumn(name = "user_id") //defined at the table level
    @JsonManagedReference
    private User user; //owner, author

    public void setUser(User user) {
        this.user = user;
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Post() {
    }

    public User getUser() {
        return user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
