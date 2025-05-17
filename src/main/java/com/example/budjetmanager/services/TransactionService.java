package com.example.budjetmanager.services;

import com.example.budjetmanager.Mappers.TransactionMap;
import com.example.budjetmanager.dto.CategorieDto;
import com.example.budjetmanager.dto.TransactionDto;
import com.example.budjetmanager.entities.Transaction;
import com.example.budjetmanager.repositories.TransactionRepositorie;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

  private  final  TransactionRepositorie transactionRepositorie;
  private final TransactionMap transactionMap;
  @Autowired
  public TransactionService(TransactionRepositorie transactionRepositorie , TransactionMap transactionMap, TransactionRepositorie transactionRepositorie1, TransactionMap transactionMap1){
      this.transactionRepositorie = transactionRepositorie1;
      this.transactionMap = transactionMap1;
  }

    public TransactionDto addTransaction(TransactionDto transactionDto) {
        Transaction transaction = transactionMap.toEntity(transactionDto);
        Transaction savedTransaction = transactionRepositorie.save(transaction);
        return transactionMap.toDTO(savedTransaction);
    }


    public List<TransactionDto> getAllTransactions() {
        List<Transaction> transactions = transactionRepositorie.findAll();
        return transactionMap.toDTOs(transactions);
    }


    public TransactionDto getTransactionById(Long id) {
        return transactionRepositorie.findById(id)
                .map(transactionMap::toDTO)
                .orElse(null);
    }


    public TransactionDto updateTransaction(Long id, TransactionDto transactionDto) {
        return transactionRepositorie.findById(id)
                .map(existingTransaction -> {

                    existingTransaction.setMontant(transactionDto.getMontant());
                    existingTransaction.setDate(transactionDto.getDate());
                    existingTransaction.setDescription(transactionDto.getDescription());


                    Transaction updatedTransaction = transactionRepositorie.save(existingTransaction);
                    return transactionMap.toDTO(updatedTransaction);
                })
                .orElse(null);
    }


    public void deleteTransaction(Long id) {
        transactionRepositorie.deleteById(id);
    }

}
