package com.example.budjetmanager.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.IdGeneratorType;

import java.util.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
   private long id;
   private Double montant;
   private Date date;
   private String description;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

}
