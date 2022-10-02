package com.crawl.foodcrawler.repository;

import com.crawl.foodcrawler.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}
