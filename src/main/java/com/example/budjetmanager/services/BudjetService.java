package com.example.budjetmanager.services;

import com.example.budjetmanager.Mappers.BudgetMap;
import com.example.budjetmanager.dto.BudjetDto;
import com.example.budjetmanager.entities.Budget;
import com.example.budjetmanager.repositories.BudgetRepositorie;
import com.example.budjetmanager.repositories.CategorieRepositorie;

import java.util.List;
import java.util.Optional;

public class BudjetService {
    private final BudgetRepositorie budgetRepositorie;
    private final BudgetMap budgetMap;

    public BudjetService(BudgetRepositorie budgetRepositorie, BudgetMap budgetMap) {
        this.budgetRepositorie = budgetRepositorie;
        this.budgetMap = budgetMap;
    }

   public BudjetDto addBudget(BudjetDto dto){
       Budget budget = budgetMap.toEntity(dto);
       Budget saved = budgetRepositorie.save(budget);
       return budgetMap.toDTO(budget);
   }

}
