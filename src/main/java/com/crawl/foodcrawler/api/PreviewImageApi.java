package com.crawl.foodcrawler.api;

import com.crawl.foodcrawler.model.Burger;
import com.crawl.foodcrawler.model.Kebap;
import com.crawl.foodcrawler.model.Pizza;
import com.crawl.foodcrawler.repository.BurgerRepository;
import com.crawl.foodcrawler.repository.KebapRepository;
import com.crawl.foodcrawler.repository.PizzaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/api/preview")
@RequiredArgsConstructor
public class PreviewImageApi {

    private final BurgerRepository burgerRepository;
    private final KebapRepository kebapRepository;
    private final PizzaRepository pizzaRepository;


    @GetMapping("/burger")
    public ModelAndView getBurgerPreviewImage() {
        ModelAndView modelAndView = new ModelAndView("image-list");
        List<Burger> burgerList = burgerRepository.findAll();
        modelAndView.addObject("images", burgerList);
        return modelAndView;
    }

    @GetMapping("/kebap")
    public ModelAndView getKebapPreviewImage() {
        ModelAndView modelAndView = new ModelAndView("image-list");
        List<Kebap> burgerList = kebapRepository.findAll();
        modelAndView.addObject("images", burgerList);
        return modelAndView;

    }

    @GetMapping("/pizza")
    public ModelAndView getPizzaPreviewImage() {
        ModelAndView modelAndView = new ModelAndView("image-list");
        List<Pizza> burgerList = pizzaRepository.findAll();
        modelAndView.addObject("images", burgerList);
        return modelAndView;

    }
}
