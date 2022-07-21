package com.ejercicio.zonadetalentos.models;

import com.ejercicio.zonadetalentos.collections.Team;
import lombok.*;

import javax.validation.constraints.NotEmpty;

import static com.ejercicio.zonadetalentos.config.RandomNumber.randomCompetitorNumber;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CyclistDTO {

    private String id;
    @NotEmpty(message = "Cyclist's name must not be empty")
    private String name;
    @NotEmpty(message = "Cyclist's name must not be empty")
    private String competitorNumber = randomCompetitorNumber();
    private Team team;
    @NotEmpty(message = "Nationality must not be empty")
    private String nationality;
}
