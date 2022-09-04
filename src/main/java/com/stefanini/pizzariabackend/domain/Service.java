package com.stefanini.pizzariabackend.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Service")
@Table(name = "Service")
public class Service {

    @Id
    private Long id;

    private String title;

    private String description;

    private String contactNumber;

    private byte[] image;
}
