package com.stefanini.pizzariabackend.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "Profile")
@Table(name = "Profile")
public class Profile {
}
