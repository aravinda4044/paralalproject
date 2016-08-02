package com.flp.fms.dao;



import java.util.List;

import com.flp.fms.domain.Actor;

public interface IActorDao {
	
	abstract  Actor addActor(Actor actor);
	abstract  boolean modifyActor(Actor actor);
	abstract boolean removeActor(int actorId);
	abstract  Actor searchActor(int actorId);
	abstract List<Actor> getAllActors();

}
