package org.open_weather_DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Snow {

    @JsonProperty("snow")
    private Snow snow;

    @JsonProperty("1h")
    private Double snowInMM;

    public Snow getSnow() {
        return snow;
    }

    public Double getSnowInMM() {
        return snowInMM;
    }

    @Override
    public String toString() {
        return
                "Snow{" +
                        "snow = '" + snow + '\'' +
                        ",1h = '" + snowInMM + '\'' +
                        "}";
    }

	public boolean snowWithinBounds() {
		return (snowInMM >= 0 && snowInMM <= 30000);
	}
}