package com.example.budjetmanager.controllers;

import com.example.budjetmanager.dto.TransactionDto;
import com.example.budjetmanager.services.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class TransactionController {
    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }


    @PostMapping("/transactions")
    public ResponseEntity<TransactionDto> addTransaction(@RequestBody TransactionDto transactionDto) {
        TransactionDto savedTransaction = transactionService.addTransaction(transactionDto);
        return new ResponseEntity<>(savedTransaction, HttpStatus.CREATED);
    }


    @GetMapping("/transactions")
    public ResponseEntity<List<TransactionDto>> getAllTransactions() {
        List<TransactionDto> transactions = transactionService.getAllTransactions();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }


    @GetMapping("/transactions/ {id}")
    public ResponseEntity<TransactionDto> getTransactionById(@PathVariable Long id) {
        TransactionDto transaction = transactionService.getTransactionById(id);
        return transaction != null
                ? new ResponseEntity<>(transaction, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PutMapping("/transactions/{id}")
    public ResponseEntity<TransactionDto> updateTransaction(
            @PathVariable Long id,
            @RequestBody TransactionDto transactionDto) {
        TransactionDto updatedTransaction = transactionService.updateTransaction(id, transactionDto);
        return updatedTransaction != null
                ? new ResponseEntity<>(updatedTransaction, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("/transactions/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
