package com.airline.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;
@Document(collection="airline")
@Component

public class Airline {
	@Id
	Integer AirlineId;
	String name;
	
	public Airline(Integer airlineId, String name) {
		super();
		AirlineId = airlineId;
		this.name = name;
	}

	public Airline() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Integer getAirlineId() {
		return AirlineId;
	}

	public void setAirlineId(Integer airlineId) {
		AirlineId = airlineId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	@Override
	public String toString() {
		return "Airline [AirlineId=" + AirlineId + ", name=" + name + "]";
	}

	public Airline orElseThrow(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	

}

