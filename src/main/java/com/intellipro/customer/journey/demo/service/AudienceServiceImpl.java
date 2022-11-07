package com.intellipro.customer.journey.demo.service;

import com.intellipro.customer.journey.demo.entity.Audience;
import com.intellipro.customer.journey.demo.entity.Tag;
import com.intellipro.customer.journey.demo.entity.User;
import com.intellipro.customer.journey.demo.error.AudienceNotFoundException;
import com.intellipro.customer.journey.demo.error.TagNotFoundException;
import com.intellipro.customer.journey.demo.error.UserNotFoundException;
import com.intellipro.customer.journey.demo.repository.AudienceRepository;
import com.intellipro.customer.journey.demo.repository.TagRepository;
import com.intellipro.customer.journey.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AudienceServiceImpl implements AudienceService{
    @Autowired
    private AudienceRepository audienceRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TagRepository tagRepository;

    @Override
    public List<Audience> getAudienceAndTagByUser(Long userId) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(userId);

        if (!user.isPresent()) {
            throw new UserNotFoundException("User Not Available");
        }
        User real_user = user.get();
        // User user = userRepository.findById(userId).get();

        List<Audience> audienceList = audienceRepository.getAudienceByUser(real_user);
        return audienceList;
    }

    @Override
    public Audience createRelationBetweenAudienceAndTag(Long audienceId, Long tagId) throws AudienceNotFoundException, TagNotFoundException {
        Optional<Audience> audience = audienceRepository.findById(audienceId);

        if (!audience.isPresent()) {
            throw new AudienceNotFoundException("Audience Not Available");
        }

        Audience real_audience = audience.get();

        Optional<Tag> tag = tagRepository.findById(tagId);

        if (!tag.isPresent()) {
            throw new TagNotFoundException("Tag Not Available");
        }

        Tag real_tag = tag.get();

        // Audience audience = audienceRepository.findById(audienceId).get();
        // Tag tag = tagRepository.findById(tagId).get();
        real_audience.addTags(real_tag);
        return audienceRepository.save(real_audience);
    }


}
