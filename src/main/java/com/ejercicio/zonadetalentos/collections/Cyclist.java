package com.ejercicio.zonadetalentos.collections;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "cyclist")

public class Cyclist {
    @Id
    private String id;
    private String name;
    @Indexed(unique = true)
    private Integer competitorNumber;
    private Team team;
    private String nationality;
}
