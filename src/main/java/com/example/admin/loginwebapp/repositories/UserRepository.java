package com.example.admin.loginwebapp.repositories;

import com.example.admin.loginwebapp.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
