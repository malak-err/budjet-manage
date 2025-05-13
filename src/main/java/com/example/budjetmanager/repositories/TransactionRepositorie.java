package com.example.budjetmanager.repositories;

import com.example.budjetmanager.controllers.Transaction;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TransactionRepositorie extends JpaRepository<Transaction,Long> {


}
