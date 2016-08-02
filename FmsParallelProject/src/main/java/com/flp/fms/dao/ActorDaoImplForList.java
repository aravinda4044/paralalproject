package com.flp.fms.dao;



import java.util.List;

import com.flp.fms.domain.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;



public class ActorDaoImplForList implements IActorDao {
	
	private EntityManager em;
	private EntityManagerFactory emf;
	
	public ActorDaoImplForList() {
		emf = Persistence.createEntityManagerFactory("hello");
		em = emf.createEntityManager();
	}
	
	
	public Actor addActor(Actor actor)
	{
		Actor actor1=findActorByName(actor.getFirstName(),actor.getLastName());
		if(actor1 == null)
		{
			em.getTransaction().begin();
			em.persist(actor);
			em.getTransaction().commit();
			return actor;
		}
		else
		{
			em.getTransaction().begin();
			em.persist(actor1);
			em.getTransaction().commit();
			return actor1;
		}
	}
	
	public boolean modifyActor(Actor actor)
	{
		em.getTransaction().begin();
		em.persist(actor);
		em.getTransaction().commit();
		return true;
		
	}

 
	public boolean removeActor(int actorId){
		Actor actor=searchActor(actorId);
		
		if(actor!=null)
		{
			em.getTransaction().begin();
			em.remove(actor);
			em.getTransaction().commit();
			return true;
		}
		else
			return false;
    }
	public Actor findActorByName(String first_name,String last_name){
		TypedQuery<Actor> query = em.createQuery("Select a from Actor a",Actor.class);

		for(Actor a:query.getResultList())
		{
			if(a.getFirstName().equals(first_name) && a.getLastName().equals(last_name))
			{
				return a;
			}
		}
		return null;
	}
	
	public Actor searchActor(int actorId){
		return em.find(Actor.class, actorId);
		
	}
 
	public List<Actor> getAllActors(){
		
		TypedQuery<Actor> query = em.createQuery("Select actor from Actor actor",Actor.class);
		return query.getResultList();
	}
	

	
	

}
