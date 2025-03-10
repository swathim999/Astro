package com.example.demo.mapper;

import com.example.demo.entity.DChartRequest;
import com.example.demo.entity.PlanetRequest;
import com.example.demo.model.request.DChartDTO;
import com.example.demo.model.request.PlanetsDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-08T18:05:31+0530",
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

    @Override
    public DChartDTO getDChartRequest(DChartRequest request) {
        if ( request == null ) {
            return null;
        }

        DChartDTO dChartDTO = new DChartDTO();

        dChartDTO.setYear( dateOfBirthForYear( request.getDob() ) );
        dChartDTO.setMonth( dateOfBirthForMonth( request.getDob() ) );
        dChartDTO.setDate( dateOfBirthForDate( request.getDob() ) );

        return dChartDTO;
    }
}
