package com.example.budjetmanager.Mappers;

import com.example.budjetmanager.dto.BudjetDto;
import com.example.budjetmanager.entities.Budget;
import org.apache.catalina.User;
import org.mapstruct.Mapper;

import java.util.List;


public interface BudgetMap {

    Budget toEntity(BudjetDto dto);

    BudjetDto toDTO(Budget budget);

    List<BudjetDto> toDTOs(List<Budget> budgets);
}
