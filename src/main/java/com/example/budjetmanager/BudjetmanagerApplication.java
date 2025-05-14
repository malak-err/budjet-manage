package com.example.budjetmanager;

import com.example.budjetmanager.entities.Transaction;
import com.example.budjetmanager.repositories.TransactionRepositorie;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BudjetmanagerApplication  {

    public static void main(String[] args) {
        SpringApplication.run(BudjetmanagerApplication.class, args);
    }


    @Bean
    public ModelMapper modelMapper() {


        return new ModelMapper();
    }
}
