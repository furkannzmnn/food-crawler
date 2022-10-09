package com.crawl.foodcrawler.serivce;

import com.crawl.foodcrawler.dto.getir.response.Root;
import com.crawl.foodcrawler.model.Kebap;
import com.crawl.foodcrawler.repository.KebapRepository;
import com.crawl.foodcrawler.util.CategoryFilterConnector;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Component
public class KebapImageCrawler {
    private static final Set<String> visited = new HashSet<>();
    private final KebapRepository kebapRepository;

    public void crawlImage() throws IOException {
        final Root root = CategoryFilterConnector.getHttpURLConnectionDetail("5c542a40285799ac5684dc3b");
        Set<String> uniqueBurgerImageData = new HashSet<>();


        root.data.items.forEach(item -> item.cuisines.forEach(cuisine -> {
            if (cuisine.name.equalsIgnoreCase("kebap")) {
                final String imageURL = item.imageURL;
                visited.add(imageURL);
            }
        }));


        kebapRepository.findAll().forEach(kebap -> uniqueBurgerImageData.add(kebap.getImageURL()));

        visited.stream().filter(imageUrl -> !uniqueBurgerImageData.contains(imageUrl)).forEach(imageUrl -> {
            final Kebap kebap = Kebap.builder().imageURL(imageUrl).build();
            kebapRepository.save(kebap);
        });

    }
}
