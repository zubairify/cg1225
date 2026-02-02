package com.zs.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.zs.dao.MovieShowsDao;
import com.zs.entity.Movie;
import com.zs.entity.Multiplex;

public class TestMovieShowsDao {
	private static MovieShowsDao dao;
	
	@BeforeAll
	public static void init() {
		dao = new MovieShowsDao();
	}
	
	@Test
	public void testSaveMultiplex() {
		Multiplex mpex = new Multiplex();
		mpex.setMpexId(12);
		mpex.setName("Inox");
		assertTrue(dao.saveMultiplex(mpex));
	}
	
	@Test
	public void testSaveMovie() {
		Movie mov = new Movie();
		mov.setMovId(103);
		mov.setTitle("Pathan");
		mov.setRelease(LocalDate.of(2024, 05, 22));
		assertTrue(dao.saveMovie(mov));
	}
	
	@Test
	public void testAddMovieToMultiplex() {
		assertTrue(dao.addMovieToMultiplex(103, 11));
	}
	
	@Test
	public void testReleaseBetween() {
		List<Movie> movies = 
			dao.releaseBetween(LocalDate.of(2024, 01, 01), LocalDate.of(2024, 12, 31));
		assertFalse(movies.isEmpty());
		movies.forEach(System.out::println);
	}
}
