package com.ibm.repo;

import java.util.List;

import com.ibm.entity.Flight;

public interface FlightRepo {
	String save(Flight f);
	
	Flight fetch(String code);
	
	List<Flight> fetchAll();
	
	boolean remove(String code);
	
	boolean update(Flight f);
	
	List<Flight> findbyCarrier(String carrier);
	
}
