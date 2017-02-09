package com.codeup.repositories;

import com.codeup.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kevinjones on 2/9/17.
 */
@Repository
public interface Posts extends CrudRepository<Post, Long>{

}
