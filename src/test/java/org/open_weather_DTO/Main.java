package org.open_weather_DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Main{

	@JsonProperty("temp")
	private Double temp;

	@JsonProperty("temp_min")
	private Double tempMin;

	@JsonProperty("humidity")
	private Integer humidity;

	@JsonProperty("pressure")
	private Integer pressure;

	@JsonProperty("feels_like")
	private Double feelsLike;

	@JsonProperty("temp_max")
	private Double tempMax;

	@JsonProperty("sea_level")
	private Integer sea_level;

	@JsonProperty("grnd_level")
	private Integer ground_level;

	public Double getTemp(){
		return temp;
	}

	public Double getTempMin(){
		return tempMin;
	}

	public Integer getHumidity(){
		return humidity;
	}

	public Integer getPressure(){
		return pressure;
	}

	public Double getFeelsLike(){
		return feelsLike;
	}

	public Double getTempMax(){
		return tempMax;
	}

	private boolean tempBounds(String type){
		if (type.equalsIgnoreCase("imperial")){
			return temp >= -148 && temp <= 212;
		} else if(type.equalsIgnoreCase("metric")) {
			return temp >= -100 && temp <= 100;
		} else if(type.equalsIgnoreCase("")){
			return temp >= 173.15 && temp <= 373.15;
		}
		return false;
	}

	public boolean tempWithinBounds(String type){return tempBounds(type);}

	public boolean feelsLikeWithinBounds(String type){return tempBounds(type);}

	public boolean tempMaxLikeWithinBounds(String type){return tempBounds(type);}

	public boolean tempMinLikeWithinBounds(String type){return tempBounds(type);}

	public boolean seaLevelWithinBounds(){return pressureBounds(sea_level);}

	public boolean groundLevelWithinBounds(){return pressureBounds(ground_level);}

	public boolean humidityWithinBounds(){return humidity >= 0 && humidity <= 100;}

	public boolean pressureWithinBounds(){return pressureBounds(pressure);}

	private boolean pressureBounds(Integer methodName) {
		return methodName >= 750 && methodName <= 1250;
	}
}