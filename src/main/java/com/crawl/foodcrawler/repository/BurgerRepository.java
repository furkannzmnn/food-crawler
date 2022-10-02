package com.crawl.foodcrawler.repository;

import com.crawl.foodcrawler.model.Burger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BurgerRepository extends JpaRepository<Burger, Long> {
}
