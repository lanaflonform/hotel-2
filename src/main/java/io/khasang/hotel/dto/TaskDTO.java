package io.khasang.hotel.dto;

import io.khasang.hotel.entity.Task;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class TaskDTO {
    private long id;
    private String name;
    private String bid;
    private LocalDate completed;
    private LocalDate createdAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public LocalDate getCompleted() {
        return completed;
    }

    public void setCompleted(LocalDate completed) {
        this.completed = completed;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }


    public Set<TaskDTO> getSetDTO(Set<Task> getSetTask) {
        Set<TaskDTO> taskDTOSet = new HashSet<>();

        for (Task task : getSetTask) {
            TaskDTO taskDTO = new TaskDTO();
            taskDTO.setId(task.getId());
            taskDTO.setName(task.getName());
            taskDTO.setBid(task.getBid());
            taskDTO.setCreatedAt(task.getCreatedAt());
            taskDTO.setCompleted(task.getCompleted());
            taskDTOSet.add(taskDTO);
        }
        return taskDTOSet;
    }

    public Set<TaskDTO> getSetDTOFromList(List<Task> taskByName) {
        Set<TaskDTO> taskDTOSet = new HashSet<>();

        for (Task task : taskByName) {
            TaskDTO taskDTO = new TaskDTO();
            taskDTO.setId(task.getId());
            taskDTO.setBid(task.getBid());
            taskDTO.setName(task.getName());
            taskDTO.setCompleted(task.getCompleted());
            taskDTO.setCreatedAt(task.getCreatedAt());
            taskDTOSet.add(taskDTO);
        }
        return taskDTOSet;
    }
}
