package dev.ohjj.yorijori.api.restaurant.dto;

import dev.ohjj.yorijori.api.persistence.restaurant.entity.RestaurantEntity;
import dev.ohjj.yorijori.api.restaurant.model.OrderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantFind {

	private Long seq;
	private Long imageSeq;
	private String name;
	private Long minOrderPrice;
	private String orderType;
	private Integer deliveryCost;
	private String deliveryTime;
	private String status;

	public static RestaurantFind toRestaurantFind(RestaurantEntity restaurantEntity) {
		return RestaurantFind.builder()
				.seq(restaurantEntity.getSeq())
				.imageSeq(restaurantEntity.getImageSeq())
				.name(restaurantEntity.getName())
				.minOrderPrice(restaurantEntity.getMinOrderPrice())
				.orderType(OrderType.findByOrderNum(restaurantEntity.getOrderType()).getOrderType())
				.deliveryCost(restaurantEntity.getDeliveryCost())
				.deliveryTime(restaurantEntity.getDeliveryTime())
				.status(restaurantEntity.getStatus())
				.build();
	}

}
