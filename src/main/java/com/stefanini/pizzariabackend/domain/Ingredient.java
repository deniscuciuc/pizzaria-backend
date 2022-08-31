package com.stefanini.pizzariabackend.domain;

import com.stefanini.pizzariabackend.domain.enums.IngredientType;

import javax.persistence.*;

@Entity(name = "Ingredient")
@Table(name = "Ingredient")
public class Ingredient {

    @Id
    private Long id;
    private String name;
    private double weight;
    private IngredientType type;

    @ManyToOne
    private MenuItem menuItem;
}
