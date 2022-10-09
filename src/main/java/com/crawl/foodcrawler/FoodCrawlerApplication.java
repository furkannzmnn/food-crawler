package com.crawl.foodcrawler;

import com.crawl.foodcrawler.serivce.AllRestaurantCrawl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;

@SpringBootApplication
public class FoodCrawlerApplication {

    private static final Set<String> visited = new HashSet<>();

    public static void main(String[] args) throws IOException {
        final ConfigurableApplicationContext ctx = SpringApplication.run(FoodCrawlerApplication.class, args);

       ctx.getBean(AllRestaurantCrawl.class).crawl();

    }

    @Bean
    // task scheduler
    public ExecutorService executorService() {
        return java.util.concurrent.Executors.newScheduledThreadPool(3);
    }

    // ScheduledExecutorService bean
    @Bean
    public java.util.concurrent.ScheduledExecutorService scheduledExecutorService() {
        return java.util.concurrent.Executors.newScheduledThreadPool(3);
    }
}
