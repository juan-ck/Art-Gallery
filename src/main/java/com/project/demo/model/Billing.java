package com.project.demo.model;

import java.util.Date;

import javax.persistence.CascadeType;
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
@Table(name = "billing")
public class Billing {

	//Variables statement
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne
	@JoinColumn(name = "id")
	private Artwork artwork;
	
	private int finalSale;
	private Date date;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn (name = "user_id")
	private User user;
	
	//Constructor
	public Billing() {
		super();
	}

	public Billing(Artwork artwork, int finalSale, Date date) {
		super();
		this.artwork = artwork;
		this.finalSale = finalSale;
		this.date = date;
	}
	
	//Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Artwork getExhibition() {
		return artwork;
	}

	public void setExhibition(Artwork artwork) {
		this.artwork = artwork;
	}

	public int getFinalSale() {
		return finalSale;
	}

	public void setFinalSale(int finalSale) {
		this.finalSale = finalSale;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
