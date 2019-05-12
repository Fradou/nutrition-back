package com.fradou.nutrition.back.config;

import com.fradou.nutrition.back.entity.Food;
import com.fradou.nutrition.back.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class DataLoader implements CommandLineRunner {

    @Autowired
    FoodRepository foodRepository;

    public void run(String... args) throws Exception {
        List<Food> testFood = Arrays.asList(
                Food.builder().label("Pomme").calorie(125).protein(5).carbohydrate(6.5).fat(4.3).build(),
                Food.builder().label("Carotte").calorie(625).protein(53).carbohydrate(8.5).fat(3).build()
        );
        foodRepository.saveAll(testFood);
    }
}
