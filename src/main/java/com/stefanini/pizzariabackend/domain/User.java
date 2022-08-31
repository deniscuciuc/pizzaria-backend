package com.stefanini.pizzariabackend.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "User")
@Table(name = "User")
public class User {

    @Id
    private Long id;
}
