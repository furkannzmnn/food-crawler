package com.crawl.foodcrawler.repository;

import com.crawl.foodcrawler.model.CategoryList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryList, Long> {
}
