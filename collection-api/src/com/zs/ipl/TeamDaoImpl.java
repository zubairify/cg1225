package com.zs.ipl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TeamDaoImpl implements TeamDao {
	private List<Team> teams;

	public TeamDaoImpl() {
		teams = new ArrayList<Team>();
	}

	@Override
	public void save(Team t) {
		teams.add(t);
	}

	@Override
	public Optional<Team> find(int id) {
//		for (Team t : teams) {
//			if (t.getTeamId() == id)
//				return t;
//		}
//		return null;
		return teams.stream().filter(t -> t.getTeamId() == id).findFirst();
	}

	@Override
	public List<Team> list() {
		return teams;
	}

	@Override
	public boolean delete(int id) {
		Team t = find(id).get();
		return t != null ? teams.remove(t) : false;
	}
}




