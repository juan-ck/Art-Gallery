package com.project.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="artwork")
public class Artwork {

	//Declaration of variables
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String picture;
	private String description;
	private int value;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn (name="author_id")
	private List<Author> author;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn (name = "artwork_category_id")
	private ArtworkCategory artworkCategory;
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn (name = "artwork_type_id")
	private ArtworkType artworkType;
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn (name = "artwork_availability_id")
	private ArtworkAvailability artworkAvailability;
	
	@OneToOne(mappedBy = "artwork")
	private Billing billing;
	
	
	//Constructor
	public Artwork() {
		super();
	}
	public Artwork(String name, String picture, String description, int value, List<Author> author, ArtworkType artworkType,
			ArtworkCategory artworkCategory, ArtworkAvailability artworkAvailability) {
		super();
		this.name = name;
		this.picture = picture;
		this.description = description;
		this.value = value;
		this.author = author;
		this.artworkType = artworkType;
		this.artworkCategory = artworkCategory;
		this.artworkAvailability = artworkAvailability;
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
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public List<Author> getAuthor() {
		return author;
	}
	public void setAuthor(List<Author> author) {
		this.author = author;
	}
	public ArtworkType getArtworkType() {
		return artworkType;
	}
	public void setArtworkType(ArtworkType artworkType) {
		this.artworkType = artworkType;
	}
	public ArtworkCategory getArtworkCategory() {
		return artworkCategory;
	}
	public void setArtworkCategory(ArtworkCategory artworkCategory) {
		this.artworkCategory = artworkCategory;
	}
	public ArtworkAvailability getArtworkAvailability() {
		return artworkAvailability;
	}
	public void setArtworkAvailability(ArtworkAvailability artworkAvailability) {
		this.artworkAvailability = artworkAvailability;
	}
}
