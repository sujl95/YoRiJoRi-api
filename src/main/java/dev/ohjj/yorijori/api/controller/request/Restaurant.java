package dev.ohjj.yorijori.api.controller.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Restaurant {

	@Getter
	@Setter
	public static class Create {

		@NotBlank
		private String name;

		@NotBlank
		private String businessName;

		@Size(min = 10, max = 15)
		private String businessLicense;

		@Min(0)
		private Long minOrderPrice;

		@NotNull
		private int orderType;

		@Min(0)
		private Integer deliveryCost;

		@NotBlank
		private String shopCategory;

		@NotBlank
		private String detailAddress;

		@NotBlank
		private String holiday;

		@NotBlank
		private String openingTime;

		@NotBlank
		private String info;

		@NotBlank
		private String phone;

		private String originMark;

		@NotBlank
		private String status;

		@NotBlank
		private String deliveryTime;

	}

}
