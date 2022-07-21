package com.ejercicio.zonadetalentos.routes.cyclist;

import com.ejercicio.zonadetalentos.models.CyclistDTO;
import com.ejercicio.zonadetalentos.models.TeamDTO;
import com.ejercicio.zonadetalentos.usecases.cyclist.CreateCyclistUseCase;
import com.ejercicio.zonadetalentos.usecases.team.CreateTeamUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PostCyclistRouter {
    @Bean
    public RouterFunction<ServerResponse> createCyclistRouter(CreateCyclistUseCase createCyclistUseCase){
        return route(
                POST("/api/v1/cyclist").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(CyclistDTO.class)
                        .flatMap(createCyclistUseCase::apply)
                        .flatMap(cyclistDTO -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(cyclistDTO))
                        .onErrorResume(e -> Mono.just("Error: " + e.getMessage())
                                .flatMap(s -> ServerResponse
                                        .status(HttpStatus.BAD_REQUEST)
                                        .contentType(MediaType.TEXT_PLAIN)
                                        .bodyValue(s))));
    }
}
