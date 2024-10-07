package com.techspira.astroline.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PlanetsConfig implements Serializable {

    private String observation_point;	//String	Either "topocentric" or "geocentric"
    private String ayanamsha; //	String
}
