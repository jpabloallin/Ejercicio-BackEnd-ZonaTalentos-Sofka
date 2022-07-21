package com.ejercicio.zonadetalentos.routes.team;

import com.ejercicio.zonadetalentos.models.CyclistDTO;
import com.ejercicio.zonadetalentos.models.TeamDTO;
import com.ejercicio.zonadetalentos.usecases.cyclist.GetCyclistsByTeamCodeUseCase;
import com.ejercicio.zonadetalentos.usecases.team.GetAllTeamsByCountryUseCase;
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
public class GetAllTeamsByCountryRouter {
    @Bean
    public RouterFunction<ServerResponse> getTeamsByCountry(GetAllTeamsByCountryUseCase getAllTeamsByCountryUseCase) {
        return route(GET("/api/v1/team/country/{country}"), request ->
                ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(getAllTeamsByCountryUseCase.get(request.pathVariable("country")), TeamDTO.class))
                        .onErrorResume(e -> Mono.just("Error: " + e.getMessage())
                                .flatMap(s -> ServerResponse.status(HttpStatus.BAD_REQUEST)
                                        .contentType(MediaType.TEXT_PLAIN).bodyValue(s))));
    }
}
