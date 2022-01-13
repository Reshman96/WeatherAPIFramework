package org.open_weather_DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.testing_framework.ConnectionManager;

import java.util.List;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

public class OpenWeatherDTO{

	@JsonProperty("visibility")
	private int visibility;

	@JsonProperty("timezone")
	private int timezone;

	@JsonProperty("main")
	private Main main;

	@JsonProperty("clouds")
	private Clouds clouds;

	@JsonProperty("sys")
	private Sys sys;

	@JsonProperty("dt")
	private int dt;

	@JsonProperty("coord")
	private Coord coord;

	@JsonProperty("weather")
	private List<WeatherItem> weather;

	@JsonProperty("name")
	private String name;

	@JsonProperty("cod")
	private int cod;

	@JsonProperty("id")
	private int id;

	@JsonProperty("base")
	private String base;

	@JsonProperty("wind")
	private Wind wind;

	@JsonProperty("snow")
	private Snow snow;

	@JsonInclude(NON_NULL)
	@JsonProperty("rain")
	private Rain rain;

	private Map<String, List<String>> headers = ConnectionManager.getHeadersMap();

	private int statusCode = ConnectionManager.getStatusCode();

	private String URL = ConnectionManager.getURL();

	private boolean[] fields;

	public int getVisibility(){
		return visibility;
	}

	public int getTimezone(){
		return timezone;
	}

	public Main getMain(){
		return main;
	}

	public Clouds getClouds(){
		return clouds;
	}

	public Sys getSys(){
		return sys;
	}

	public int getDt(){
		return dt;
	}

	public Coord getCoord(){
		return coord;
	}

	public List<WeatherItem> getWeather(){
		return weather;
	}

	public String getName(){
		return name;
	}

	public int getCod(){
		return cod;
	}

	public int getId(){
		return id;
	}

	public String getBase(){
		return base;
	}

	public Wind getWind(){
		return wind;
	}

	public Snow getSnow() {return snow;}

	public Rain getRain() {
		return rain;
	}

	public Map<String, List<String>> getHeaders(){
		return headers;
	}

	public int getStatusCode(){
		return statusCode;
	}

	public String getURL(){
		return URL;
	}

	public boolean[] getFields(){
		boolean[] fields = new boolean[4];
		if(getClouds() != null) fields[0] = true;
		if(getRain() != null) fields[1] = true;
		if(getSnow() != null) fields[2] = true;
		if(getWind() != null) fields[3] = true;
		return fields;
	}
}