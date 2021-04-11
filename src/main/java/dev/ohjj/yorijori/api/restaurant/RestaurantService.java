package dev.ohjj.yorijori.api.restaurant;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.ohjj.yorijori.api.controller.request.Restaurant;
import dev.ohjj.yorijori.api.persistence.restaurant.entity.RestaurantEntity;
import dev.ohjj.yorijori.api.persistence.restaurant.repository.RestaurantRepository;
import dev.ohjj.yorijori.api.restaurant.dto.RestaurantDetail;
import dev.ohjj.yorijori.api.restaurant.dto.RestaurantFind;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RestaurantService {

	private final RestaurantRepository restaurantRepository;

	public long addRestaurant(Restaurant.Create restaurantCreate) {
		long ownerSeq = 1;
		long addressSeq = 1000010010;
		long imageSeq = 1;
		final RestaurantEntity restaurantEntity = restaurantRepository.saveAndFlush(
				RestaurantEntity.from(restaurantCreate, ownerSeq, addressSeq, imageSeq));
		return restaurantEntity.getSeq();
	}

	@Transactional(readOnly = true)
	public List<RestaurantFind> getRestaurants() {
		return restaurantRepository.findAll()
				.stream()
				.map(RestaurantFind::toRestaurantFind)
				.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public RestaurantDetail getRestaurantDetail(Long id) {
		final RestaurantEntity restaurantEntity = restaurantRepository.findById(id).orElseThrow(RuntimeException::new);
		return RestaurantDetail.toRestaurantDetail(restaurantEntity);
	}

	@Transactional(readOnly = true)
	public RestaurantDetail.Info getRestaurantDetailInfo(Long id) {
		final RestaurantEntity restaurantEntity = restaurantRepository.findById(id).orElseThrow(RuntimeException::new);
		return RestaurantDetail.Info.toRestaurantInfo(restaurantEntity);
	}
}
