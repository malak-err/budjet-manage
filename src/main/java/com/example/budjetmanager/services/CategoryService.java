package com.example.budjetmanager.services;

import com.example.budjetmanager.Mappers.CategorieMap;
import com.example.budjetmanager.dto.CategorieDto;
import com.example.budjetmanager.entities.Budget;
import com.example.budjetmanager.entities.Categorie;
import com.example.budjetmanager.repositories.CategorieRepositorie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

  private  CategorieRepositorie categorieRepositorie;
  private CategorieMap categorieMap;

    public CategoryService(CategorieRepositorie categorieRepositorie, CategorieMap categorieMap) {
        this.categorieRepositorie = categorieRepositorie;
        this.categorieMap = categorieMap;
    }

    public CategorieDto addCategorie(CategorieDto dto){
        Categorie categorie = categorieMap.toEntity(dto);
        Budget saved = categorieRepositorie.save(categorie).getBudget();
        return categorieMap.toDTO(categorie);
    }

    public List<CategorieDto> getAllCategories() {
        List<Categorie> categories = categorieRepositorie.findAll();
        return categorieMap.toDTOs(categories);
    }


    public CategorieDto getCategorieById(Long id) {
        Optional<Categorie> optionalCategorie = categorieRepositorie.findById(id);
        return optionalCategorie.map(categorieMap::toDTO).orElse(null);
    }


    public CategorieDto updateCategorie(Long id, CategorieDto categorieDto) {
        Optional<Categorie> optionalCategorie = categorieRepositorie.findById(id);
        if (optionalCategorie.isPresent()) {
            Categorie existingCategorie = optionalCategorie.get();


            existingCategorie.setName(categorieDto.getName());
            existingCategorie.setType(categorieDto.getType());


            Categorie updatedCategorie = categorieRepositorie.save(existingCategorie);
            return categorieMap.toDTO(updatedCategorie);
        }
        return null;
    }


    public void deleteCategorie(Long id) {
        categorieRepositorie.deleteById(id);
    }
}




