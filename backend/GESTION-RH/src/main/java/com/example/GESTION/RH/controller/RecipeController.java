package com.example.GESTION.RH.controller;

import com.example.GESTION.RH.model.Recipe;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
@RestController
@RequestMapping("/api/recipes")
public class RecipeController {
    private final List<String> recipes = List.of(
            "Ovy sy toto-kena",
            "akoha",
            "Kisoa",
            "hen'omby",
            "ravitoto"
    );
    @GetMapping("/random")
    public Recipe getRandomRecipe() {
        Random random = new Random();
        int randomIndex = random.nextInt(recipes.size());
        String randomRecipeName = recipes.get(randomIndex);
        return new Recipe(randomRecipeName);
    }
}
