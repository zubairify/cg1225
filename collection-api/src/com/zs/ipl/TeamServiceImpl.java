package com.zs.ipl;

import java.util.List;

public class TeamServiceImpl implements TeamService {
	private TeamDao dao;
	
	public TeamServiceImpl(TeamDao dao) {
		this.dao = dao;
	}
	
	@Override
	public void add(Team t) {
		dao.save(t);
	}

	@Override
	public Team find(int id) throws InvalidTeamException {
//		Team t = dao.find(id);
//		if(t == null)
//			throw new InvalidTeamException("Team cannot be found with Id: " + id);
//		return t;
		return dao.find(id).orElseThrow(() ->
				new InvalidTeamException("Team cannot be found with Id: " + id));
	}

	@Override
	public List<Team> list() {
		return dao.list();
	}

	@Override
	public void remove(int id) throws InvalidTeamException {
		if(!dao.delete(id))
			throw new InvalidTeamException("Team cannot be found with Id: " + id);
	}
}
