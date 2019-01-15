package com.codeup.codeupblog.repositories;
import com.codeup.codeupblog.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
