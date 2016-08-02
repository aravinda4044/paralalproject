package com.flp.fms.view;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.persistence.EntityManager;
//import javax.persistence.TypedQuery;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.flp.fms.Exceptions.DuplicateRecordException;
import com.flp.fms.Exceptions.FieldEmptyException;
import com.flp.fms.Exceptions.NegativeFieldException;
import com.flp.fms.Exceptions.RecordNotFoundException;
import com.flp.fms.domain.*;

import com.flp.fms.service.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class UserInteraction  {


	IFilmService filmService;
	IActorService actorService;

	public UserInteraction()
	{
		filmService=new FilmServiceImpl();
		actorService=new ActorServiceImpl();
	}




	private static Scanner sc=new Scanner(System.in);

	public void addFilm() throws ParseException, FieldEmptyException, NegativeFieldException, DuplicateRecordException
	{

		Map<Integer,Object> filmList=new HashMap();

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		System.out.println("Enter title");
		filmList.put(1,sc.nextLine());

		System.out.println("Enter description");
		filmList.put(2,sc.nextLine());

		System.out.println("Enter release date");

		filmList.put(3,dateFormat.parse(sc.next()));

		System.out.println("Enter rental duration");
		filmList.put(4,sc.nextInt());

		System.out.println("Enter rental rate");
		filmList.put(5,sc.nextDouble());

		System.out.println("Enter length of the movie");
		filmList.put(6,sc.nextInt());

		System.out.println("Enter replacement cost");
		filmList.put(7,sc.nextDouble());

		System.out.println("Enter rating");
		filmList.put(8,sc.nextInt());

		System.out.println("Enter special features");
		filmList.put(9,sc.next());

		//Language language=new Language();
		System.out.println("Enter language name");
		filmList.put(10,sc.next());



		System.out.println("Enter category name");
		filmList.put(11,sc.next());
		int j=12;
		System.out.println("enter no of actors");
		int noofactors=sc.nextInt();
		for(int i=1;i<=noofactors;i++){
			Map<Integer,Object> actorDetails=new HashMap();
			System.out.println("Enter the actor first name");
			actorDetails.put(1,sc.next());
			System.out.println("Enter the actor last name");
			actorDetails.put(2,sc.next());
			filmList.put(j,actorDetails);
			j++;
		}
		System.out.println(filmService.addFilm(filmList));
	}


	public void modifyFilm() throws ParseException,IllegalArgumentException{


		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		Map<Integer,Object> newDetails=new HashMap();
		//List newDetails=new ArrayList();
		System.out.println("enter title");
		String titlePrevious=sc.next();
		System.out.println("enter releaseyear ");
		Date releaseYearprev=dateFormat.parse(sc.next());
		System.out.println("enter rating of the film to modify");
		Integer ratingPrevious=sc.nextInt();
		newDetails.put(1,titlePrevious);
		newDetails.put(2,releaseYearprev);
		newDetails.put(3,ratingPrevious);
		System.out.println("enter choice to modify 1.title 2.description 3.language 4.rental_duration 5.rental_rate 6.length 7.replacement_cost 8.rating 9.special_features 10.category");
		int choice=sc.nextInt();
		switch(choice){

		case 1:System.out.println("enter new title");
		String title=sc.next();
		newDetails.put(4, title);
		System.out.println(filmService.modifyFilm(newDetails));
		break;

		case 2:System.out.println("enter new description");
		String description=sc.next();
		newDetails.put(5, description);
		System.out.println(filmService.modifyFilm(newDetails));
		break;

		case 3:System.out.println("enter new language");
		String language=sc.next();
		newDetails.put(6, language);
		System.out.println(filmService.modifyFilm(newDetails));
		break;

		case 4:System.out.println("enter new rental_duration");
		int rentalDuration=sc.nextInt();
		newDetails.put(7, rentalDuration);
		System.out.println(filmService.modifyFilm(newDetails));
		break;
		case 5:System.out.println("enter new rental_rate");
		Double rentalRate=sc.nextDouble();
		newDetails.put(8, rentalRate);
		System.out.println(filmService.modifyFilm(newDetails));
		break;
		case 6:System.out.println("enter new length");
		int length=sc.nextInt();
		newDetails.put(9, length);
		System.out.println(filmService.modifyFilm(newDetails));
		break;

		case 7:System.out.println("enter new replacement cost");
		Double replacementCost=sc.nextDouble();
		newDetails.put(10, replacementCost);
		System.out.println(filmService.modifyFilm(newDetails));
		break;		


		case 8:System.out.println("enter new rating");
		Double rating=sc.nextDouble();
		newDetails.put(11, rating);
		System.out.println(filmService.modifyFilm(newDetails));
		break;


		case 9:System.out.println("enter new special features");
		String specialFeatures=sc.next();
		newDetails.put(12, specialFeatures);
		System.out.println(filmService.modifyFilm(newDetails));
		break;
		case 10:System.out.println("enter new Category");
		String category=sc.next();
		newDetails.put(13, category);
		System.out.println(filmService.modifyFilm(newDetails));
		break;
		}


	}



	public void removeFilm() throws FieldEmptyException, NegativeFieldException, RecordNotFoundException{
		System.out.println("enter id of the film to search");
		int filmId=sc.nextInt();
		if(filmService.removeFilm(filmId))
		{
			System.out.println("film Successfully removed");
		}
		else
		{
			System.out.println("film Not Found");
		}
	}
	public void searchFilm() throws FieldEmptyException, NegativeFieldException, RecordNotFoundException{
		System.out.println("enter id of the film to search");
		int filmId=sc.nextInt();
		Film film=filmService.searchFilm(filmId);
		if(film!=null)
			System.out.println("film found"+film);
		else
			System.out.println("not found");
	}
	public void getAllFilms(){
		List<Film> films=filmService.getAllFilms();
		System.out.println("All films details are "+films);

	}
	public Actor addActor() throws FieldEmptyException{
		Actor actor=new Actor();
		System.out.println("Enter the actor first name");
		String firstName=sc.next();
		System.out.println("Enter the actor last name");
		String lastName=sc.next();
		System.out.println("Actor added successfully");
		return actorService.addActor(firstName,lastName);
	}
	public void removeActor() throws NegativeFieldException, FieldEmptyException, RecordNotFoundException{
		System.out.println("enter id of the actor to search");
		int actorId=sc.nextInt();
		if(actorService.removeActor(actorId))
		{
			System.out.println("Actor Successfully removed");
		}
		else
		{
			System.out.println("Actor Not Found");
		}

	}

	public void searchActor() throws RecordNotFoundException, NegativeFieldException, FieldEmptyException{
		System.out.println("enter id of the film to search");
		int actorId=sc.nextInt();
		Actor actor=actorService.searchActor(actorId);
		if(actor!=null)
			System.out.println("actor found"+actor);
		else
			System.out.println("not found");
	}

	public void modifyActor(){
		Map<Integer,Object> actorList=new HashMap();

		System.out.println("enter id of the actor to modify");
		actorList.put(1,sc.nextInt());
		System.out.println("Enter firstname");
		actorList.put(2,sc.next());

		System.out.println("Enter  lastname");
		actorList.put(3,sc.next());

		System.out.println(actorService.modifyActor(actorList));

		//Actor actor=userinteraction.searchActorByName();
	}
	public void getAllActors(){
		List<Actor> actors=actorService.getAllActors();
		System.out.println("All films details are "+actors);

	}


}
