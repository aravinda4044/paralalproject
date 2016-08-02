package com.flp.fms.dao;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.flp.fms.Exceptions.RecordNotFoundException;
import com.flp.fms.domain.Category;
import com.flp.fms.domain.Film;
import com.flp.fms.domain.Language;


public interface IFilmDao {
	
	abstract  String addFilm(Film film);
	abstract String modifyFilm(Film film);
	abstract boolean removeFilm(int filmId) throws RecordNotFoundException;
	abstract  Film searchFilm(int filmId);
	abstract List<Film> getAllFilms();
	abstract Film SearchFilmByDetails(String title,Date release_year,Integer rating); 
	public Language findLanguagebyName(String string);
	public Category findCategoryByName(String string);

}
