package org.open_weather_DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Wind{

	@JsonProperty("deg")
	private int deg;

	@JsonProperty("speed")
	private double speed;

	public int getDeg(){
		return deg;
	}

	public double getSpeed(){
		return speed;
	}
}