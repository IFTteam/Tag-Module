package com.intellipro.customer.journey.demo.repository;

import com.intellipro.customer.journey.demo.entity.Audience;
import com.intellipro.customer.journey.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AudienceRepository extends JpaRepository<Audience, Long> {

    @Query("select s.audienceId from Audience s where s.user = ?1")
    long getAudienceIdByUser(User user);

    @Query("select s from Audience s where s.user = ?1")
    List<Audience> getAudienceByUser(User user);

    Audience findById(long l);
}
