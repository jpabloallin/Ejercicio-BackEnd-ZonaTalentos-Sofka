package com.ejercicio.zonadetalentos.routes.cyclist;

import com.ejercicio.zonadetalentos.models.CyclistDTO;
import com.ejercicio.zonadetalentos.models.TeamDTO;
import com.ejercicio.zonadetalentos.usecases.cyclist.UpdateCyclistUseCase;
import com.ejercicio.zonadetalentos.usecases.team.UpdateTeamUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class UpdateCyclistRouter {
    @Bean
    public RouterFunction<ServerResponse> modifyCyclistRouter(UpdateCyclistUseCase updateCyclistUseCase){
        return route(
                PUT("/api/v1/cyclist").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(CyclistDTO.class)
                        .flatMap(updateCyclistUseCase::apply)
                        .flatMap(dto -> ServerResponse.status(HttpStatus.OK)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(dto))
        );
    }
}
