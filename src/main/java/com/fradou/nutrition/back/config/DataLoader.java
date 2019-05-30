package com.fradou.nutrition.back.config;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fradou.nutrition.back.entity.Food;
import com.fradou.nutrition.back.entity.PantryItem;
import com.fradou.nutrition.back.repository.FoodRepository;
import com.fradou.nutrition.back.repository.PantryItemRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Configuration
@Log4j2
public class DataLoader implements CommandLineRunner {

    @Autowired
    FoodRepository foodRepository;

    @Autowired
    PantryItemRepository pantryItemRepository;

    private String FOOD_FILE = "food.csv";
    private List<Food> existingFoods;

    public void run(String... args) {
        existingFoods = this.foodRepository.findAll();
        if (existingFoods.size() == 0) {
            try {
                CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
                CsvMapper mapper = new CsvMapper();
                File file = new ClassPathResource("data/" + FOOD_FILE).getFile();
                MappingIterator<Food> readValues =
                        mapper.reader(Food.class).with(bootstrapSchema).readValues(file);
                List<Food> foods = readValues.readAll();
                existingFoods = foodRepository.saveAll(foods);
                log.info("Jeu de données nourriture chargé");
            } catch (Exception e) {
                log.error("Erreur lors du chargement du jeu de données nourriture " + FOOD_FILE, e);
            }
        }
        List<PantryItem> items = this.pantryItemRepository.findAll();
        if (items.size() < 1) {
            this.pantryItemRepository.saveAll(Arrays.asList(
                    buildItem(),
                    buildItem(),
                    buildItem(),
                    buildItem(),
                    buildItem(),
                    buildItem()));
        }
    }

    private Integer randomFood() {
        Double rand = Math.random() * this.existingFoods.size();
        return rand.intValue();
    }

    private PantryItem buildItem() {
        return PantryItem.builder()
                .food(existingFoods.get(randomFood()))
                .expirationDate(LocalDate.now())
                .share(Math.random() > 0.5 ? null : 3)
                .weight(Math.random() > 0.5 ? null : 2).build();
    }
}
