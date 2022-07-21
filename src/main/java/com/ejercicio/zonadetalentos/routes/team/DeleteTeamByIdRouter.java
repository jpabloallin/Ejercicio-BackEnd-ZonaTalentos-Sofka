package com.ejercicio.zonadetalentos.routes.team;

import com.ejercicio.zonadetalentos.usecases.team.DeleteTeamByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class DeleteTeamByIdRouter {

    @Bean
    public RouterFunction<ServerResponse> deleteTeamRouter(DeleteTeamByIdUseCase deleteTeamByIdUseCase) {
        return route(DELETE("/api/v1/team/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.status(HttpStatus.NO_CONTENT)
                        .body(BodyInserters.fromPublisher(deleteTeamByIdUseCase.apply(request.pathVariable("id")), Void.class)));
    }
}
