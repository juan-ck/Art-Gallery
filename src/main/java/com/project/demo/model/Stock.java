package com.project.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="stock")
public class Stock {
	
	//Declaration of variables
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	
	/*@ManyToMany
	@JoinColumn (name="id")*/
	private int author;
	/*@ManyToOne
	@JoinColumn (name = "id")*/
	private int artworkType;
	/*@ManyToOne
	@JoinColumn (name = "id")*/
	private int artworkCategory;
	
	private int value;
	
	public Stock() {
		super();
	}

	public Stock(String name, int author, int artworkType, int artworkCategory, int value) {
		super();
		this.name = name;
		this.author = author;
		this.artworkType = artworkType;
		this.artworkCategory = artworkCategory;
		this.value = value;
	}

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

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public int getArtworkType() {
		return artworkType;
	}

	public void setArtworkType(int artworkType) {
		this.artworkType = artworkType;
	}

	public int getArtworkCategory() {
		return artworkCategory;
	}

	public void setArtworkCategory(int artworkCategory) {
		this.artworkCategory = artworkCategory;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	//Constructor
	

	//Getters and Setters

}
