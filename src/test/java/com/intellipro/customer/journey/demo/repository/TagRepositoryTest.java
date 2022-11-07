package com.intellipro.customer.journey.demo.repository;

import com.intellipro.customer.journey.demo.entity.Audience;
import com.intellipro.customer.journey.demo.entity.Journey;
import com.intellipro.customer.journey.demo.entity.Tag;
import com.intellipro.customer.journey.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TagRepositoryTest {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JourneyRepository journeyRepository;

    // Task 3 and 4, create/select tag, input user_id, journey_id, tag_name, no output
    @Test
    public void saveTagWithUserAndJourney(){
        User user = User.builder()
                .username("test")
                .build();

        Journey journey = Journey.builder()
                .journeyName("test")
                .build();

        Tag tag = Tag.builder()
                .tag_name("test")
                .user(user)
                .journey(journey)
                .build();

        tagRepository.save(tag);
    }



    @Test
    public void saveDifferentTagWithSameUser() {
        Tag tag = tagRepository.findById(8L);
        System.out.println("Tag = " + tag);
        User user = userRepository.findById(1L);
        tag.setUser(user);
        tagRepository.save(tag);
    }


    @Test
    public void saveTag(){
        Tag tag = Tag.builder()
                .tag_name("woof")
                .build();
        tagRepository.save(tag);
    }

    @Test
    public void sameTagNameWithSameUser() {
        Tag tag = tagRepository.findById(10L);
        User user = userRepository.findById(1L);
        Journey journey = journeyRepository.findById(2L);

        tag.setUser(user);
        tag.setJourney(journey);
        tagRepository.save(tag);
    }



    // Task 2, input is user_id, change return to Tag object
    @Test
    public void printDistinctTagByUser() {
        User user = userRepository.findById(1L);
        List<Tag> tagList = tagRepository.getTagByUser(user);
        List<String> tagNameResultList = new ArrayList<>();
        List<Tag> resultList = new ArrayList<>();
        for(Tag t : tagList) {
            if(!tagNameResultList.contains(t.getTag_name())) {
                tagNameResultList.add(t.getTag_name());
                resultList.add(t);
            }
        }
        System.out.println("List = " + resultList);

    }

}