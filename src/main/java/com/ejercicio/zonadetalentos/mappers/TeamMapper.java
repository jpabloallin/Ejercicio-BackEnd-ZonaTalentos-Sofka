package com.ejercicio.zonadetalentos.mappers;

import com.ejercicio.zonadetalentos.collections.Team;
import com.ejercicio.zonadetalentos.models.TeamDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class TeamMapper {

    private final ModelMapper modelMapper;

    public Function<Team, TeamDTO> convertEntityToDto() {
        return team -> modelMapper.map(team, TeamDTO.class);
    }

    public Function<TeamDTO, Team> convertDtoToEntity(){
        return teamDto -> modelMapper.map(teamDto, Team.class);
    }
}
