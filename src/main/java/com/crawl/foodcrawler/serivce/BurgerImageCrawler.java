package com.crawl.foodcrawler.serivce;

import com.crawl.foodcrawler.dto.getir.detail.Product;
import com.crawl.foodcrawler.dto.getir.detail.Root;
import com.crawl.foodcrawler.model.Burger;
import com.crawl.foodcrawler.repository.BurgerRepository;
import com.crawl.foodcrawler.util.CategoryFilterConnector;
import com.crawl.foodcrawler.util.FoodDetailConnector;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

@Component
@RequiredArgsConstructor
public class BurgerImageCrawler {

    private final BurgerRepository burgerRepository;
    private final ObjectMapper objectMapper;
    private final ScheduledExecutorService scheduledExecutorService;

    public void crawlImage() throws IOException {
        final Product product = getProduct();

        final Burger burger = Burger.builder()
                .imageURL(product.imageURL)
                .fullScreenImageURL(product.fullScreenImageURL)
                .description(product.description)
                .price(product.price)
                .priceText(product.priceText)
                .name(product.name)
                .id(product.id)
                .build();

        Set<String> visited = new HashSet<>();

        burgerRepository.findAll().forEach(b -> visited.add(b.getId()));

        if (!visited.contains(burger.getId())) {
            burgerRepository.save(burger);
        }
    }

    private Product getProduct() throws IOException {
        String root = FoodDetailConnector.getHttpURLConnectionCuisine("60d42e5211817692745409c2"); // -> burger code
        final Root json = objectMapper.readValue(root, Root.class);

        if (!Objects.equals(json.result.message, "SUCCESS!!!")) {
            scheduledExecutorService.submit(() -> {
                try {
                    crawlImage();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        return json.data.product;
    }

}
