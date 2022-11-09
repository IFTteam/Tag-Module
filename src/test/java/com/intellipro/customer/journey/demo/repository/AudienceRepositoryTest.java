package com.intellipro.customer.journey.demo.repository;

import com.intellipro.customer.journey.demo.entity.Audience;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AudienceRepositoryTest {

    @Autowired
    AudienceRepository audienceRepository;

    @Test
    public void saveAudience() {

        Audience audience = Audience.builder()
                .email("meat.ball@gmail.com")
                .first_name("meat")
                .last_name("ball")
                .build();

        audienceRepository.save(audience);
    }

    @Test
    public void saveAudience2() {

        Audience audience = Audience.builder()
                .email("A.B@gmail.com")
                .first_name("A")
                .last_name("B")
                .build();

        audienceRepository.save(audience);
    }

}