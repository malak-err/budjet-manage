package com.example.budjetmanager.Mappers;

import com.example.budjetmanager.dto.CategorieDto;
import com.example.budjetmanager.dto.TransactionDto;
import com.example.budjetmanager.entities.Transaction;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface TransactionMap {
    Transaction toEntity(TransactionDto transactionDto);
    TransactionDto toDTO(Transaction transaction);
    List<TransactionDto> toDTOs (List<Transaction> transactions);
}
