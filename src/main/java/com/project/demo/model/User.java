package com.project.demo.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class User {

	//Variables statement
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String email;
	private String username;
	@Column(name = "password", nullable = false, length = 400)
	private String password;
	private String cellphone;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn (name = "user_type_id")
	private UserType userType;
	
	private Date changePassword;
	private int attempts;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn (name = "session_status_id")
	private SessionStatus sessionStatus;
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn (name = "user_availability_id")
	private UserAvailability userAvailability;
	
	@OneToOne(mappedBy = "user")
	private Authentication authentication;
	
	//Constructor
	public User() {
		super();
	}

	public User(String name, String email, String username, String password, String cellphone, UserType userType,
			Date changePassword, int attempts, SessionStatus sessionStatus, UserAvailability userAvailability) {
		super();
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
		this.cellphone = cellphone;
		this.userType = userType;
		this.changePassword = changePassword;
		this.attempts = attempts;
		this.sessionStatus = sessionStatus;
		this.userAvailability = userAvailability;
	}
	
	//Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public Date getChangePassword() {
		return changePassword;
	}

	public void setChangePassword(Date changePassword) {
		this.changePassword = changePassword;
	}

	public int getAttempts() {
		return attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	public SessionStatus getSessionStatus() {
		return sessionStatus;
	}

	public void setSessionStatus(SessionStatus sessionStatus) {
		this.sessionStatus = sessionStatus;
	}

	public UserAvailability getUserAvailability() {
		return userAvailability;
	}

	public void setUserAvailability(UserAvailability userAvailability) {
		this.userAvailability = userAvailability;
	}
	
}
