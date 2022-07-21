package com.ejercicio.zonadetalentos.routes.cyclist;


import com.ejercicio.zonadetalentos.usecases.cyclist.DeleteCyclistByIdUseCase;
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
public class DeleteCyclistByIdRouter {
    @Bean
    public RouterFunction<ServerResponse> deleteCyclistRouter(DeleteCyclistByIdUseCase deleteCyclistByIdUseCase) {
        return route(DELETE("/api/v1/cyclist/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.status(HttpStatus.NO_CONTENT)
                        .body(BodyInserters.fromPublisher(deleteCyclistByIdUseCase.apply(request.pathVariable("id")), Void.class)));
    }
}
