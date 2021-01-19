package com.cts.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cts.demo.model.Location;
import com.netflix.discovery.converters.Auto;

@RestController
public class LocationResource {

	@Autowired
	private RestTemplate restTemplate;
	@GetMapping("/locations")
	public List<Location> getLocations(){
		
		Location[] locations=
				restTemplate.getForObject("http://localhost:56351/api/locations",Location[].class);
		
		return Arrays.asList(locations);
	}
	
	@GetMapping("/locations/{id}")
	public Location getLocationById(@PathVariable int id){
		
		Location location=restTemplate.
				getForObject("http://localhost:56351/api/locations/"+id, Location.class);
		return location;
	}
}
