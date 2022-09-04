package com.stefanini.pizzariabackend.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.*;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "User")
@Table(
        name = "User",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "user_email_unique",
                        columnNames = "email"
                ),
                @UniqueConstraint(
                        name = "user_nickname_unique",
                        columnNames = "nickname"
                )
        }
)
public class User {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence"
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "user_sequence"
    )
    @Column(
            name = "id",
            nullable = false,
            updatable = false
    )
    private Long id;

    @Column(
            name = "email",
            nullable = false,
            updatable = false
    )
    private String email;

    @Column(
            name = "nickname",
            nullable = false,
            updatable = false
    )
    private String nickname;


    @Column(
            name = "password",
            nullable = false
    )
    private String password;

    @OneToMany(mappedBy = "user")
    private List<History> history;

    private User(String email, String nickname, String password) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
    }

    public static User createWithAllArgs(String email, String nickname, String password) {
        return new User(email, nickname, password);
    }
}
