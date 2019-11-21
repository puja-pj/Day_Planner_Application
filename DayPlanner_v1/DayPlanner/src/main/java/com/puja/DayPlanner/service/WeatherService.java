package com.puja.DayPlanner.service;

import com.puja.DayPlanner.model.Weather;

public interface WeatherService {
	
	Weather getWeather(String country, String city); 
	

	
}

