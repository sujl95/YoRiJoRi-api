package dev.ohjj.yorijori.api.persistence.restaurant.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import dev.ohjj.yorijori.api.controller.request.Restaurant;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(
		name = "restaurant",
		indexes = @Index(name = "idx_restaurant_seq", columnList = "seq")
)
public class RestaurantEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq")
	private Long seq;

	@Column(name = "owner_seq", nullable = false)
	private Long ownerSeq;

	@Column(name = "address_seq", nullable = false)
	private Long addressSeq;

	@Column(name = "image_seq", nullable = false)
	private Long imageSeq;

	@Column(name = "name", nullable = false, length = 50)
	private String name;

	@Column(name = "business_name", nullable = false, length = 100)
	private String businessName;

	@Column(name = "business_license", nullable = false, length = 30)
	private String businessLicense;

	@Column(name = "min_order_price", nullable = false)
	private Long minOrderPrice;

	@Column(name = "order_type", nullable = false)
	private int orderType;

	@Column(name = "delevery_cost", nullable = false)
	private Integer deliveryCost;

	@Column(name = "shop_category", nullable = false)
	private String shopCategory;

	@Column(name = "detail_address", nullable = false)
	private String detailAddress;

	@CreationTimestamp
	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt;

	@CreationTimestamp
	@Column(name = "modified_at", nullable = false)
	private LocalDateTime modifiedAt;

	@Column(name = "holiday", nullable = false)
	private String holiday;

	@Column(name = "opening_time", nullable = false)
	private String openingTime;

	@Column(name = "info", nullable = false)
	private String info;

	@Column(name = "phone", nullable = false)
	private String phone;

	@Column(name = "origin_mark")
	private String originMark;

	@Column(name = "status")
	private String status;

	@Column(name = "delivery_time", nullable = false)
	private String deliveryTime;

	public RestaurantEntity(Restaurant.Create create, long ownerSeq, long addressSeq, long imageSeq) {
		this.ownerSeq = ownerSeq;
		this.addressSeq = addressSeq;
		this.imageSeq = imageSeq;
		name = create.getName();
		businessName = create.getBusinessName();
		businessLicense = create.getBusinessLicense();
		minOrderPrice = create.getMinOrderPrice();
		orderType = create.getOrderType();
		deliveryCost = create.getDeliveryCost();
		shopCategory = create.getShopCategory();
		detailAddress = create.getDetailAddress();
		holiday = create.getHoliday();
		openingTime = create.getOpeningTime();
		info = create.getInfo();
		phone = create.getPhone();
		originMark = create.getOriginMark();
		status = create.getStatus();
		deliveryTime = create.getDeliveryTime();
	}

	public static RestaurantEntity from(Restaurant.Create create, long ownerSeq, long addressSeq, long imageSeq) {
		return new RestaurantEntity(create, ownerSeq, addressSeq, imageSeq);
	}
}
