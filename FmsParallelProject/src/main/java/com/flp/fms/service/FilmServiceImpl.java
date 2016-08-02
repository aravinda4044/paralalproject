package com.flp.fms.service;
import com.flp.fms.domain.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.flp.fms.domain.*;
import com.flp.fms.Exceptions.DuplicateRecordException;
import com.flp.fms.Exceptions.FieldEmptyException;

import com.flp.fms.Exceptions.NegativeFieldException;
import com.flp.fms.Exceptions.RecordNotFoundException;
import com.flp.fms.dao.FilmDaoImplForList;
import com.flp.fms.dao.IFilmDao;

public class FilmServiceImpl implements IFilmService {


	IFilmDao filmDao;

	public FilmServiceImpl() 
	{

		filmDao=new FilmDaoImplForList();
	}
	public FilmServiceImpl(IFilmDao filmDao)
	{
		this.filmDao=filmDao;
	}
	public String addFilm(Map filmList) throws ParseException,  FieldEmptyException, NegativeFieldException, DuplicateRecordException{
		Film film=new Film();
		Set<Integer> keys=filmList.keySet();

		for(Integer key:keys)
		{

			if((((filmList.get(key)).getClass()).equals(Integer.class))  && (((Integer)filmList.get(key)) < 0))
			{
				throw new NegativeFieldException();
			}
			else if((((filmList.get(key)).getClass()).equals(String.class))  && (((String)filmList.get(key)).equals("") || (((String)filmList.get(key)).equals("null"))))
			{
				throw new FieldEmptyException();
			}
		}

		film.setTitle((String) filmList.get(1));
		film.setDescription((String) filmList.get(2));
		film.setReleaseYear((Date) filmList.get(3));

		/*if(getAllFilms().contains(film))
		{
			throw new DuplicateRecordException();
		}*/
		film.setRentalDuration((Integer) filmList.get(4));
		film.setRentalRate((Double) filmList.get(5));
		film.setLength((Integer) filmList.get(6));
		film.setReplacementCost((Double) filmList.get(7));
		film.setRating((Integer) filmList.get(8));
		film.setSpecialFeatures((String) filmList.get(9));

		Language language=filmDao.findLanguagebyName((String) filmList.get(10));
		if(language==null)
		{
			Language temp=new Language();
			temp.setName((String) filmList.get(10));
			film.setLanguage(temp);
		}
		else{
			film.setLanguage(language);
		}		



		Category category=filmDao.findCategoryByName((String) filmList.get(11));
		if(category==null)
		{
			Category temp=new Category();
			temp.setName((String) filmList.get(10));
			film.setCategory(temp);
		}
		else{
			film.setCategory(category);
		}		










		for(int i=12;i<filmList.size()+1;i++)
		{
			Actor actor=new Actor();
			Map<Integer,Object> actorDetails=(Map) filmList.get(i);
			actor.setFirstName((String) actorDetails.get(1));
			actor.setLastName((String) actorDetails.get(2));
			film.getActors().add(actor);
		}

		return filmDao.addFilm(film);

	}

	public String modifyFilm(Map filmList)
	{



		Film film=filmDao.SearchFilmByDetails(((String)filmList.get(1)),((Date) filmList.get(2)),((Integer)filmList.get(3)));
		if(film!=null){
			if(filmList.get(4)!=null){
				film.setTitle((String)filmList.get(4));
				return filmDao.modifyFilm(film);
			}
			else if(filmList.get(5)!=null){
				film.setDescription((String)filmList.get(5));
				return filmDao.modifyFilm(film);
			}
			else if(filmList.get(6)!=null){
				Language language=new Language();
				language.setName((String)filmList.get(6));
				film.setLanguage(language);
				return filmDao.modifyFilm(film);
			}
			else if(filmList.get(7)!=null){
				film.setRentalDuration(((Integer)filmList.get(7)));
				return filmDao.modifyFilm(film);
			}
			else if(filmList.get(8)!=null){
				film.setRentalRate(((Double)filmList.get(8)));
				return filmDao.modifyFilm(film);
			}
			else if(filmList.get(9)!=null){
				film.setLength((((Integer)filmList.get(9))));
				return filmDao.modifyFilm(film);
			}
			else if(filmList.get(10)!=null){
				film.setReplacementCost((((Double)filmList.get(10))));
				return filmDao.modifyFilm(film);
			}
			else if(filmList.get(11)!=null){
				film.setRating((Integer)filmList.get(11));
				return filmDao.modifyFilm(film);
			}
			else if(filmList.get(12)!=null){
				film.setSpecialFeatures(((String)filmList.get(12)));
				return filmDao.modifyFilm(film);
			}
			else if(filmList.get(13)!=null){
				Category category=new Category();
				category.setName((String)filmList.get(13));
				film.setCategory(category);
				return filmDao.modifyFilm(film);
			}
			else
				return null;

		}
		return null;



	}


	public boolean removeFilm(int filmId) throws FieldEmptyException,NegativeFieldException, RecordNotFoundException{
		if(filmId==0)
		{
			throw new FieldEmptyException();
		}
		else if(filmId<0){
			throw new NegativeFieldException();
		}
		else
			return filmDao.removeFilm(filmId);
	}

	public Film searchFilm(int filmId) throws FieldEmptyException, NegativeFieldException, RecordNotFoundException{
		if(filmId==0)
		{
			throw new FieldEmptyException();
		}
		else if(filmId<0){
			throw new NegativeFieldException();
		}
		else if(filmDao.searchFilm(filmId)!=null)
			return filmDao.searchFilm(filmId);
		else 
			throw new RecordNotFoundException();
	}

	public List<Film> getAllFilms(){
		return filmDao.getAllFilms();

	}

}
