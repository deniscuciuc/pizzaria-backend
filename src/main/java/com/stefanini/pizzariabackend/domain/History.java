package com.stefanini.pizzariabackend.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.GenerationType.SEQUENCE;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "History")
@Table(name = "History")
public class History {

    @Id
    @SequenceGenerator(
            name = "history_sequence",
            sequenceName = "history_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "history_sequence"
    )
    @Column(
            name = "id",
            nullable = false,
            updatable = false
    )
    private Long Id;

    @Column(
            name = "actionName",
            nullable = false,
            updatable = false
    )
    private String actionName;

    @Column(
            name = "performedAt",
            nullable = false,
            updatable = false
    )
    @CreationTimestamp
    private LocalDate performedAt;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            nullable = false
    )
    private User user;

    private History(String actionName, LocalDate performedAt, User user) {
        this.actionName = actionName;
        this.performedAt = performedAt;
        this.user = user;
    }

    public static History createWithInstantLocalDate(String actionName, User user) {
        return new History(actionName, LocalDate.now(), user);
    }
}
