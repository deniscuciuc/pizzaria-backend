package com.stefanini.pizzariabackend.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Order")
@Table(name = "order")
public class Order {

    @Id
    private Long id;

}
