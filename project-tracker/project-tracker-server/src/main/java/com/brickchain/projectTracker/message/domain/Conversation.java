package com.brickchain.projectTracker.message.domain;

import java.io.Serializable;
import java.util.List;

public interface Conversation extends Serializable{
	
	public void addMessages(Message... message);

	public List<Message> getMessages();
}
