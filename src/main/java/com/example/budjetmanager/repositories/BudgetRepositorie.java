package com.example.budjetmanager.repositories;

import com.example.budjetmanager.entities.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BudgetRepositorie extends JpaRepository<Budget,Long>{

}
