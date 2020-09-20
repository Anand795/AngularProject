package com.smi.allone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smi.allone.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
