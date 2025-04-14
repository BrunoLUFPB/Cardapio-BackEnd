package com.example.Cardapio.controller;

import com.example.Cardapio.food.Food;
import com.example.Cardapio.food.FoodRepository;
import com.example.Cardapio.food.FoodResponseDTO;
import com.example.Cardapio.food.FoodResquestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveFood(@RequestBody FoodResquestDTO data) {
        Food foodData = new Food(data);
        repository.save(foodData);
        return;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<FoodResponseDTO> getAll() {
        List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    public FoodResponseDTO getById(@PathVariable Long id) {
        Food food = repository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        return new FoodResponseDTO(food);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    public void updateFood(@PathVariable Long id, @RequestBody FoodResquestDTO data) {
        Food food = repository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        food.setTitle(data.title());
        food.setImage(data.image());
        food.setPrice(data.price());
        repository.save(food);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public void deleteFood(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
