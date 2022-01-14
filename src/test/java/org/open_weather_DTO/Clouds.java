package org.open_weather_DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Clouds{

	@JsonProperty("all")
	private Integer all;

	public Integer getPercentage(){
		return all;
	}

	public boolean cloudPercentageWithinBounds(){return all >= 0 && all <= 100;}
}