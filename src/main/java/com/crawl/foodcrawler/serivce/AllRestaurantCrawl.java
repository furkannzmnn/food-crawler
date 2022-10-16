package com.crawl.foodcrawler.serivce;

import com.crawl.foodcrawler.dto.getir.all_restoran_response.Cuisine;
import com.crawl.foodcrawler.dto.getir.all_restoran_response.Product;
import com.crawl.foodcrawler.dto.getir.all_restoran_response.ProductCategory;
import com.crawl.foodcrawler.dto.getir.all_restoran_response.Root;
import com.crawl.foodcrawler.model.CategoryList;
import com.crawl.foodcrawler.repository.CategoryRepository;
import com.crawl.foodcrawler.serivce.html_crawl.RestoranIds;
import com.crawl.foodcrawler.util.RestoranDetailConnector;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AllRestaurantCrawl {

    static final Map<String,Map<String , ArrayList<Product>>> categoryWithProduct = new HashMap<>();
    private final List<String> categoryList = new ArrayList<>();
    private final ObjectMapper objectMapper;
    private final CategoryRepository categoryRepository;
    private final Logger LOGGER = LoggerFactory.getLogger(AllRestaurantCrawl.class);


    @Cacheable("allRestaurants")
    public Map<String,Map<String , ArrayList<Product>>> crawl() {
        final List<String> restoranIds = RestoranIds.RESTORAN_IDS;
        restoranIds.forEach(id -> {
            try {
                if (!categoryWithProduct.containsKey(id)) {
                    final String detail = RestoranDetailConnector.detail(id);
                    final Root root = objectMapper.readValue(detail, Root.class);
                    if (root.data != null) {
                        if (root.data.restaurant != null && root.data.restaurant.cuisines != null) {
                            final ArrayList<ProductCategory> productCategories = root.data.productCategories;
                            root.data.productCategories.forEach(log -> {
                                if (!categoryList.contains(log.name)) {
                                    categoryList.add(log.name);
                                    final CategoryList build = CategoryList.builder().name(log.name).build();
                                    categoryRepository.save(build);
                                    productCategories
                                            .forEach(product -> categoryWithProduct.put(id, Map.of(product.name, product.products)));
                                }
                            });

                        }
                    }
                }
            } catch (IOException e) {
                //
            }
        });
        return categoryWithProduct;

    }
}
