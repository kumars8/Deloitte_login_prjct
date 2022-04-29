package com.example.admin.loginwebapp.domain;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String taskName;
    private String taskDescription;
    @ManyToOne
    private Set<User> users= new HashSet<>();
    private Timestamp taskLogDate;
    private Timestamp taskUpdateDate;

    public Long getId() {
        return id;
    }

    public Task() {
    }

    public Task(String taskName, String taskDescription, Timestamp taskLogDate, Timestamp taskUpdateDate) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskLogDate = taskLogDate;
        this.taskUpdateDate = taskUpdateDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Timestamp getTaskLogDate() {
        return taskLogDate;
    }

    public void setTaskLogDate(Timestamp taskLogDate) {
        this.taskLogDate = taskLogDate;
    }

    public Timestamp getTaskUpdateDate() {
        return taskUpdateDate;
    }

    public void setTaskUpdateDate(Timestamp taskUpdateDate) {
        this.taskUpdateDate = taskUpdateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", users=" + users +
                ", taskLogDate=" + taskLogDate +
                ", taskUpdateDate=" + taskUpdateDate +
                '}';
    }
}
