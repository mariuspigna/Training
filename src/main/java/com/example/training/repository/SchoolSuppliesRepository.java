package com.example.training.repository;

import com.example.training.model.SchoolSupplies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolSuppliesRepository extends JpaRepository<SchoolSupplies, Long> {
}
