package com.ibm.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ibm.entity.Flight;
import com.ibm.repo.FlightRepo;
import com.ibm.repo.FlightRepoImpl;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:appctx.xml")
public class TestRepo {
	@Autowired
	private FlightRepo repo;
	
	@Test
	public void testSave() {
		Flight f = new Flight("6E123","Mumbai","Banglore","Indigo");		
		assertNotNull(repo.save(f));
	}
	
	@Test
	public void testUpdate() {
		Flight f = new Flight("6E123","Mumbai","Delhi","Indigo");
		assertTrue(repo.update(f));
	}
	@Test
	public void testRemove() {
		assertTrue(repo.remove("6E123"));
	}
	@Test
	public void testFetch() {
		assertNotNull(repo.fetch("6E124"));
		System.out.println(repo.fetch("6E124"));
	}
	@Test
	public void testFetchAll() {
		List<Flight> flight = repo.fetchAll();
		assertNotNull(flight);
		flight.forEach(System.out::println);
	}
	@Test
	public void testFetchByCarrier() {
		List<Flight> flight = repo.findbyCarrier("Indigo");
		assertNotNull(flight);
		flight.forEach(System.out::println);

		
		
	}
}
