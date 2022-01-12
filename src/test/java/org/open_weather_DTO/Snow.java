package org.open_weather_DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Snow{

	@JsonProperty("snow")
	private Snow snow;

	@JsonProperty("1h")
	private Double jsonMember1h;

	public Snow getSnow(){
		return snow;
	}

	public Double getJsonMember1h(){
		return jsonMember1h;
	}

	@Override
 	public String toString(){
		return 
			"Snow{" + 
			"snow = '" + snow + '\'' + 
			",1h = '" + jsonMember1h + '\'' + 
			"}";
		}
}