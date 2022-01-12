package org.open_weather_DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Clouds{

	@JsonProperty("all")
	private int all;

	public int getAll(){
		return all;
	}
}