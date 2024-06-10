package com.marketapp.marketapp.repository;


import com.marketapp.marketapp.model.status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<status, Integer> {
}
