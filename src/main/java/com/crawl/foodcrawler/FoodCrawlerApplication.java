package com.crawl.foodcrawler;

import com.crawl.foodcrawler.serivce.BurgerImageCrawler;
import com.crawl.foodcrawler.serivce.KebapImageCrawler;
import com.crawl.foodcrawler.serivce.PizzaImageCrawler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class FoodCrawlerApplication {

    private static final Set<String> visited = new HashSet<>();

    public static void main(String[] args) throws IOException {
        final ConfigurableApplicationContext ctx = SpringApplication.run(FoodCrawlerApplication.class, args);

       ctx.getBean(BurgerImageCrawler.class).crawlImage();
       ctx.getBean(PizzaImageCrawler.class).crawlImage();
       ctx.getBean(KebapImageCrawler.class).crawlImage();

    }
}
