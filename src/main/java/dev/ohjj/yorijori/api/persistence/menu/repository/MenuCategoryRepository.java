package dev.ohjj.yorijori.api.persistence.menu.repository;

import dev.ohjj.yorijori.api.persistence.menu.entity.MenuCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuCategoryRepository extends JpaRepository<MenuCategoryEntity, Long> {
    List<MenuCategoryEntity> findAllByRestaurantSeq(long restaurantSeq);
}
