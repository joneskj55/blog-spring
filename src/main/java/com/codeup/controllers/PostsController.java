package com.codeup.controllers;
import com.codeup.models.Post;
import com.codeup.models.User;
import com.codeup.repositories.PostsRepository;
import com.codeup.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * Created by kevinjones on 2/7/17.
 */

@Controller
public class PostsController {

//    @Autowired
//    PostService postService;

    @Autowired
    PostsRepository postsDao;

    @GetMapping("/posts")
    public String viewAllPosts(Model viewModel) {
//        List<Post> posts = postService.findAll(); // array list with several Post objects
        viewModel.addAttribute("posts", Collections.emptyList());
        return "posts/index"; // posts/index
    }

    @GetMapping("/posts.json")
    public @ResponseBody List<Post> retrieveAllPosts() {
        return (List<Post>) postsDao.findAll(); // this may need to say repository.findAll() (PostService.java)
    }

    @GetMapping("/posts/{id}")
    public String ViewSinglePost(@PathVariable int id, Model viewModel) {
//        Post post = postService.findOne(id);
        viewModel.addAttribute("post", postsDao.findOne(id));
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
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        user.setId(1);
        post.setUser(user);
        postsDao.save(post);
//        postService.save(post);
        viewModel.addAttribute("post", post);
        return "redirect:/posts";
    }

    @GetMapping("posts/{id}/edit")
    public String editPost(@PathVariable int id, @ModelAttribute Post post, Model viewModel) {
        //viewModel.addAttribute("post", postDao.findOne(id));
        Post editedPost = postsDao.findOne(id);
        viewModel.addAttribute("post", editedPost);
        return "/posts/edit";
    }

    @PostMapping("posts/{id}/edit")
    public String updatePost(@ModelAttribute Post editedPost) {
        postsDao.save(editedPost);
        return "redirect:/posts";
    }

    @PostMapping("/posts/delete")
    public String deletePost(@ModelAttribute Post post) {
        postsDao.delete(postsDao.findOne(post.getId()));
        return "redirect:/posts";
    }
}
