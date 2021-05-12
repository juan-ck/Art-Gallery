package com.project.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "author")
public class Author {
	
	//Variables statement
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	@Column (name = "number_of_artworks")
	private int numberOfArtworks;
	
	//Constructor
	
	public Author() {
		super();
	}
	
	public Author(String name, int numberOfArtworks) {
		super();
		this.name = name;
		this.numberOfArtworks = numberOfArtworks;
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

	public int getNumberOfArtworks() {
		return numberOfArtworks;
	}

	public void setNumberOfArtworks(int numberOfArtworks) {
		this.numberOfArtworks = numberOfArtworks;
	}
	
}
