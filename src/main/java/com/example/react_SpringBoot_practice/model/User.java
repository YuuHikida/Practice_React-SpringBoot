package com.example.react_SpringBoot_practice.model;

import jakarta.persistence.*;
import lombok.Data;

//↓DBとクラスを呼び出すEntity
@Entity
@Data
@Table(name="my_table")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long    id;
    private  String name;
}
