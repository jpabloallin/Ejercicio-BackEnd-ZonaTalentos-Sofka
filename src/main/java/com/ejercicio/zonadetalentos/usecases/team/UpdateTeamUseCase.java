package com.ejercicio.zonadetalentos.usecases.team;

import com.ejercicio.zonadetalentos.mappers.TeamMapper;
import com.ejercicio.zonadetalentos.models.TeamDTO;
import com.ejercicio.zonadetalentos.repositories.ITeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class UpdateTeamUseCase {

    private final ITeamRepository teamRepository;
    private final TeamMapper teamMapper;

    public Mono<TeamDTO> apply(TeamDTO teamDTO) {
        Objects.requireNonNull(teamDTO.getId());
        log.info("\n***** Team updated. Id: {} *****\n", teamDTO.getId());
        return teamRepository.save(teamMapper.convertDtoToEntity().apply(teamDTO))
                .map(team-> teamMapper.convertEntityToDto().apply(team));
    }
}
