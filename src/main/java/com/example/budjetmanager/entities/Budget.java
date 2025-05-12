package com.example.budjetmanager.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
    private Double Limite;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLimite() {
        return Limite;
    }

    public void setLimite(Double limite) {
        Limite = limite;
    }
}
