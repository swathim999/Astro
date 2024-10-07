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
public class PlanetsDTO implements Serializable {

    private Integer year;	//Integer	Year number, eg: 2023
    private Integer month; //	Integer	Month number,with no leading zero eg: 7 or 8
    private Integer date; //	Integer	Day number,with no leading zero eg: 5 or 6
    private Integer hours; //	Integer	hours number,with no leading zero eg: 1 or 2
    private Integer minutes; //	Integer	minutes number,with no leading zero eg: 0 or 1
    private Integer seconds; //	Integer	seconds number,with no leading zero eg: 0 or 1
    private Float latitude; //	float	latitude number, in the range from -90 to 90
    private Float longitude; //	float	longitude number, in the range from -180 to 180
    private Float timezone; //	float	Timezone of birth location, eg: 5.5
    private PlanetsConfig config;

}
