package com.example.Cardapio.food;

public record FoodResponseDTO(
        Long id,
        String title,
        String image,
        Integer price,
        String description,
        String category,
        Boolean available
) {
    public FoodResponseDTO(Food food) {
        this(
                food.getId(),
                food.getTitle(),
                food.getImage(),
                food.getPrice(),
                food.getDescription(),
                food.getCategory(),
                food.getAvailable()
        );
    }
}
