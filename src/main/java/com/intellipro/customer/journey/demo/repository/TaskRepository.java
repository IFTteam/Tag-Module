package com.intellipro.customer.journey.demo.repository;

import com.intellipro.customer.journey.demo.entity.CoreModuleTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<CoreModuleTask, Long> {
}
