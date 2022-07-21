package com.ejercicio.zonadetalentos.routes.cyclist;

import com.ejercicio.zonadetalentos.models.CyclistDTO;
import com.ejercicio.zonadetalentos.usecases.cyclist.GetCyclistsByTeamCodeUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetAllCyclistByTeamCodeRouter {
    @Bean
    public RouterFunction<ServerResponse> getCyclistsByTeamCode(GetCyclistsByTeamCodeUseCase getCyclistsByTeamCodeUseCase) {
        return route(GET("/api/v1/cyclist/teamCode/{teamCode}"), request ->
                ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(getCyclistsByTeamCodeUseCase.get(request.pathVariable("teamCode")), CyclistDTO.class))
                        .onErrorResume(e -> Mono.just("Error: " + e.getMessage())
                                .flatMap(s -> ServerResponse.status(HttpStatus.BAD_REQUEST)
                                        .contentType(MediaType.TEXT_PLAIN).bodyValue(s))));
    }
}
