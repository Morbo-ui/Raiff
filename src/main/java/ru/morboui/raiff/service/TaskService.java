package ru.morboui.raiff.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.morboui.raiff.entity.Task;
import ru.morboui.raiff.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {

  private TaskRepository taskRepository;

  public List<Task> getAll() {
    return taskRepository.findAll(Sort.by(
        Sort.Order.asc("date"),
        Sort.Order.desc("priorityId")));
  }

  public Task save(Task task) {
    return taskRepository.save(task);
  }

  public void delete(int id) {
    taskRepository.deleteById(id);
  }
}
