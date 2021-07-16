package com.test.spotify.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "call")
public class Call {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_call")
    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss")
    private LocalDate date;

    @Column(name = "city_name")
    private String cityName;
}
