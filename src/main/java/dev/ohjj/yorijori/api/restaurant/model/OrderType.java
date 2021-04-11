package dev.ohjj.yorijori.api.restaurant.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderType {
	DELIVERY(0, "배달"), PACKAGE(1, "포장"),
	DELIVERY_AND_PACKAGE(2, "배달 및 포장");

	private final int orderTypeNum;
	private final String orderType;

	public static OrderType findByOrderNum(int orderTypeNum) {
		switch (orderTypeNum) {
			case 0:
				return OrderType.DELIVERY;
			case 1:
				return OrderType.PACKAGE;
			case 2:
				return OrderType.DELIVERY_AND_PACKAGE;
			default:
				throw new IllegalStateException("Unexpected value: " + orderTypeNum);
		}
	}

}