package org.open_weather_DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.testing_framework.ConnectionManager;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class OpenWeatherDTO{

	@JsonProperty("visibility")
	private Integer visibility;

	@JsonProperty("timezone")
	private Integer timezone;

	@JsonProperty("main")
	private Main main;

	@JsonInclude(NON_NULL)
	@JsonProperty("clouds")
	private Clouds clouds;

	@JsonProperty("sys")
	private Sys sys;

	@JsonProperty("dt")
	private Integer dt;

	@JsonProperty("coord")
	private Coord coord;

	@JsonProperty("weather")
	private List<WeatherItem> weather;

	@JsonProperty("name")
	private String name;

	@JsonProperty("cod")
	private Integer cod;

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("base")
	private String base;

	@JsonInclude(NON_NULL)
	@JsonProperty("wind")
	private Wind wind;

	@JsonInclude(NON_NULL)
	@JsonProperty("snow")
	private Snow snow;

	@JsonInclude(NON_NULL)
	@JsonProperty("rain")
	private Rain rain;

	public Integer getVisibility(){
		return visibility;
	}

	public Integer getTimezone(){
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

	public Integer getDt(){
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

	public Integer getCod(){
		return cod;
	}

	public Integer getId(){
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

	public boolean baseIsStations(){return base.equals("stations");}

	public boolean visibilityWithinBounds(){return visibility >= 0 && visibility <= 20000;}

	public boolean dateTimeWithinBounds(){
		String epochString = dt + "000";
		long epochLong = Long.parseLong(epochString);
		Date date = new Date(epochLong);
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String formatted = format.format(date);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String test = LocalDate.now().format(formatter);

		if(test.equals(formatted)){
			return true;
		} else {
			return false;}
	}

	public boolean timeZoneWithinBounds(){return timezone >= -43200 && timezone <= 50400;}

	public boolean idWithinBounds(){return id.toString().length() ==7;}

	public boolean nameWithinBounds(){return name.length() > 0 && name.length() < 90;}

	public boolean codWithinBounds(){return cod == ConnectionManager.getStatusCode();}

}