package com.example.admin.loginwebapp.bootstrap;

import com.example.admin.loginwebapp.domain.Task;
import com.example.admin.loginwebapp.domain.User;
import com.example.admin.loginwebapp.repositories.TaskRepository;
import com.example.admin.loginwebapp.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

@Component
public class BootStrapData implements CommandLineRunner {

    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    public BootStrapData(UserRepository userRepository, TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        User testUser = new User("testUser","password","Test User","test");
        //Date object
        Date date= new Date();
        //getTime() returns current time in milliseconds
        long time = date.getTime();
        //Passed the milliseconds to constructor of Timestamp class
        Timestamp ts = new Timestamp(time);
        System.out.println("Current Time Stamp: "+ts);
        Task testTask1 = new Task("test 1", "testing 1 task", ts,ts);
        Task testTask2 = new Task("test 1", "testing 1 task", ts,ts);
        testTask1.getUsers().add(testUser);
        testTask2.getUsers().add(testUser);

        userRepository.save(testUser);
        taskRepository.save(testTask1);
        taskRepository.save(testTask2);

        User devUser = new User("testUser","devUser","Dev User","dev");
        Task devTask1 = new Task("test 1", "testing 1 task", ts,ts);
        Task devTask2 = new Task("test 1", "testing 1 task", ts,ts);
        testTask1.getUsers().add(devUser);
        testTask2.getUsers().add(devUser);
        userRepository.save(devUser);
        taskRepository.save(devTask1);
        taskRepository.save(devTask2);

        User adminUser = new User("adminUser","Unix","Admin User","admin");
        Task adminTask1 = new Task("test 1", "testing 1 task", ts,ts);
        Task adminTask2 = new Task("test 1", "testing 1 task", ts,ts);
        testTask1.getUsers().add(adminUser);
        testTask2.getUsers().add(adminUser);
        userRepository.save(devUser);
        taskRepository.save(adminTask1);
        taskRepository.save(adminTask2);
        System.out.println("Total User records : "+userRepository.count());
        System.out.println("Total Task records : "+taskRepository.count());

    }
}
