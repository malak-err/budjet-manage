package com.example.budjetmanager.Mappers;

import com.example.budjetmanager.dto.BudjetDto;
import com.example.budjetmanager.dto.CategorieDto;
import com.example.budjetmanager.entities.Budget;
import com.example.budjetmanager.entities.Categorie;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface CategorieMap {
    Categorie toEntity(CategorieDto dto);
    CategorieDto toDTO(Categorie categorie);
    List<CategorieDto> toDTOs(List<Categorie> categories);
}
