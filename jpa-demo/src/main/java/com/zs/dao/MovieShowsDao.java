package com.zs.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.zs.entity.Movie;
import com.zs.entity.Multiplex;

public class MovieShowsDao {
	private EntityManagerFactory emf;
	
	public MovieShowsDao() {
		emf = Persistence.createEntityManagerFactory("MyJPA");
	}
	
	public boolean saveMultiplex(Multiplex mpex) {
		EntityManager mgr = emf.createEntityManager();
		EntityTransaction txn = mgr.getTransaction();
		
		try {
			txn.begin();
			mgr.persist(mpex);
			txn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			txn.rollback();
			return false;
		} finally {
			mgr.close();
		}
	}
	
	public boolean saveMovie(Movie mov) {
		EntityManager mgr = emf.createEntityManager();
		EntityTransaction txn = mgr.getTransaction();
		
		try {
			txn.begin();
			mgr.persist(mov);
			txn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			txn.rollback();
			return false;
		} finally {
			mgr.close();
		}
	}
	
	public boolean addMovieToMultiplex(int movId, int mpexId) {
		EntityManager mgr = emf.createEntityManager();
		EntityTransaction txn = mgr.getTransaction();
		
		try {
			txn.begin();
			Movie movie = mgr.find(Movie.class, movId);
			Multiplex mpex = mgr.find(Multiplex.class, mpexId);
			mpex.getMovies().add(movie);
			txn.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			txn.rollback();
			return false;
		} finally {
			mgr.close();
		}
	}
	
	public Multiplex findMultiplex(int mpexId) {
		EntityManager mgr = emf.createEntityManager();
		try {
			Multiplex mpex = mgr.find(Multiplex.class, mpexId);
			return mpex;
		} finally {
			mgr.close();
		}
	}
	
	public Movie findMovie(int movId) {
		EntityManager mgr = emf.createEntityManager();
		try {
			Movie movie = mgr.find(Movie.class, movId);
			return movie;
		} finally {
			mgr.close();
		}
	}
	
	public List<Movie> releaseBetween(LocalDate start, LocalDate end) {
		EntityManager mgr = emf.createEntityManager();
		try {
			Query query = mgr.createNamedQuery("releaseBetween");
			query.setParameter("start", start);
			query.setParameter("end", end);
			return query.getResultList();
		} finally {
			mgr.close();
		}
	}
}
