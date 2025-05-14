package com.example.budjetmanager.services;

import com.example.budjetmanager.dto.TransactionDto;
import com.example.budjetmanager.entities.Categorie;
import com.example.budjetmanager.entities.Transaction;
import com.example.budjetmanager.repositories.CategorieRepositorie;
import com.example.budjetmanager.repositories.TransactionRepositorie;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service

@RequiredArgsConstructor

public class TransactionService {

    private  TransactionRepositorie transactionRepositorie;
    private  CategorieRepositorie categorieRepositorie;
    private  ModelMapper modelMapper;
    public TransactionService(TransactionRepositorie transactionRepositorie,
                              CategorieRepositorie categorieRepositorie,
                              ModelMapper modelMapper) {
        this.transactionRepositorie = transactionRepositorie;
        this.categorieRepositorie = categorieRepositorie;
        this.modelMapper = modelMapper;
    }
    public TransactionDto save(TransactionDto transactionDto) {
        Categorie categorie = categorieRepositorie.findById(transactionDto.getIdCategorie())
                .orElseThrow(() -> new RuntimeException("Catégorie introuvable avec l'id: " + transactionDto.getIdCategorie()));

        Transaction transaction = modelMapper.map(transactionDto, Transaction.class);
        transaction.setCategorie(categorie);

        Transaction savedTransaction = transactionRepositorie.save(transaction);

        TransactionDto result = modelMapper.map(savedTransaction, TransactionDto.class);
        result.setIdCategorie(savedTransaction.getCategorie().getIdCategorie());

        return result;
    }
}
