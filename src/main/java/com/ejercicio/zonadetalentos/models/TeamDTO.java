package com.ejercicio.zonadetalentos.models;

import lombok.*;

import javax.validation.constraints.NotEmpty;

import static com.ejercicio.zonadetalentos.config.RandomAlphanumeric.randomAlphanumericNumber;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TeamDTO {

    private String id;
    @NotEmpty(message = "Team´s name must not be empty")
    private String name;
    private String code = randomAlphanumericNumber();
    @NotEmpty(message = "Country field must not be empty")
    private String country;
}
