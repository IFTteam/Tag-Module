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
class AudienceRepositoryTest {

    @Autowired
    private AudienceRepository audienceRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TagRepository tagRepository;


    @Test
    public void saveAudienceWithTagUserAndJourney() {

        User user = User.builder()
                .username("Food")
                .build();

        Journey journey = Journey.builder()
                .journeyName("meat")
                .build();

        Tag tag = Tag.builder()
                .tag_name("hhhhh")
                .user(user)
                .journey(journey)
                .build();


        Audience audience = Audience.builder()
                .email("meat.ball@gmail.com")
                .first_name("meat")
                .last_name("ball")
                .user(user)
                .build();

        audience.addTags(tag);

        audienceRepository.save(audience);
    }

    @Test
    public void saveAudienceWithUser() {

//        User user = User.builder()
//                .username("Food")
//                .build();

        User user = userRepository.findById(1L);


//        Audience audience = Audience.builder()
//                .email("meat.ball@gmail.com")
//                .first_name("meat")
//                .last_name("ball")
              //  .user(user)
//                .build();

//        Audience audience = Audience.builder()
//                .email("A.B@gmail.com")
//                .first_name("A")
//                .last_name("B")
//                //  .user(user)
//                .build();


//        audienceRepository.save(audience);
    }

    // Task 1, input is user_id, change return to Audience object
    @Test
    public void printAudienceAndTagByUser() {
        User user = userRepository.findById(1L);
        List<Audience> audienceList = audienceRepository.getAudienceByUser(user);
        for(Audience a : audienceList) {
            System.out.println("Audience Name = " + a);
            List<Tag> tagList = a.getTags();
            for(Tag t : tagList) {
                System.out.println("Tag = " + t);
            }
        }
    }

    // Task 2, input is user_id, change return to Tag object (abandon)
    @Test
    public void printDistinctTagByUser() {
        User user = userRepository.findById(1L);
        List<Audience> audienceList = audienceRepository.getAudienceByUser(user);
        List<String> TagNameList = new ArrayList<>();
        for(Audience a : audienceList) {
            List<Tag> tagList = a.getTags();
            for(Tag t : tagList) {
                TagNameList.add(t.getTag_name());
            }
        }
        List<String> distinctTagList = TagNameList.stream().distinct().collect(Collectors.toList());
        for(String tName : distinctTagList) {
            System.out.println("User have tags: " + tName);
        }
    }

    // Task 5, input is audience_id, change to return Tag Object
    @Test
    public void printTagAndJourneyByAudience(){
        Audience audience = audienceRepository.findById(1L);
        List<Tag> tagList = audience.getTags();
        for(Tag t : tagList) {
            System.out.println("Tag = " + t.getTag_name());
            System.out.println("Journey = " + t.getJourney().getJourneyName());
        }
    }

    // Task 6, input is audience_id, tag_id, no output
    @Test
    public void createRelationBetweenAudienceAndTag() {
        Audience audience = audienceRepository.findById(1L);
        Tag tag = tagRepository.findById(2L);
        audience.addTags(tag);
        audienceRepository.save(audience);
    }
}