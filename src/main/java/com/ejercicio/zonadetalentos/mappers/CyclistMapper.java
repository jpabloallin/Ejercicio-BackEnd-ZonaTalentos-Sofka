package com.ejercicio.zonadetalentos.mappers;

import com.ejercicio.zonadetalentos.collections.Cyclist;
import com.ejercicio.zonadetalentos.models.CyclistDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class CyclistMapper {

    private final ModelMapper modelMapper;

    public Function<Cyclist, CyclistDTO> convertEntityToDto() {
        return cyclist -> modelMapper.map(cyclist, CyclistDTO.class);
    }

    public Function<CyclistDTO, Cyclist> convertDtoToEntity(){
        return cyclistDTO -> modelMapper.map(cyclistDTO, Cyclist.class);
    }
}
