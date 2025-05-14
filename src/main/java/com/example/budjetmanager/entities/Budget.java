package com.example.budjetmanager.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Budget {
    @Id
    private Long id ;
    private Double limite;

    @OneToOne
    private Categorie categorie;


}
