package com.ejercicio.zonadetalentos.models;

import com.ejercicio.zonadetalentos.collections.Team;
import lombok.*;

import javax.validation.constraints.NotEmpty;

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
    private Integer competitorNumber;

    private Team team;
    @NotEmpty(message = "Nationality must not be empty")
    private String nationality;
}
