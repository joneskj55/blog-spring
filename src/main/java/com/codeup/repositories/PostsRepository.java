package com.codeup.repositories;

import com.codeup.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by kevinjones on 2/9/17.
 */
@Repository
public interface PostsRepository extends CrudRepository<Post, Integer>{
    @Query("select p from Post p where p.title like ?1")
    public List<Post> findWhereTitleLike(String title);
}
