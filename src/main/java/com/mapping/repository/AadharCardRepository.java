package com.mapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mapping.entity.AadharCard;

@Repository
public interface AadharCardRepository extends JpaRepository<AadharCard, Integer> {

}
