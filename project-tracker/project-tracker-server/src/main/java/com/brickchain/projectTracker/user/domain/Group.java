package com.brickchain.projectTracker.user.domain;

import java.io.Serializable;
import java.util.List;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="GROUP")
@NamedQueries({
    @NamedQuery(name = "Group.findAll",
            query = "Select g from Group g order by g.name asc"),
    @NamedQuery(name = "Group.findGroupByName",
            query = "Select g from Group g where g.name like :name")})
public class Group implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GroupSeqGenerator")
	@SequenceGenerator(name = "GroupSeqGenerator", sequenceName = "GROUP_ID_SEQ", allocationSize = 1)
    private Long id;
    
    @NotNull
    @Column(name="GROUP_NAME", unique=true)
    private String name; 
    
    @Column(unique=true)
    private String description; 
    
    @ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "PROJECT_TRACKER_USER_GROUP", joinColumns = { @JoinColumn(name = "GROUP_ID", referencedColumnName = "ID") })
	private List<User> user;
    
    public Group() {
    }
    
    public Group(String name, String description) {
    	this.name = name;
    	this.description = description;
    }
        
    public void addDescription(String description) {
    	this.description = description;
    }

	public Long getId() {
		return id;
	}


	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
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
		Group other = (Group) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
    
}
