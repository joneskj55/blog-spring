package com.codeup.controllers;

import com.codeup.models.Post;
import com.codeup.repositories.Posts;
import com.codeup.services.PostService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevinjones on 2/7/17.
 */

@Controller
public class PostsController {

    @Autowired
    PostService postService;

    @Autowired
    Posts postsDao;

    @GetMapping("/posts")
    public String viewAllPosts(Model viewModel) {
        List<Post> posts = postService.findAll(); // array list with several Post objects

        // pass the list to the view (through a view model)
//        posts.add(new Post("First Post", "Some content here"));
//        posts.add(new Post("Here is another post", "Body of post"));
        viewModel.addAttribute("posts", posts);

        return "posts/index"; // posts/index
    }

    @GetMapping("/posts/{id}")
    public String ViewSinglePost(@PathVariable int id, Model viewModel) {
        Post post = postService.findOne(id);
        viewModel.addAttribute("post", post);
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    public String viewCreatePostForm(Model viewModel) {
        Post post = new Post();
        viewModel.addAttribute("post", post);
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post, Model viewModel) {
        postsDao.save(post);
        postService.save(post);
        viewModel.addAttribute("post", post);
        return "redirect:/posts";
    }

    @PostMapping("/posts/{id}/edit")
    public String editPost(@PathVariable int id, Model viewModel) {
        viewModel.addAttribute("post", postService.findOne(id));
        return "posts/edit";
    }
}
