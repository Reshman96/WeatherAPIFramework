package org.open_weather_DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeatherItem{

	@JsonProperty("icon")
	private String icon;

	@JsonProperty("description")
	private String description;

	@JsonProperty("main")
	private String main;

	@JsonProperty("id")
	private Integer id;

	public String getIcon(){
		return icon;
	}

	public String getDescription(){
		return description;
	}

	public String getMain(){
		return main;
	}

	public Integer getId(){
		return id;
	}

	public boolean weatherIconFollowsPattern() {
		return (icon.contains("d") || icon.contains("n"));
	}

	public boolean weatherDescriptionLessThanForty() {
		return (description.length() <= 40);
	}

	public boolean weatherMainIsValid() {
		List<String> list = new ArrayList<>(Arrays.asList("thunderstorm", "drizzle", "rain", "snow", "mist", "smoke", "haze", "dust", "fog", "sand", "ash", "squall", "tornado", "clear", "clouds"));
		return (list.contains(main.toLowerCase()));
	}

	public boolean weatherIDWithinBounds() {
		return (id >= 0 && id <= 1000);
	}
}