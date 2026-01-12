package com.zs.ipl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TeamDaoJdbcImpl implements TeamDao {

	@Override
	public void save(Team t) {
		String sql = "insert into teams values (?, ?, ?, ?)";
		
		try {
			Connection conn = null;	// get the connection
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, t.getTeamId());
			stmt.setString(2, t.getName());
			stmt.setString(3, t.getCity());
			stmt.setDouble(4, t.getBudget());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Optional<Team> find(int id) {
		String sql = "select * from teams where team_id=" + id;
		try {
			Connection conn = null;	// get the connection
			ResultSet rs = conn.createStatement().executeQuery(sql);
			if(rs.next()) {
				Team t = new Team();
				t.setTeamId(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setCity(rs.getString(3));
				t.setBudget(rs.getDouble(4));
				return Optional.of(t); 
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}

	@Override
	public List<Team> list() {
		String sql = "select * from teams";
		List<Team> teams = new ArrayList<Team>();
		
		try {
			Connection conn = null;	// get the connection
			ResultSet rs = conn.createStatement().executeQuery(sql);
			
			while(rs.next()) {
				Team t = new Team();
				t.setTeamId(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setCity(rs.getString(3));
				t.setBudget(rs.getDouble(4));
				teams.add(t);
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teams;
	}

	@Override
	public boolean delete(int id) {
		String sql = "delete from teams where team_id=" + id;
		
		try {
			Connection conn = null;	// get the connection
			if(conn.createStatement().executeUpdate(sql) > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
