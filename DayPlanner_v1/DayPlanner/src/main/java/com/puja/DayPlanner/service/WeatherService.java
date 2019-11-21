package com.puja.DayPlanner.service;

import com.puja.DayPlanner.model.Weather;

public interface WeatherService {
	
	public Weather getWeather(String country, String city); 
	

	
}

