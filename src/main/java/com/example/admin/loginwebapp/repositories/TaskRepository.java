package com.example.admin.loginwebapp.repositories;

import com.example.admin.loginwebapp.domain.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {
}
