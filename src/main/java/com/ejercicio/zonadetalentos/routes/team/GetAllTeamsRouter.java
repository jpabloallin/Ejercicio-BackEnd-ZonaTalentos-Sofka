package com.ejercicio.zonadetalentos.routes.team;

import com.ejercicio.zonadetalentos.models.TeamDTO;
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
public class GetAllTeamsRouter {
    @Bean
    public RouterFunction<ServerResponse> getTeamsRouter(GetTeamsUseCase getTeamsUseCase){
        return route(
                GET("/api/v1/team").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse
                        .status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(getTeamsUseCase.get(), TeamDTO.class))
        );
    }
}
