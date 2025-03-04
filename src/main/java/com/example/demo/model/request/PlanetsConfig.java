package com.example.demo.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import java.io.Serializable;

@Getter
@Setter
@Builder
@JsonIgnoreProperties
public class PlanetsConfig implements Serializable {

    private String observation_point;	//String	Either "topocentric" or "geocentric"
    private String ayanamsha; //	String
}