package com.brickchain.projectTracker.notification.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "NOTIFICATION_SOURCE_OBJECT")
public class NotificationSourceObject implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NotificationSOSeqGenerator")
	@SequenceGenerator(name = "NotificationSOSeqGenerator", sequenceName = "NOTIFICATION_SOURCE_OBJECT_ID_SEQ", allocationSize = 1)
	private Long id;

	private String action;
	private String type;
	private String owner;

	public NotificationSourceObject() {
	}

}
