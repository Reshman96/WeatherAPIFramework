package org.open_weather_DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Wind{

	@JsonProperty("deg")
	private Integer deg;

	@JsonProperty("speed")
	private Double speed;

	@JsonProperty("gust")
	private Double gust;

	public Integer getDeg(){
		return deg;
	}

	public Double getSpeed(){
		return speed;
	}

	public Double getGust(){
		return gust;
	}

	public boolean windSpeedWithinBounds(String type) {
		if (type.equalsIgnoreCase("imperial")) {
			return (speed >= 0 && speed <= 231);
		} else {
			return (speed >= 0 && speed <= 105);
		}
	}

	public boolean windDegWithinBounds() {
		return (deg >= 0 && deg <= 360);
	}

	public boolean windGustWithinBounds(String type) {
		if (type.equalsIgnoreCase("imperial")) {
			return (gust >= 0 && gust <= 231);
		} else {
			return (gust >= 0 && gust <= 105);
		}
	}
}