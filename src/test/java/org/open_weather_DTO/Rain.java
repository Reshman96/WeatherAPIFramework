package org.open_weather_DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rain{

	@JsonProperty("rain")
	private Rain rain;

	@JsonProperty("1h")
	private Double rainInMM;

	public Rain getRain(){
		return rain;
	}

	public Double getRainInMM(){
		return rainInMM;
	}

	@Override
 	public String toString(){
		return 
			"Rain{" + 
			"rain = '" + rain + '\'' + 
			",1h = '" + rainInMM + '\'' +
			"}";
		}

	public boolean rainWithinBounds() {
		return (rainInMM >= 0 && rainInMM <= 12000);
	}
}