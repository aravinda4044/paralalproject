package com.flp.fms.domain;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
public class Film {




	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable=false)
	private int filmId;
	
	private String title;
	private String description;
	
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date releaseYear;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="languageId")
	private Language language;
	
	private int rentalDuration;
	private double rentalRate;
	private int length;
	private double replacementCost;
	private int rating;
	private String specialFeatures;
	
	@Column(nullable=true,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdate;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name = "filmActor", joinColumns = @JoinColumn(name = "filmId", referencedColumnName = "filmId") , inverseJoinColumns = @JoinColumn(name = "actorId", referencedColumnName = "actorId"))
	private Set<Actor> actors = new HashSet<Actor>();
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinTable(name = "filmCategory", joinColumns = @JoinColumn(name = "filmId", referencedColumnName = "filmId") , inverseJoinColumns = @JoinColumn(name = "categoryId", referencedColumnName = "categoryId"))
	private Category category;
	
	public Film() {
		
	}
	
	
	public int getFilmId() {
		return filmId;
	}
	public void setFilm_id(int filmId) {
		this.filmId = filmId;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public Date getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Date releaseYear) {
		this.releaseYear = releaseYear;
	}

	
	public Language getLanguage() {
		return language;
	}
	public void setLanguage(Language language) {
		this.language = language;
	}
	
	public int getRentalDuration() {
		return rentalDuration;
	}
	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}
	
	public double getRentalRate() {
		return rentalRate;
	}
	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
	public double getReplacementCost() {
		return replacementCost;
	}
	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}
	
	public double getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public String getSpecialFeatures() {
		return specialFeatures;
	}
	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}
	
	public Date getLastUpdate() {
		return lastUpdate;
	}




	public void setLast_update(Date last_update) {
		this.lastUpdate = lastUpdate;
	}


	public Set<Actor> getActors() {
		return actors;
	}


	
	public void setActors(Set<Actor> actors) {
		this.actors = actors;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	@Override
	public String toString() {
		return "Film [filmId=" + filmId + ", title=" + title + ", description=" + description + ", releaseYear="
				+ releaseYear + ", language=" + language + ", rentalDuration=" + rentalDuration + ", rentalRate="
				+ rentalRate + ", length=" + length + ", replacementCost=" + replacementCost + ", rating=" + rating
				+ ", specialFeatures=" + specialFeatures + ", lastUpdate=" + lastUpdate + ", actors=" + actors
				+ ", category=" + category + "]";
	}




	

	
	
}
