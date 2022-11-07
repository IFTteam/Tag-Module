package com.intellipro.customer.journey.demo.repository;

import com.intellipro.customer.journey.demo.entity.Audience;
import com.intellipro.customer.journey.demo.entity.Tag;
import com.intellipro.customer.journey.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

    Tag findById(long l);

    @Query("select t from Tag t where t.user = ?1")
    List<Tag> getTagByUser(User user);
}
