package com.intellipro.customer.journey.demo.repository;

import com.intellipro.customer.journey.demo.entity.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TagRepositoryTest {

    @Autowired
    TagRepository tagRepository;

    @Test
    public void saveTag(){
        Tag tag = Tag.builder()
                .tag_name("test")
                .build();
        tagRepository.save(tag);
    }
}