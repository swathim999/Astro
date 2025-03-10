package com.example.demo.model.request;

import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@Getter
@Setter
@Builder
@JsonIgnoreProperties
public class D2ChartSettings implements Serializable {

    private String observation_point;
    private String ayanamsha;

    public String getObservation_point() {
        return observation_point;
    }

    public void setObservation_point(String observation_point) {
        this.observation_point = observation_point;
    }

    public String getAyanamsha() {
        return ayanamsha;
    }

    public void setAyanamsha(String ayanamsha) {
        this.ayanamsha = ayanamsha;
    }
}
