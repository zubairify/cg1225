package com.zs.ipl;

import java.util.List;

public interface TeamService {
	void add(Team t);
	Team find(int id) throws InvalidTeamException;
	List<Team> list();
	void remove(int id) throws InvalidTeamException;
}
