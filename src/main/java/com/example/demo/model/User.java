package com.example.demo.model;

import java.util.Collection;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 用户类
 * @author pwb
 */
@Entity
@Table(name="user")
public class User {
	/**
	 * 主键
	 */
	@Id
	@Column(name="id",length=20)
	private long id;
	
	/**
	 * 用户名
	 */
	@Column(name="username",length=50)
	private String username;
	
	/**
	 * 密码 
	 */
	@Column(name="password",length=50)
	private String password;
	
	/**
	 * 状态
	 */
	@Column(name="status",length=11)
	private int status;
	
	/**
	 * 描述
	 */
	@Column(name="descn",length=200)
	private String descn;
	
	/**
	 * 角色
	 * @return
	 */
	@ManyToMany(targetEntity=Role.class)
	@JoinTable(name = "user_role",
	           joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
	           inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private Set<Role> role;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDescn() {
		return descn;
	}

	public void setDescn(String descn) {
		this.descn = descn;
	}

	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}



}
