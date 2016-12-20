package com.brickchain.projectTracker.message.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "MESSAGE")
public class Message implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MessageSeqGenerator")
	@SequenceGenerator(name = "MessageSeqGenerator", sequenceName = "MESSAGE_ID_SEQ", allocationSize = 1)
	private Long id;

	@Column(nullable = false)
	private LocalDateTime publishTime;
	
	@Column(nullable = false, length = 20)
	private String userId;
	
	@Column(nullable = false, columnDefinition = "TEXT")
	private String content;

	public Message(LocalDateTime publishTime, String userId, String content) {
		this.publishTime = publishTime;
		this.userId = userId;
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public LocalDateTime getPublishTime() {
		return publishTime;
	}

	public String getUserId() {
		return userId;
	}

	public String getContent() {
		return content;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Message other = (Message) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
