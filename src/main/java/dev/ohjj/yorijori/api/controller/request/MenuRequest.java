package dev.ohjj.yorijori.api.controller.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MenuRequest {
    @Getter
    @Setter
    public static class CategoryCreationParam {
        private String name;
        private Boolean exposed;
        private Integer viewOrder;
    }
}
