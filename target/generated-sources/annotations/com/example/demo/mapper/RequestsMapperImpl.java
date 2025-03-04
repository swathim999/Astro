package com.example.demo.mapper;

import com.example.demo.entity.PlanetRequest;
import com.example.demo.model.request.PlanetsDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-26T13:36:57+0530",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class RequestsMapperImpl implements RequestsMapper {

    @Override
    public PlanetsDTO getPlanetDTOData(PlanetRequest request) {
        if ( request == null ) {
            return null;
        }

        PlanetsDTO.PlanetsDTOBuilder planetsDTO = PlanetsDTO.builder();

        planetsDTO.year( dateOfBirthForYear( request.getDob() ) );
        planetsDTO.month( dateOfBirthForMonth( request.getDob() ) );
        planetsDTO.date( dateOfBirthForDate( request.getDob() ) );

        return planetsDTO.build();
    }
}
