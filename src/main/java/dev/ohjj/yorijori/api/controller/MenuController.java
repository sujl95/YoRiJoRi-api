package dev.ohjj.yorijori.api.controller;

import dev.ohjj.yorijori.api.controller.request.MenuRequest;
import dev.ohjj.yorijori.api.menu.category.MenuCategoryService;
import dev.ohjj.yorijori.api.menu.category.model.MenuCategory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/restaurant/{restaurantSeq}/menu")
public class MenuController {
    private final MenuCategoryService menuCategoryService;

    @GetMapping("/categories")
    public List<MenuCategory> getCategories(@PathVariable Long restaurantSeq) {
        return menuCategoryService.getMenuCategories(restaurantSeq);
    }

    @PostMapping("/category")
    @ResponseStatus(HttpStatus.CREATED)
    public long addMenuCategory(@PathVariable Long restaurantSeq, @RequestBody MenuRequest.CategoryCreationParam categoryCreationParam,
                                @RequestParam long userSeq) {
        return menuCategoryService.addMenuCategory(restaurantSeq, categoryCreationParam.getName(),
                categoryCreationParam.getExposed(), categoryCreationParam.getViewOrder(), userSeq);
    }
}
