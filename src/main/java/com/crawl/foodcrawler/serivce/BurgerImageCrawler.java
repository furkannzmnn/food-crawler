package com.crawl.foodcrawler.serivce;

import com.crawl.foodcrawler.dto.getir.response.Root;
import com.crawl.foodcrawler.model.Burger;
import com.crawl.foodcrawler.repository.BurgerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import static com.crawl.foodcrawler.util.ImageFilterConnector.getHttpURLConnectionCuisine;

@Component
@RequiredArgsConstructor
public class BurgerImageCrawler {

    private final BurgerRepository burgerRepository;

    private static final Set<String> visited = new HashSet<>();


    public void crawlImage() throws IOException {
        Root root = getHttpURLConnectionCuisine("5c5429bb2857994ab884dc36"); // -> burger code

        Set<String> uniqueBurgerImageData = new HashSet<>();

        root.data.items.forEach(item -> item.cuisines.forEach(cuisine -> {
            if (cuisine.name.equalsIgnoreCase("burger")) {
                final String imageURL = item.imageURL;
                visited.add(imageURL);
            }
        }));

        burgerRepository.findAll().forEach(burger -> uniqueBurgerImageData.add(burger.getImageURL()));

        visited.stream().filter(imageUrl -> !uniqueBurgerImageData.contains(imageUrl)).forEach(imageUrl -> {
            final Burger burger = Burger.builder().imageURL(imageUrl).build();
            burgerRepository.save(burger);
        });

    }

}
