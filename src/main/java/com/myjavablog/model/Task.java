/**
 * 
 */
package com.myjavablog.model;

import java.io.Serializable;

/**
 * @author anupb
 *
 */
public class Task implements Serializable{

	
	private Long id;

	private String taskName;

	private String taskDesc;

	private String status;

	public Task() {}
	
	public Task(Long id, String taskName, String taskDesc, String status) {
		super();
		this.id = id;
		this.taskName = taskName;
		this.taskDesc = taskDesc;
		this.status = status;
	}

	public Long getId() {
		return id;
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

	public String getTaskDesc() {
		return taskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
