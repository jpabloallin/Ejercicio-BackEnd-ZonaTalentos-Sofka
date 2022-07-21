package com.ejercicio.zonadetalentos.usecases.team;

import com.ejercicio.zonadetalentos.mappers.TeamMapper;
import com.ejercicio.zonadetalentos.models.CyclistDTO;
import com.ejercicio.zonadetalentos.models.TeamDTO;
import com.ejercicio.zonadetalentos.repositories.ITeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetAllTeamsByCountryUseCase {

    private final ITeamRepository teamRepository;
    private final TeamMapper teamMapper;

    public Flux<TeamDTO> get(String country) {
        log.info("\n***** Getting teams by country {} *****\n");
        return teamRepository
                .findByCountry(country)
                .filter(team -> Objects.equals(team.getCountry(), country))
                .map(entity -> teamMapper.convertEntityToDto().apply(entity));
    }
}
