package com.ejercicio.zonadetalentos.models;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import static com.ejercicio.zonadetalentos.config.RandomNumber.randomAlphanumericNumber;

@Data
public class TeamDTO {

    private String id;
    @NotEmpty(message = "Team´s name must not be empty")
    private String name;
    @NotEmpty(message = "Alphanumeric must not be empty")
    private String code = randomAlphanumericNumber();
    @NotEmpty(message = "Country field must not be empty")
    private String country;
}
