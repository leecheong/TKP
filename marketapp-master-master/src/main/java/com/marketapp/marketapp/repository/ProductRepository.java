package com.marketapp.marketapp.repository;

import com.marketapp.marketapp.model.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface ProductRepository extends JpaRepository<product, Integer> {

    Optional<product> findById(Integer P_id);

}
