package com.ejercicio.zonadetalentos.usecases.team;

import com.ejercicio.zonadetalentos.mappers.TeamMapper;
import com.ejercicio.zonadetalentos.models.TeamDTO;
import com.ejercicio.zonadetalentos.repositories.ITeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateTeamUseCase {

    private final ITeamRepository teamRepository;
    private final TeamMapper teamMapper;

    public Mono<TeamDTO> apply(TeamDTO teamDTO) {
        log.info("\n***** New team created. Id: {} *****\n", teamDTO.getId());
        return  teamRepository
                .save(teamMapper
                        .convertDtoToEntity()
                        .apply(teamDTO)).map(team -> teamMapper.convertEntityToDto()
                        .apply(team));
    }
}
