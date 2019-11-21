package com.puja.DayPlanner.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Weather {

	private int id;
	private String temp;
	private String icon;

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Weather() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@SuppressWarnings("unchecked")
	@JsonProperty("weather")
	private void idAndIconSetter(List<Map<String, Object>> weather) {
		Map<String, Object> weatherList = weather.get(0);
		// this.id = (String)weatherList.get("id");
		setIcon((String)weatherList.get("icon"));;
		setId((Integer) weatherList.get("id"));
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	@SuppressWarnings("unchecked")
	@JsonProperty("main")
	private void tempSetter(Map<String, String> main) {
		Double Temperature=(new Double(main.get("temp")))-273.15;
		Double celsiusTemperature = Math.round(Temperature * 100.0) / 100.0;
		setTemp((String.valueOf(celsiusTemperature)));
	}

}
