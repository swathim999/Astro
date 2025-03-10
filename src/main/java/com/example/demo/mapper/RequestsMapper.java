package com.example.demo.mapper;

import com.example.demo.entity.DChartRequest;
import com.example.demo.entity.PlanetRequest;
import com.example.demo.model.request.DChartDTO;
import com.example.demo.model.request.PlanetsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RequestsMapper {
    RequestsMapper INSTANCE = Mappers.getMapper(RequestsMapper.class);

    @Mapping(target = "year", source = "dob", qualifiedByName = "dateOfBirthForYear")
    @Mapping(target = "month", source = "dob", qualifiedByName = "dateOfBirthForMonth")
    @Mapping(target = "date", source = "dob", qualifiedByName = "dateOfBirthForDate")
    PlanetsDTO getPlanetDTOData(PlanetRequest request);

    @Mapping(target = "year", source = "dob", qualifiedByName = "dateOfBirthForYear")
    @Mapping(target = "month", source = "dob", qualifiedByName = "dateOfBirthForMonth")
    @Mapping(target = "date", source = "dob", qualifiedByName = "dateOfBirthForDate")
    DChartDTO getDChartRequest(DChartRequest request);

    @Named("dateOfBirthForYear")
    default Integer dateOfBirthForYear(String dob) {
        String[] dobParts = dob.split("-");
        return Integer.parseInt(dobParts[2]);
    }
    @Named("dateOfBirthForMonth")
    default Integer dateOfBirthForMonth(String dob) {
        String[] dobParts = dob.split("-");
        return Integer.parseInt(dobParts[1]);
    }
    @Named("dateOfBirthForDate")
    default Integer dateOfBirthForDate(String dob) {
        String[] dobParts = dob.split("-");
        return Integer.parseInt(dobParts[0]);
    }
}
