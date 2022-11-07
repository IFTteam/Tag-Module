package com.intellipro.customer.journey.demo.service;

import com.intellipro.customer.journey.demo.entity.Audience;
import com.intellipro.customer.journey.demo.entity.Journey;
import com.intellipro.customer.journey.demo.entity.Tag;
import com.intellipro.customer.journey.demo.entity.User;
import com.intellipro.customer.journey.demo.error.AudienceNotFoundException;
import com.intellipro.customer.journey.demo.error.JourneyNotFoundException;
import com.intellipro.customer.journey.demo.error.UserNotFoundException;
import com.intellipro.customer.journey.demo.repository.AudienceRepository;
import com.intellipro.customer.journey.demo.repository.JourneyRepository;
import com.intellipro.customer.journey.demo.repository.TagRepository;
import com.intellipro.customer.journey.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TagServiceImpl implements TagService{
    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JourneyRepository journeyRepository;

    @Autowired
    private AudienceRepository audienceRepository;

    @Override
    public List<Tag> getDistinctTagByUser(Long userId) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(userId);

        if (!user.isPresent()) {
            throw new UserNotFoundException("User Not Available");
        }
        User real_user = user.get();
        // User user = userRepository.findById(userId).get();

        List<Tag> tagList = tagRepository.getTagByUser(real_user);
        List<String> tagNameResultList = new ArrayList<>();
        List<Tag> resultList = new ArrayList<>();
        for(Tag t : tagList) {
            if(!tagNameResultList.contains(t.getTag_name())) {
                tagNameResultList.add(t.getTag_name());
                resultList.add(t);
            }
        }
        return resultList;
    }

    @Override
    public Tag saveTagWithUserAndJourney(long userId, long journeyId, Tag tag) {
        User user = userRepository.findById(userId);
        Journey journey = journeyRepository.findById(journeyId);
        String tag_name = tag.getTag_name();
        Tag new_tag = Tag.builder()
                .tag_name(tag_name)
                .user(user)
                .journey(journey)
                .build();
        return tagRepository.save(new_tag);
    }

    @Override
    public List<Tag> getTagAndJourneyByAudience(Long audienceId) throws AudienceNotFoundException {
        Optional<Audience> audience = audienceRepository.findById(audienceId);

        if (!audience.isPresent()) {
            throw new AudienceNotFoundException("Audience Not Available");
        }

        Audience real_audience = audience.get();

        // Audience audience = audienceRepository.findById(audienceId).get();
        List<Tag> tagList = real_audience.getTags();
        return tagList;
    }


}
