package com.intellipro.customer.journey.demo.repository;

import com.intellipro.customer.journey.demo.entity.Journey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JourneyRepository extends JpaRepository<Journey, Long> {

    Journey findById(long l);
}
