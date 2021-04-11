package dev.ohjj.yorijori.api.restaurant.dto;

import java.time.LocalDateTime;

import dev.ohjj.yorijori.api.persistence.restaurant.entity.RestaurantEntity;
import dev.ohjj.yorijori.api.restaurant.model.OrderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@AllArgsConstructor
public class RestaurantDetail {

	private final Long seq;
	private final String name;
	private final Long minOrderPrice;
	private final OrderType orderType;
	private final Integer deliveryCost;
	private final String deliveryTime;

	public static RestaurantDetail toRestaurantDetail(RestaurantEntity restaurantEntity) {
		return RestaurantDetail.builder()
				.seq(restaurantEntity.getSeq())
				.name(restaurantEntity.getName())
				.minOrderPrice(restaurantEntity.getMinOrderPrice())
				.orderType(OrderType.findByOrderNum(restaurantEntity.getOrderType()))
				.deliveryCost(restaurantEntity.getDeliveryCost())
				.deliveryTime(restaurantEntity.getDeliveryTime())
				.build();

	}

	@Getter
	@Builder
	@AllArgsConstructor
	public static class Info {
		private final String info;
		private final Long ownerSeq;
		private final String businessName;
		private final String businessLicense;

		private final String openingTime;
		private final String holiday;
		private final String phone;

		private final Long addressSeq;
		private final String detailAddress;
		private final String originMark;

		public static Info toRestaurantInfo(RestaurantEntity restaurantEntity) {
			return Info.builder()
					.info(restaurantEntity.getInfo())
					.ownerSeq(restaurantEntity.getOwnerSeq())
					.businessName(restaurantEntity.getBusinessName())
					.openingTime(restaurantEntity.getOpeningTime())
					.holiday(restaurantEntity.getHoliday())
					.phone(restaurantEntity.getPhone())
					.addressSeq(restaurantEntity.getAddressSeq())
					.detailAddress(restaurantEntity.getDetailAddress())
					.originMark(restaurantEntity.getOriginMark())
					.build();
		}
	}



}
