package com.example.demo.model.request;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/*@Getter
@Setter
@Builder
@JsonIgnoreProperties*/
public class DChartDTO {
    private Integer year;
    private Integer month;
    private Integer date;
    private Integer hours;
    private Integer minutes;
    private Integer seconds;
    private Float latitude;
    private Float longitude;
    private Float timezone;
    private PlanetsConfig config;

    public Integer getSeconds() {
        return seconds;
    }

    public void setSeconds(Integer seconds) {
        this.seconds = seconds;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getTimezone() {
        return timezone;
    }

    public void setTimezone(Float timezone) {
        this.timezone = timezone;
    }

    public PlanetsConfig getConfig() {
        return config;
    }

    public void setConfig(PlanetsConfig config) {
        this.config = config;
    }
}
