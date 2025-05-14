package com.example.budjetmanager.repositories;

import com.example.budjetmanager.controllers.TransactionController;
import com.example.budjetmanager.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepositorie extends JpaRepository<Transaction,Long> {



}
