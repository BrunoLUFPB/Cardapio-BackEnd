package com.example.Cardapio.food;

public record FoodResponseDTO(Long id, String name, String image, Integer price, String description) {
    public FoodResponseDTO(Food food) {
        this(food.getId(), food.getTitle(), food.getImage(), food.getPrice(), food.getDescription());
    }
}
