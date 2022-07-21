package com.ejercicio.zonadetalentos.usecases.team;

import com.ejercicio.zonadetalentos.mappers.TeamMapper;
import com.ejercicio.zonadetalentos.models.TeamDTO;
import com.ejercicio.zonadetalentos.repositories.ITeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetTeamsUseCase implements Supplier<Flux<TeamDTO>> {

    private final ITeamRepository teamRepository;
    private final TeamMapper teamMapper;


    @Override
    public Flux<TeamDTO> get() {
        log.info("\n***** Getting all teams *****\n");
        return teamRepository
                .findAll()
                .map(team -> teamMapper
                        .convertEntityToDto()
                        .apply(team));
    }
}
