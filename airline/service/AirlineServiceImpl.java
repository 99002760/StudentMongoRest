package com.airline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airline.dao.AirlineRepository;
import com.airline.exception.AirlineNotFoundException;
import com.airline.model.Airline;

@Service
public class AirlineServiceImpl implements AirlineService {
	@Autowired
	AirlineRepository airlineRepository;

	@Override
	public Airline addAirline(Airline airline) {
		Airline newairline = airlineRepository.save(airline);
		return newairline;
	}
	@Override
	public boolean deleteAirline(Integer airlineId) throws AirlineNotFoundException {
		airlineRepository.deleteById(airlineId);
		return true;
	}

	@Override
	public Airline getAirlineById(Integer airlineId) throws AirlineNotFoundException {
		return airlineRepository.findById(airlineId)
				.orElseThrow(() -> new AirlineNotFoundException("ID not available"));
	}
	@Override
	public Airline updateAirline(Airline airline) {
		
		return airlineRepository.save(airline);
	}

	@Override
	public List<Airline> getAllAirlines() {
		// TODO Auto-generated method stub
		return airlineRepository.findAll();
	}

	@Override
	public List<Airline> getAirlineByName(String name) throws AirlineNotFoundException {
		List<Airline> airlineList = airlineRepository.getByName(name);
		if (airlineList.isEmpty()) {
			throw new AirlineNotFoundException("airline not available");
		}
		return airlineList;
	}

}
