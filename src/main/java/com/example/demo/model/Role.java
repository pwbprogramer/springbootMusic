package com.example.demo.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 角色类
 * @author pwb
 */
@Entity
@Table(name="role")
public class Role {
	
	/**
	 * 主键
	 */
	@Id
	@Column(name="id",length=20)
	private long id;
	
	/**
	 * 角色
	 */
	@Column(name="name",length=50)
	private String name;
	
	/**
	 * 描述
	 */
	@Column(name="descn",length=200)
	private String descn;
    
	@ManyToMany(targetEntity=User.class)
	@JoinTable(name = "user_role", 
	           joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id") },
	           inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id") })
	private Set<User> user;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescn() {
		return descn;
	}

	public void setDescn(String descn) {
		this.descn = descn;
	}
	
	

}
