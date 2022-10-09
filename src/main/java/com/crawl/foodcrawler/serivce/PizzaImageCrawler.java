package com.crawl.foodcrawler.serivce;

import com.crawl.foodcrawler.dto.getir.response.Root;
import com.crawl.foodcrawler.model.Pizza;
import com.crawl.foodcrawler.repository.PizzaRepository;
import com.crawl.foodcrawler.util.CategoryFilterConnector;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class PizzaImageCrawler {
    private static final Set<String> visited = new HashSet<>();

    private final PizzaRepository pizzaRepository;

    public void crawlImage() throws IOException {
        final Root root = CategoryFilterConnector.getHttpURLConnectionDetail("5c542abd285799656884dc41");


        Set<String> uniqueBurgerImageData = new HashSet<>();


        root.data.items.forEach(item -> item.cuisines.forEach(cuisine -> {
            if (cuisine.name.equalsIgnoreCase("pizza")) {
                final String imageURL = item.imageURL;
                visited.add(imageURL);
            }
        }));


        pizzaRepository.findAll().forEach(burger -> uniqueBurgerImageData.add(burger.getImageURL()));

        visited.stream().filter(imageUrl -> !uniqueBurgerImageData.contains(imageUrl)).forEach(imageUrl -> {
            final Pizza burger = Pizza.builder().imageURL(imageUrl).build();
            pizzaRepository.save(burger);
        });


    }
}
