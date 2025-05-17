package com.example.budjetmanager.controllers;

import com.example.budjetmanager.dto.BudjetDto;
import com.example.budjetmanager.dto.CategorieDto;
import com.example.budjetmanager.dto.TransactionDto;
import com.example.budjetmanager.entities.Categorie;
import com.example.budjetmanager.services.BudjetService;
import com.example.budjetmanager.services.CategoryService;
import com.example.budjetmanager.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

   public class CategorieController {
   private final CategoryService categoryService;

    public CategorieController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @PostMapping("/categorie")
   public ResponseEntity<CategorieDto> createCategor(@RequestBody CategorieDto categorieDto){
      CategorieDto createCategori = categoryService.addCategorie(categorieDto);
      return new ResponseEntity<>(createCategori, HttpStatus.CREATED);
   }


    @GetMapping
    public ResponseEntity<List<CategorieDto>> getAllCategories() {
        List<CategorieDto> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<CategorieDto> getCategorieById(@PathVariable Long id) {
        CategorieDto categorie =categoryService.getCategorieById(id);
        if (categorie != null) {
            return new ResponseEntity<>(categorie, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<CategorieDto> updateCategorie(
            @PathVariable Long id,
            @RequestBody CategorieDto categorieDto) {
        CategorieDto updatedCategorie = categoryService.updateCategorie(id, categorieDto);
        if (updatedCategorie != null) {
            return new ResponseEntity<>(updatedCategorie, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/categorie/{id}")
    public ResponseEntity<Void> deleteCategorie(@PathVariable Long id) {
        categoryService.deleteCategorie(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}












