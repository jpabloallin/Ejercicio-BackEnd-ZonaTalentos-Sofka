package com.ejercicio.zonadetalentos.models;

import com.ejercicio.zonadetalentos.collections.Team;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.*;

import static com.ejercicio.zonadetalentos.config.RandomNumber.randomCompetitorNumber;

@Data
public class CyclistDTO {

    private String id;
    @NotEmpty(message = "Cyclist's name must not be empty")
    private String name;
    @NotEmpty(message = "Competitor number must not be empty")
    @Min(1)
    @Max(999)
    private String competitorNumber = randomCompetitorNumber();
    private Team team;
    @NotEmpty(message = "Nationality must not be empty")
    private String nationality;
}
