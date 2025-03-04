package com.example.demo.mapper;

import com.example.demo.entity.PlanetApiResponse;
import com.example.demo.model.request.PlanetsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PlanetMapper {

    PlanetMapper INSTANCE = Mappers.getMapper(PlanetMapper.class);

    @Mapping(source = "year", target = "input.year")
    @Mapping(source = "month", target = "input.month")
    @Mapping(source = "date", target = "input.date")
    @Mapping(source = "hours", target = "input.hours")
    @Mapping(source = "minutes", target = "input.minutes")
    @Mapping(source = "latitude", target = "input.latitude")
    @Mapping(source = "longitude", target = "input.longitude")
    @Mapping(source = "timezone", target = "input.timezone")
    PlanetApiResponse toPlanetApiResponse(PlanetsDTO planetsDTO);
}