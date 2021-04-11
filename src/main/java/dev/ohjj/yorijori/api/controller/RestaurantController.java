package dev.ohjj.yorijori.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.ohjj.yorijori.api.controller.request.Restaurant;
import dev.ohjj.yorijori.api.restaurant.RestaurantService;
import dev.ohjj.yorijori.api.restaurant.dto.RestaurantDetail;
import dev.ohjj.yorijori.api.restaurant.dto.RestaurantFind;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurants")
public class RestaurantController {

	private final RestaurantService restaurantService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public long addRestaurantController(@RequestBody @Valid Restaurant.Create restaurantCreate) {
		return restaurantService.addRestaurant(restaurantCreate);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<RestaurantFind> getRestaurants() {
		return restaurantService.getRestaurants();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public RestaurantDetail getRestaurantDetail(@PathVariable Long id) {
		return restaurantService.getRestaurantDetail(id);
	}

	@GetMapping("/{id}/info")
	@ResponseStatus(HttpStatus.OK)
	public RestaurantDetail.Info getRestaurantDetailInfo(@PathVariable Long id) {
		return restaurantService.getRestaurantDetailInfo(id);
	}
}
