package com.codeup.codeupblog.repositories;
import com.codeup.codeupblog.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}