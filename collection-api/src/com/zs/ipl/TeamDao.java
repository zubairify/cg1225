package com.zs.ipl;

import java.util.List;
import java.util.Optional;

public interface TeamDao {
	void save(Team t);
	Optional<Team> find(int id);
	List<Team> list();
	boolean delete(int id);
}
