package com.cydeo.controller;

import com.cydeo.dto.TaskDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.ProjectService;
import com.cydeo.service.TaskService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
public class TaskController {

    private final ProjectService projectService;
    private final UserService userService;
    private final TaskService taskService;

    public TaskController(ProjectService projectService, UserService userService, TaskService taskService) {
        this.projectService = projectService;
        this.userService = userService;
        this.taskService = taskService;
    }

    @GetMapping("/create")
    public String createTask(Model model, TaskDTO task) {

        model.addAttribute("task", new TaskDTO());
        model.addAttribute("projects", projectService.findAll() );
        model.addAttribute("tasks", taskService.findAll() );
        model.addAttribute("employees", userService.findEmployees() );

        return "/task/create";
    }
    @PostMapping("/create")
    public String insertTask(TaskDTO task){

        taskService.save(task);

        return "redirect:/task/create";
    }
    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") Long id) {

        taskService.deleteById(id);

        return "redirect:/task/create";
    }
    @GetMapping("/update/{taskId}")
    public String editTask(@PathVariable("taskId") Long taskId, Model model){

       model.addAttribute("task", taskService.findById(taskId));
       model.addAttribute("projects", projectService.findAll());
       model.addAttribute("employees", userService.findEmployees());
       model.addAttribute("tasks", taskService.findAll());

        return "/task/update";
    }
    @PostMapping("/update/{id}")
    public String updateTask(TaskDTO task){


        taskService.update(task);

        return "redirect:/task/create";
    }
    @GetMapping("/employee/pending-tasks")
    public String employeePendingTasks(Model model){

        model.addAttribute("tasks", taskService.findAllTasksByStatusIsNot(Status.COMPLETE));


        return "/task/pending-tasks";
    }



}
