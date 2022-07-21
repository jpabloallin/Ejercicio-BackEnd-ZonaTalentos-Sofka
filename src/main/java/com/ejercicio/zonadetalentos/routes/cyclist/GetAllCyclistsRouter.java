package com.ejercicio.zonadetalentos.routes.cyclist;

import com.ejercicio.zonadetalentos.models.CyclistDTO;
import com.ejercicio.zonadetalentos.models.TeamDTO;
import com.ejercicio.zonadetalentos.usecases.cyclist.GetCyclistsUseCase;
import com.ejercicio.zonadetalentos.usecases.team.GetTeamsUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetAllCyclistsRouter {
    @Bean
    public RouterFunction<ServerResponse> getCyclistsRouter(GetCyclistsUseCase getCyclistsUseCase){
        return route(
                GET("/api/v1/cyclist").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse
                        .status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(getCyclistsUseCase.get(), CyclistDTO.class))
        );
    }
}
