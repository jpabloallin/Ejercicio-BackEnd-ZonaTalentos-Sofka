package com.ejercicio.zonadetalentos.routes.team;

import com.ejercicio.zonadetalentos.models.TeamDTO;
import com.ejercicio.zonadetalentos.usecases.team.CreateTeamUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PostTeamRouter {
    @Bean
    public RouterFunction<ServerResponse> createTeamRouter(CreateTeamUseCase createTeamUseCase){
        return route(
                POST("/api/v1/team").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(TeamDTO.class)
                        .flatMap(createTeamUseCase::apply)
                        .flatMap(teamDTO -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(teamDTO)).onErrorResume(e -> Mono.just("Error: " + e.getMessage())
                                .flatMap(s -> ServerResponse
                                        .status(HttpStatus.BAD_REQUEST)
                                        .contentType(MediaType.TEXT_PLAIN)
                                        .bodyValue(s))));
    }
}
