package org.open_weather_DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Coord{

	@JsonProperty("lon")
	private Double lon;

	@JsonProperty("lat")
	private Double lat;

	public Double getLon(){
		return lon;
	}

	public Double getLat(){
		return lat;
	}

	public boolean lonWithinBounds(){return lon >= -180 && lon <= 180;}

	public boolean latWithinBounds(){return lat >= -90 && lat <= 90;}
}