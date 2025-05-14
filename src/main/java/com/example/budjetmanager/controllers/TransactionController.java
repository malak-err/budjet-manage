package com.example.budjetmanager.controllers;

import com.example.budjetmanager.dto.TransactionDto;
import com.example.budjetmanager.services.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("transaction")
    public ResponseEntity<TransactionDto> save(@RequestBody TransactionDto dto) {
        TransactionDto saved = transactionService.save(dto);
        return ResponseEntity.ok(saved);
    }


}
