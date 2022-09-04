package com.stefanini.pizzariabackend.domain;

import com.stefanini.pizzariabackend.domain.enums.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;

import java.time.LocalDateTime;

import static javax.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "Order")
@Table(name = "Order")
public class Order {

    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "order_sequence"
    )
    @Column(
            name = "id",
            nullable = false,
            updatable = false
    )
    private Long id;

    @Column(
            name = "status",
            nullable = false
    )
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(
            name = "createdAt",
            nullable = false,
            updatable = false
    )
    @CreationTimestamp
    private LocalDateTime createdAt;

    // TODO: add user, many to many,
    // TODO: numberOfCutlery, payment method,
    // TODO: totalCost


}
