package com.sfgbrewery.inventoryfailover.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import org.springframework.web.reactive.function.server.RouterFunction;

@Configuration
public class RouterConfig {

	@Bean
	public RouterFunction inventoryRoute(InventoryHandler inventoryHandler) {
		return route(GET("/inventory-failover").and(accept(MediaType.APPLICATION_JSON)),
				inventoryHandler::listInventory);
	}

}
