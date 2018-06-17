/**
 * 
 */
package com.myjavablog.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myjavablog.model.Task;

/**
 * @author anupb
 *
 */
@RestController
public class TodoController {

	static List<Task> taskList = new ArrayList<Task>();
	static {
		Task t1 = new Task(1l, "Walking", "Walking at 6 AM", "PENDING");
		Task t2 = new Task(2l, "Breakfast", "Breakfast 7 AM", "COMPLETED");
		Task t3 = new Task(3l, "Office", "Office at 9 AM", "COMPLETED");
		Task t4 = new Task(4l, "Lunch", "Lunch at 1 PM", "PENDING");
		Task t5 = new Task(5l, "Snacks", "Snacks at 6 PM", "PENDING");
		Task t6 = new Task(6l, "Play", "Cricket at 2 PM", "PENDING");
	
		taskList.add(t1);
		taskList.add(t2);
		taskList.add(t3);
		taskList.add(t4);
		taskList.add(t5);
		taskList.add(t6);
	}

	@RequestMapping(value = "/tasks", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Task> getTasks() {

		return taskList;
	}

	@RequestMapping(value = "/addTask", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addTask(@RequestBody Task task) {

		taskList.add(task);

		return "Task added Succesfully!!!";
	}

	@RequestMapping(value = "/task/{taskId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Task getTask(@PathVariable Long taskId) {

		for (Task task : taskList) {

			if (task.getId() == taskId)
				return task;
		}
		return null;
	}

	@RequestMapping(value = "/deleteTask/{taskId}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public String deleteTask(@PathVariable Long taskId) {

		boolean flag = false;
		Task tempTask = null;
		for (Task task : taskList) {

			if (task.getId() == taskId) {
				tempTask = task;
				break;
			}
		}

		flag = taskList.remove(tempTask);
		if (flag)
			return "Task deleted successfully!!!!!";
		else
			return "Error in deleting Task!!!!!";
	}

	@RequestMapping(value = "/updateTask/{id}/{status}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public String updateTask(@PathVariable Long id, @PathVariable String status) {

		for (Task task : taskList) {

			if (task.getId() == id) {
				task.setStatus(status);
			}
		}

		return "Task updated Succesfully!!!";
	}
}
