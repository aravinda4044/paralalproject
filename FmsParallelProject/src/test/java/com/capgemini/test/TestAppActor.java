package com.capgemini.test;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.flp.fms.Exceptions.DuplicateRecordException;
import com.flp.fms.Exceptions.FieldEmptyException;
import com.flp.fms.Exceptions.NegativeFieldException;
import com.flp.fms.Exceptions.RecordNotFoundException;
import com.flp.fms.dao.IActorDao;
import com.flp.fms.domain.Actor;
import com.flp.fms.domain.Category;
import com.flp.fms.domain.Film;
import com.flp.fms.domain.Language;
import com.flp.fms.service.ActorServiceImpl;
import com.flp.fms.service.IActorService;



public class TestAppActor {
	
	
	@Mock
	IActorDao actorDao;
	
	IActorService actorService;

	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	@Before
	public void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);	
		actorService=new ActorServiceImpl(actorDao);
	}

	
	
	
	       
	
	
	
	//createActor must return valid with valid inputs
			@Test
			public void createActorWillReturnValidWithValidInputs() throws FieldEmptyException {
				
			
				
				Actor actor=new Actor();
		
				actor.setFirstName("xyz");
				actor.setLastName("zyx");

				Mockito.when(actorDao.addActor(actor)).thenReturn(actor);
				
				
				assertEquals(actor,actorService.addActor("xyz","zyx"));
			
			}
			
			
			
			
			
			
			
			//createActor must return null when any input is null
			
			@Test(expected=com.flp.fms.Exceptions.FieldEmptyException.class)
			public void createActorWillReturnNullWithNullInputs() throws FieldEmptyException, NegativeFieldException{
				String firstName=null;
				String lastName=null;
				actorService.addActor(firstName,lastName);
				
				
			}
			
			
			
			
			
			
			//removeActor must return valid when inputs are valid
			
			@Test
			public void removeFilmWillReturnValidWithValidInputs() throws FieldEmptyException, NegativeFieldException, RecordNotFoundException{
				
				Mockito.when(actorDao.removeActor(1)).thenReturn(true);
				
				assertEquals(true,actorService.removeActor(1));
			}
			
			
			
			
			//removeActor must return null with null inputs
			
			@Test(expected = com.flp.fms.Exceptions.FieldEmptyException.class)
			public void removeActorWillReturnNullWithIdZero() throws FieldEmptyException, NegativeFieldException, RecordNotFoundException{
				
				assertEquals(false,actorService.removeActor(0));
			}
			
			
			
			//removeActor must return null when record is not present
			
			@Test(expected = com.flp.fms.Exceptions.RecordNotFoundException.class)
			public void removeActorWillReturnNullWithNoRecord() throws FieldEmptyException, NegativeFieldException, RecordNotFoundException{
				Actor actor=new Actor();
				Mockito.when(actorService.searchActor(120)).thenReturn(null);
				assertEquals(false,actorService.removeActor(120));
			}
	
			
			
			
			

			//removeActor must return null with invalid inputs

			@Test(expected = com.flp.fms.Exceptions.NegativeFieldException.class)
			public void whenTheidIsZeroInRemoveActorThrowException() throws FieldEmptyException, NegativeFieldException, RecordNotFoundException
			{
				actorService.removeActor(-10);
			}
			
			
			//searchActor must return null with  null inputs
			
			@Test(expected = com.flp.fms.Exceptions.FieldEmptyException.class)
			public void whenTheidIsZeroInSearchActorThrowException() throws FieldEmptyException, NegativeFieldException, RecordNotFoundException
			{
				actorService.searchActor(0);
			}
			
			
			//searchActor must return null with  invalid inputs
			
			@Test(expected = com.flp.fms.Exceptions.NegativeFieldException.class)
					public void whenTheidIsNegativeInSearchActorThrowException() throws FieldEmptyException, NegativeFieldException, RecordNotFoundException
					{
						actorService.searchActor(-1);
					}
			
			
			
			
			//searchActor must return valid with  valid inputs
			
			@Test
			public void whenTheidIsValidInSearchActorItShouldReturnValid() throws FieldEmptyException, NegativeFieldException, RecordNotFoundException
			{
					Actor actor=new Actor();
					Mockito.when(actorDao.searchActor(2)).thenReturn(actor);
						
					assertEquals(actor,actorService.searchActor(2));
			}
			
			
			
			
			
			//searchActor must return null with  no record
			
			@Test(expected = com.flp.fms.Exceptions.RecordNotFoundException.class)
			public void whenTheidIsNotPresentInSearchActorThrowException() throws FieldEmptyException, NegativeFieldException, RecordNotFoundException
			{
				actorService.searchActor(121);
			}
			
			
			
}

