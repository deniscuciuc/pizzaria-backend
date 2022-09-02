package com.stefanini.pizzariabackend.domain;

import com.stefanini.pizzariabackend.domain.enums.Category;
import com.stefanini.pizzariabackend.domain.enums.Size;
import com.stefanini.pizzariabackend.domain.enums.Subcategory;
import com.stefanini.pizzariabackend.domain.enums.Thickness;
import lombok.*;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "MenuItem")
@Table(name = "menu_item")
public class MenuItem {

    @Id
    @SequenceGenerator(
            name = "menuItem_sequence",
            sequenceName = "menuItem_sequence",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "menuItem_sequence"
    )
    @Column(
            name = "id",
            nullable = false,
            updatable = false
    )
    private Long id;

    @Column(
            name = "name",
            nullable = false
    )
    private String name;

    @Column(
            name = "image",
            columnDefinition = "mediumblob"
    )
    @Lob
    private byte[] image;

    @OneToMany
    private List<Ingredient> ingredients;


    @Column(
            name = "size",
            nullable = false
    )
    @Enumerated(EnumType.STRING)
    private Size size;


    @Column(
            name = "weight"
    )
    private double weight;


    @Column(
            name = "price",
            nullable = false
    )
    private double price;

    @Column(
            name = "category",
            nullable = false
    )
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(
            name = "subcategory"
    )
    @Enumerated(EnumType.STRING)
    private Subcategory subcategory;

    @Column(
            name = "thickness"
    )
    @Enumerated(EnumType.STRING)
    private Thickness thickness;

    private MenuItem(String name, byte[] image, List<Ingredient> ingredients, Size size,
                     double weight, double price, Category category, Subcategory subcategory,
                     Thickness thickness) {
        this.name = name;
        this.image = image;
        this.ingredients = ingredients;
        this.size = size;
        this.weight = weight;
        this.price = price;
        this.category = category;
        this.subcategory = subcategory;
        this.thickness = thickness;
    }

    private MenuItem(String name, byte[] image, List<Ingredient> ingredients, Size size,
                     double weight, double price, Category category, Subcategory subcategory) {
        this.name = name;
        this.image = image;
        this.ingredients = ingredients;
        this.size = size;
        this.weight = weight;
        this.price = price;
        this.category = category;
        this.subcategory = subcategory;
    }

    public static MenuItem createWithAllArgs(String name, byte[] image, List<Ingredient> ingredients,
                                             Size size, double weight, double price, Category category,
                                             Subcategory subcategory, Thickness thickness) {
        return new MenuItem(
                name, image, ingredients, size, weight, price, category, subcategory, thickness
        );
    }

    public static MenuItem createWithOutThickness(String name, byte[] image, List<Ingredient> ingredients,
                                                  Size size, double weight, double price, Category category,
                                                  Subcategory subcategory) {
        return new MenuItem(
                name, image, ingredients, size, weight, price, category, subcategory
        );
    }
}
