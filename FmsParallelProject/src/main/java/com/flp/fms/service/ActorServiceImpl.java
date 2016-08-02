package com.flp.fms.service;
import com.flp.fms.domain.*;


import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.flp.fms.Exceptions.FieldEmptyException;
import com.flp.fms.Exceptions.NegativeFieldException;
import com.flp.fms.Exceptions.RecordNotFoundException;
import com.flp.fms.dao.ActorDaoImplForList;
import com.flp.fms.dao.IActorDao;
import com.flp.fms.dao.IFilmDao;

public class ActorServiceImpl implements IActorService {
	
	
	IActorDao actorDao;
	private List actorList;
	
	public ActorServiceImpl() 
	{
		
		actorDao=new ActorDaoImplForList();
	}
	
	public ActorServiceImpl(IActorDao actorDao)
	{
		this.actorDao=actorDao;
	}
	public Actor addActor(String firstName,String lastName) throws FieldEmptyException
	{
		if(firstName==null || lastName==null){
		
				throw new FieldEmptyException();
		}
	
		else{
		Actor actor=new Actor();
		actor.setFirstName(firstName);
		actor.setLastName(lastName);
		return actorDao.addActor(actor);
		}
		 
	}
	
	public String modifyActor(Map actorList)
	{
		Actor actor=actorDao.searchActor((Integer)actorList.get(1));
		if(actor!=null){
			actor.setFirstName((String)actorList.get(2));
			actor.setLastName((String)actorList.get(3));
			actorDao.modifyActor(actor);
			return "success";
			
		}
		else
			return null;
	}

 
	public boolean removeActor(int actorId) throws NegativeFieldException, FieldEmptyException{
		if(actorId==0)
		{
			throw new FieldEmptyException();
		}
		else if(actorId<0){
			throw new NegativeFieldException();
		}
		else
	 return actorDao.removeActor(actorId);
    }
	
	public Actor searchActor(int actorId) throws RecordNotFoundException, NegativeFieldException, FieldEmptyException{
		if(actorId==0)
		{
			throw new FieldEmptyException();
		}
		else if(actorId<0){
			throw new NegativeFieldException();
		}
		else if(actorDao.searchActor(actorId)!=null)
			return actorDao.searchActor(actorId);
		else 
			throw new RecordNotFoundException();
		
	}
 
	public List<Actor> getAllActors(){
		return actorDao.getAllActors();
		
	}
	
	
	

}
