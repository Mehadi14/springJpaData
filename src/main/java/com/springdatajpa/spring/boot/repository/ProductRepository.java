package com.springdatajpa.spring.boot.repository;

import com.springdatajpa.spring.boot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


public interface ProductRepository extends JpaRepository<Product,Long> {
    /**
     * returns products based on datr create range
     * @param startDate
     * @param endDate
     * @return
     */

    List<Product> findByDateCreatedBetween(LocalDate startDate , LocalDate endDate);
}



