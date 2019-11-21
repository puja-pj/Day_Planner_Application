package com.puja.DayPlanner.service;



import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import com.puja.DayPlanner.model.Weather;



@Service
public class WeatherServiceImpl {
	

	//private static final String FORECAST_URL =
			//"http://api.openweathermap.org/data/2.5/forecast?q={city},{country}&APPID={key}";

	
	private final RestTemplate restTemplate;


	public WeatherServiceImpl(RestTemplateBuilder restTemplateBuilder)
			 {
		this.restTemplate = restTemplateBuilder.build();
	}

	
	public Weather getWeather(String country, String city) {
		  final String WEATHER_URL =
				"https://api.openweathermap.org/data/2.5/weather?q="+city+",canada,&appid=a8ffc615ad1fd8de3fffedaa85291be9";
	Weather result = restTemplate.getForObject(WEATHER_URL, Weather.class);
	return result;

	}

}
