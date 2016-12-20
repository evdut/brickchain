package com.brickchain.projectTracker.user.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CONTACT")
public class Contact implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ContactSeqGenerator")
	@SequenceGenerator(name = "ContactSeqGenerator", sequenceName = "CONTACT_ID_SEQ", allocationSize = 1)
	private Long id;

	@OneToOne()
	@JoinColumn(name="CONTACT_USER_ID", referencedColumnName = "ID")
	private User contact;

	public Contact() {
	}

	public Contact(User contact) {
		this.contact = contact;
	}
	
	public Contact(Long id) {
		this.id = id;
	}

	public User getContact() {
		return contact;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contact == null) ? 0 : contact.hashCode());
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
		Contact other = (Contact) obj;
		if (contact == null) {
			if (other.contact != null)
				return false;
		} else if (!contact.equals(other.contact))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
