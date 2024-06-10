package com.marketapp.marketapp.repository;

import com.marketapp.marketapp.model.category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<category, Integer> {
}
