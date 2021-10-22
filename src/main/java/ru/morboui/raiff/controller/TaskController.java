package ru.morboui.raiff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.morboui.raiff.entity.Task;
import ru.morboui.raiff.service.TaskService;

import java.util.List;

@Controller
public class TaskController {

    private final TaskService taskService;

  public TaskController(TaskService taskService) {
    this.taskService = taskService;
  }

  @GetMapping("/")
    public String getAll(Model model) {
      List<Task> taskList = taskService.getAll();
      model.addAttribute("taskList", taskList);
      model.addAttribute("taskSize", taskList.size());
      return "index";
    }

    @RequestMapping("/delete/{id}")
    public String deleteTask(@PathVariable int id) {
      taskService.delete(id);
      return "redirect:/";
    }

    @PostMapping("/add")
    public String addTask(@ModelAttribute Task task) {
      taskService.save(task);
      return "redirect:/";
    }
}
