package com.stefanini.pizzariabackend.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;

import java.sql.Date;

import static javax.persistence.GenerationType.*;

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
    private Date performedAt;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            nullable = false
    )
    private User user;

    private History(String actionName, Date performedAt, User user) {
        this.actionName = actionName;
        this.performedAt = performedAt;
        this.user = user;
    }

    public static History createWithAllArgs(String actionName, Date performedAt, User user) {
        return new History(actionName, performedAt, user);
    }
}
