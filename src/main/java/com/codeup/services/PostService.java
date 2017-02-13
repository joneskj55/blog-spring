package com.codeup.services;
import com.codeup.models.Post;
import com.codeup.repositories.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by kevinjones on 2/8/17.
 */

@Service("postService")
public class PostService {

    private List<Post> posts = new ArrayList<>();
    private PostsRepository repository;

    @Autowired
    public PostService(PostsRepository repository) {
        this.repository = repository;
    }

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
        //iterable -> List (casting it)
        return (List<Post>) repository.findAll(); //select * from posts
    }

    //find one post
    public Post findOne(int id) {
        return posts.get(id - 1) ;
    }
}


