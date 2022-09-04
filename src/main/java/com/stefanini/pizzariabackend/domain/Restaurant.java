package com.stefanini.pizzariabackend.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Restaurant")
@Table(name = "Restaurant")
public class Restaurant {

    @Id
    private Long id;

    private String address;

    private String contactNumber;

    private String workHoursInWorkDays;

    private String workHoursInWeekend;

    @Column(
            name = "coordinates",
            nullable = false
    )
    private String coordinates;
}
