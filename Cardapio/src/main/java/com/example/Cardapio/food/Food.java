package com.example.Cardapio.food;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "foods")
@Entity(name = "foods")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String image;
    private Integer price;
    private String description;

    // 🔥 Novos campos adicionados:
    private String category;
    private Boolean available;

    public Food(FoodResquestDTO data) {
        this.image = data.image();
        this.price = data.price();
        this.title = data.title();
        this.description = data.description();
        this.category = data.category();
        this.available = data.available();
    }
}
