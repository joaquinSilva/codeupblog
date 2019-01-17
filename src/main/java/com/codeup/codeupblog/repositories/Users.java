package com.codeup.codeupblog.repositories;

import com.codeup.codeupblog.models.User;
import org.springframework.data.repository.CrudRepository;

public interface Users extends CrudRepository<User, Long> {
	User findByUsername(String username);
}
