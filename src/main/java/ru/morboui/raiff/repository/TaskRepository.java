package ru.morboui.raiff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.morboui.raiff.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
