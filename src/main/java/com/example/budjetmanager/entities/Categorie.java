package com.example.budjetmanager.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categorie {
    @Id


    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String type;

    @OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL)
    private List<Transaction> transactions;

    @OneToOne(mappedBy = "categorie")
    private Budget budget;

}

