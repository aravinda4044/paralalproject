package com.flp.fms.domain;


import java.util.Date;
import java.util.Set;

import javax.persistence.*;
@Entity
public class Language {
	
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable=false)
	private int languageId;
	
	private String name;
	
	@Column(insertable = false, updatable = true,nullable=true,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdate;
	
	
	@OneToMany(mappedBy="language")
	private Set<Film> films;
	
	public Language() {
		super();
	}
	public Language(String name) {
		super();
		this.name = name;
	}
	
	public int getLanguageId() {
		return languageId;
	}
	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public Set<Film> getFilms() {
		return films;
	}
	public void setFilms(Set<Film> films) {
		this.films = films;
	}
	@Override
	public String toString() {
		return "Language [languageId=" + languageId + ", name=" + name + ", lastUpdate=" + lastUpdate + "]";
	}
	
	
}
