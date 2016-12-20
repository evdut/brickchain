package com.brickchain.projectTracker.user.domain;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.brickchain.projectTracker.utils.ConstantUtils;

@Entity
@Table(name = "USER")
@NamedQueries({
		@NamedQuery(name = "User.findAll", query = "Select u from User u order by u.userName asc"),
		@NamedQuery(name = "User.findByName", query = "Select u from User u where u.userName like :name order by u.userName asc") })
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1571604976241524943L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UserSeqGenerator")
	@SequenceGenerator(name = "UserSeqGenerator", sequenceName = "USER_ID_SEQ", allocationSize = 1)
	private Long id;

	@NotNull
	@Column(name = "EMAIL", unique = true)
	private String email;

	@NotNull
	@Column(name = "USERNAME", unique = true)
	private String userName;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(unique = true)
	private String profileId;
	
	private String password;
	
	private String phone;

	@ManyToMany
	@JoinTable(name = "PROJECT_TRACKER_USER_GROUP", joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID"))
	private List<Group> group;

	/**
	 * Used only for cascade deleting of Contacts where user is involved
	 */
	@OneToMany(mappedBy="contact", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<Contact> userAsContact;
	
	/**
	 * This field is a {@link java.util.List} of user contacts
	 */
	@OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "CONTACT_ID", referencedColumnName = "ID", nullable = false)
	private List<Contact> contacts;
	
	public User() {
	}

	public User(String password, String email) {
		this(password, email, email);
	}

	public User(String password, String email, String userName) {
		this(password, email, userName, null, null);
	}
	
	public User(String password, String email, String userName, String firstName, String lastName) {
		this.password = encodePassword(password);
		this.email = email;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.group = new ArrayList<>();
		this.contacts = new ArrayList<>();
	}
	
	public User(Long id) {
		this.id = id;
	} 
	
	public String getProfileId() {
		return this.profileId;
	}

	public void updateProfile(String firstName, String lastName, String userName, String phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.phone = phone;
	}

	public void updatePassword(String password) {
		this.password = encodePassword(password);
	}

	public void addGroup(Group group) {
		this.group.add(group);
	}

	public void addContact(User user) {
		this.contacts.add(new Contact(user));
	}
	
	public void removeContact(Contact contact) {
		this.contacts.remove(contact);
	}
	
	public List<Contact> getContacts() {
		return contacts;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getUserName() {
		return userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhone() {
		return phone;
	}

	@PostPersist
	private void createProfileId() {
		this.profileId = String.format(ConstantUtils.UUID_FORMAT, id);
	}
	
	private String encodePassword(String password) {
		if (password != null) {
			try {
				MessageDigest md = MessageDigest.getInstance("SHA-256");
				byte[] passBytes = password.getBytes();
				md.reset();
				byte[] digested = md.digest(passBytes);
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < digested.length; i++) {
					sb.append(Integer
							.toString((digested[i] & 0xff) + 0x100, 16)
							.substring(1));
				}
				return sb.toString();
			} catch (NoSuchAlgorithmException ex) {
				Logger.getLogger(User.class.getName()).log(Level.ALL, null, ex);
			}
		}
		return null;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 67 * hash + Objects.hashCode(this.profileId);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final User other = (User) obj;
		return Objects.equals(this.profileId, other.profileId);
	}
}
