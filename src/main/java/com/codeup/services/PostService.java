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

    private void createPosts() {
        for (int i = 0; i < 100; i++) {
            save(new Post("title" + " " + (i + 1), "Some body content" + " " +(i + 2) ));
        }
    }

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
}


