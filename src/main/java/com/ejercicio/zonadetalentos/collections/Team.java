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
@Document(collection = "team")

public class Team {
    @Id
    private String id;
    private String name;
    @Indexed(unique = true)
    private String code;
    private String country;
}
