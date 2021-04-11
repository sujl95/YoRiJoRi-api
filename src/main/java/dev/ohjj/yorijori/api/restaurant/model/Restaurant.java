package dev.ohjj.yorijori.api.restaurant.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Restaurant {

	private final Long seq;
	private final Long ownerSeq;
	private final Long addressSeq;
	private final Long imageSeq;
	private final String name;
	private final String businessName;
	private final String businessLicense;
	private final Long minOrderPrice;
	private final OrderType orderType;
	private final Integer deliveryCost;
	private final String shopCategory;
	private final String detailAddress;
	private final LocalDateTime regDate;
	private final LocalDateTime modDate;
	private final String holiday;
	private final String openingTime;
	private final String info;
	private final String phone;
	private final String originMark;
	private final String status;
	private final String deliveryTime;

	public static Restaurant from(Long seq, Long ownerSeq, Long addressSeq, Long imageSeq, String name, String businessName,
			String businessLicense, Long minOrderPrice, OrderType orderType, Integer deliveryCost,
			String shopCategory, String detailAddress, LocalDateTime regDate, LocalDateTime modDate,
			String holiday, String openingTime, String info, String phone, String originMark, String status,
			String deliveryTime) {
		return new Restaurant(seq, ownerSeq, addressSeq, imageSeq, name, businessName, businessLicense, minOrderPrice,
				orderType, deliveryCost, shopCategory, detailAddress, regDate, modDate, holiday, openingTime, info,
				phone, originMark, status, deliveryTime);
	}

}
