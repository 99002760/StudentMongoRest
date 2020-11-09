package com.airline.dao;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.airline.exception.AirlineNotFoundException;
import com.airline.model.Airline;


@Repository
public interface  AirlineRepository extends MongoRepository<Airline,Integer>{
	Airline getAirlineById(Integer  airlineId) throws  AirlineNotFoundException;
	List< Airline> getAllAirlines()throws  AirlineNotFoundException;
	List< Airline>getByName(String name)throws  AirlineNotFoundException;
	

}


