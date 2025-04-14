package com.example.Cardapio.food;

public record FoodResquestDTO(
        String title,
        String image,
        Integer price,
        String description,
        String category,
        Boolean available
) {}
