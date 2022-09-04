package com.stefanini.pizzariabackend.domain;

import com.stefanini.pizzariabackend.domain.enums.Category;
import com.stefanini.pizzariabackend.domain.enums.Size;
import com.stefanini.pizzariabackend.domain.enums.Subcategory;
import com.stefanini.pizzariabackend.domain.enums.Thickness;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

import static javax.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "MenuItem")
@Table(name = "Menu_Item")
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

    @Column(
            name = "ingredients",
            nullable = false
    )
    private String ingredients;

    @Column(
            name = "sizesAndPrices"
    )
    @ElementCollection
    private Map<Size, Double> sizesAndPrices;

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

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private MenuItem(String name, byte[] image, String ingredients,
                     Map<Size, Double> sizesAndPrices, Category category, Subcategory subcategory,
                     Thickness thickness, Order order) {
        this.name = name;
        this.image = image;
        this.ingredients = ingredients;
        this.sizesAndPrices = sizesAndPrices;
        this.category = category;
        this.subcategory = subcategory;
        this.thickness = thickness;
        this.order = order;
    }

    private MenuItem(String name, byte[] image, String ingredients, Map<Size, Double> sizesAndPrices,
                     Category category, Thickness thickness) {
        this.name = name;
        this.image = image;
        this.ingredients = ingredients;
        this.sizesAndPrices = sizesAndPrices;
        this.category = category;
        this.thickness = thickness;
    }

    public static MenuItem createPizzaWithDefaultValues(String name, byte[] image, String ingredients,
                                                        double priceForSmallSize, double priceForMediumSize,
                                                        double priceForLargeSize, Thickness thickness) {

        Map<Size, Double> sizesAndPrices = new HashMap<>();
        sizesAndPrices.put(Size.SMALL, priceForSmallSize);
        sizesAndPrices.put(Size.MEDIUM, priceForMediumSize);
        sizesAndPrices.put(Size.LARGE, priceForLargeSize);

        return new MenuItem(
                name, image, ingredients, sizesAndPrices, Category.PIZZA, thickness
        );
    }
}
