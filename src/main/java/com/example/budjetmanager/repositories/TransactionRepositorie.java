package com.example.budjetmanager.repositories;

import com.example.budjetmanager.entities.Categorie;
import com.example.budjetmanager.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepositorie extends JpaRepository<Transaction,Long> {



}
