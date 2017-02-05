package com.brickchain.projectTracker.message.domain;

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
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "TaskConversation")
@Table(name = "TASK_CONVERSATION")
public class Task implements Conversation {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TaskConversationSeqGenerator")
	@SequenceGenerator(name = "TaskConversationSeqGenerator", sequenceName = "CONVERSATION_TASK_ID_SEQ", allocationSize = 1)
	private Long id;

	@Column(name = "PROJECT_ID", insertable = false, updatable = false)
	private Long projectId;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumns({ @JoinColumn(name = "CONVERSATION_PROJECT_ID", referencedColumnName = "PROJECT_ID"),
			@JoinColumn(name = "TASK_ID", referencedColumnName = "ID") })
	private List<Message> messages;

	@SuppressWarnings("unused")
	private Task() {
	}

	public Task(Long id) {
		this.id = id;
		this.messages = new ArrayList<>();
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
}
