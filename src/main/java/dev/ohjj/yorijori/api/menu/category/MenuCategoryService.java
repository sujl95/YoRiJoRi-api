package dev.ohjj.yorijori.api.menu.category;

import dev.ohjj.yorijori.api.menu.category.model.MenuCategory;
import dev.ohjj.yorijori.api.persistence.menu.entity.MenuCategoryEntity;
import dev.ohjj.yorijori.api.persistence.menu.repository.MenuCategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class MenuCategoryService {
    private final MenuCategoryRepository menuCategoryRepository;

    public List<MenuCategory> getMenuCategories(long restaurantSeq) {
        return menuCategoryRepository.findAllByRestaurantSeq(restaurantSeq)
                .stream()
                .map(menuCategoryEntity -> MenuCategory.from(
                        menuCategoryEntity.getSeq(),
                        menuCategoryEntity.getRestaurantSeq(),
                        menuCategoryEntity.getName(),
                        menuCategoryEntity.getExposed(),
                        menuCategoryEntity.getViewOrder(),
                        menuCategoryEntity.getCreatedAt(),
                        menuCategoryEntity.getCreator(),
                        menuCategoryEntity.getModifiedAt(),
                        menuCategoryEntity.getModifier()
                ))
                .collect(Collectors.toList());
    }

    public long addMenuCategory(long restaurantSeq, String name, boolean exposed, int viewOrder, long userSeq) {
        // TODO: 2021-04-03 restaurantSeq 유효성 검사
        if (false) {
            throw new RuntimeException("");
        }

        final MenuCategoryEntity savedMenuCategoryEntity =
                menuCategoryRepository.saveAndFlush(MenuCategoryEntity.from(restaurantSeq, name, exposed, viewOrder, userSeq));

        return savedMenuCategoryEntity.getSeq();
    }
}
