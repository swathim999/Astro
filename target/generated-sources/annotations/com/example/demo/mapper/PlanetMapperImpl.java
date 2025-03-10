package com.example.demo.mapper;

import com.example.demo.entity.PlanetApiResponse;
import com.example.demo.entity.PlanetResponse;
import com.example.demo.model.request.PlanetsDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-08T18:05:07+0530",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class PlanetMapperImpl implements PlanetMapper {

    @Override
    public PlanetApiResponse toPlanetApiResponse(PlanetsDTO planetsDTO) {
        if ( planetsDTO == null ) {
            return null;
        }

        PlanetApiResponse planetApiResponse = new PlanetApiResponse();

        planetApiResponse.setInput( planetsDTOToPlanetResponse( planetsDTO ) );

        return planetApiResponse;
    }

    protected PlanetResponse planetsDTOToPlanetResponse(PlanetsDTO planetsDTO) {
        if ( planetsDTO == null ) {
            return null;
        }

        PlanetResponse planetResponse = new PlanetResponse();

        if ( planetsDTO.getYear() != null ) {
            planetResponse.setYear( planetsDTO.getYear() );
        }
        if ( planetsDTO.getMonth() != null ) {
            planetResponse.setMonth( planetsDTO.getMonth() );
        }
        if ( planetsDTO.getDate() != null ) {
            planetResponse.setDate( planetsDTO.getDate() );
        }
        if ( planetsDTO.getHours() != null ) {
            planetResponse.setHours( planetsDTO.getHours() );
        }
        if ( planetsDTO.getMinutes() != null ) {
            planetResponse.setMinutes( planetsDTO.getMinutes() );
        }
        if ( planetsDTO.getLatitude() != null ) {
            planetResponse.setLatitude( planetsDTO.getLatitude() );
        }
        if ( planetsDTO.getLongitude() != null ) {
            planetResponse.setLongitude( planetsDTO.getLongitude() );
        }
        if ( planetsDTO.getTimezone() != null ) {
            planetResponse.setTimezone( planetsDTO.getTimezone() );
        }

        return planetResponse;
    }
}
