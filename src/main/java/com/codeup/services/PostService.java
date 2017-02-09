package com.codeup.services;
import com.codeup.models.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by kevinjones on 2/8/17.
 */

@Service("postService")
public class PostService {

    private List<Post> posts = new ArrayList<>();

    public PostService() {
        // This runs by the time the class is created
        createPosts();
    }

    public Post save (Post post) {
        post.setId(posts.size() + 1);
        posts.add(post);
        return post;
    }

    //retrieving all the posts
    public List<Post> findAll() {
        return posts;
    }

    //find one post
    public Post findOne(int id) {
        return posts.get(id - 1) ;
    }

    //Luis' PostService loop
//    public PostService() {
//        for (int i = 0; i < 100; i++) {
//            posts.add(
//                    new Post(i+1, "Title" + (i + 1), "Body" + (i + 1))
//            );
//        }
//    }
    private void createPosts() {
        // create some post objects and add them to the posts list with the save method

        for (int i = 0; i < 100; i++) {
            save(new Post("title" + " " + (i + 1), "Some body content" + " " +(i + 2) ));
        }

    }
}


