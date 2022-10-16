package com.crawl.foodcrawler.api;

import com.crawl.foodcrawler.dto.getir.all_restoran_response.Product;
import com.crawl.foodcrawler.model.Burger;
import com.crawl.foodcrawler.model.Kebap;
import com.crawl.foodcrawler.model.Pizza;
import com.crawl.foodcrawler.repository.BurgerRepository;
import com.crawl.foodcrawler.repository.KebapRepository;
import com.crawl.foodcrawler.repository.PizzaRepository;
import com.crawl.foodcrawler.serivce.AllRestaurantCrawl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/preview")
@RequiredArgsConstructor
public class PreviewImageApi {

    private final AllRestaurantCrawl allRestaurantCrawl;


    @GetMapping("/json")
    public ResponseEntity<?> getBurgerPreview() {
        final Map<String, Map<String, ArrayList<Product>>> map = allRestaurantCrawl.crawl();
        return ResponseEntity.ok(map);
    }
}
