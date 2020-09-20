package com.smi.allone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smi.allone.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
