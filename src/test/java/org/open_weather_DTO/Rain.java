package org.open_weather_DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rain{

	@JsonProperty("rain")
	private Rain rain;

	@JsonProperty("1h")
	private Double jsonMember1h;

	public Rain getRain(){
		return rain;
	}

	public Double getJsonMember1h(){
		return jsonMember1h;
	}

	@Override
 	public String toString(){
		return 
			"Rain{" + 
			"rain = '" + rain + '\'' + 
			",1h = '" + jsonMember1h + '\'' + 
			"}";
		}

	public boolean rainWithinBounds() {
		return (jsonMember1h >= 0 && jsonMember1h <= 12000);
	}
}