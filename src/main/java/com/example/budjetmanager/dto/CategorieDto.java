package com.example.budjetmanager.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor

public class CategorieDto implements Serializable {
    Long idCategorie;
    String name;
    String type;
    List<TransactionDto> transactions;
    Long budgetId;
    Double budgetLimite;

    public Long getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Long idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<TransactionDto> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionDto> transactions) {
        this.transactions = transactions;
    }

    public Long getBudgetId() {
        return budgetId;
    }

    public void setBudgetId(Long budgetId) {
        this.budgetId = budgetId;
    }

    public Double getBudgetLimite() {
        return budgetLimite;
    }

    public void setBudgetLimite(Double budgetLimite) {
        this.budgetLimite = budgetLimite;
    }
}