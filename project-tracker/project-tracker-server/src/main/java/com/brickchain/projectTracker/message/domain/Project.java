package com.brickchain.projectTracker.message.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.brickchain.projectTracker.message.domain.Task;

@Entity
@Table(name = "PROJECT_CONVERSATION")
@NamedQuery(name = "ProjectConversation.findByProjectUUID", query = "Select p from Project p where p.projectUUID like :projectUUID")
public class Project implements Conversation {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ProjectConversationSeqGenerator")
	@SequenceGenerator(name = "ProjectConversationSeqGenerator", sequenceName = "CONVERSATION_PROJECT_ID_SEQ", allocationSize = 1)
	private Long id;

	@Column(unique = true)
	private String projectUUID;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "PROJECT_ID", referencedColumnName = "ID")
	private List<Task> tasks;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "CONVERSATION_PROJECT_ID", referencedColumnName = "ID")
	private List<Message> messages;

	public Project(String projectUUID) {
		this.projectUUID = projectUUID;
		this.tasks = new ArrayList<>();
		this.messages = new ArrayList<>();
	}

	public void addTask(Task task) {
		tasks.add(task);
	}

	@Override
	public void addMessages(Message... message) {
		messages.addAll(Arrays.asList(message));
	}

	@Override
	public List<Message> getMessages() {
		return messages;
	}

	public Long getId() {
		return id;
	}

	public String getProjectUUID() {
		return projectUUID;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public Task getTask(Long taskId) {
		return tasks.stream().filter(task -> task.getId() == taskId).findAny()
				.orElseThrow(() -> new RuntimeException("Task not found"));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((projectUUID == null) ? 0 : projectUUID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		if (projectUUID == null) {
			if (other.projectUUID != null)
				return false;
		} else if (!projectUUID.equals(other.projectUUID))
			return false;
		return true;
	}
}
