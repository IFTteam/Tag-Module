package com.intellipro.customer.journey.demo.service;

import com.intellipro.customer.journey.demo.entity.Tag;
import com.intellipro.customer.journey.demo.error.AudienceNotFoundException;
import com.intellipro.customer.journey.demo.error.UserNotFoundException;

import java.util.List;

public interface FrontendTagService {
    List<Tag> getDistinctTagByUser(Long userId) throws UserNotFoundException;

    Tag saveTagWithUserAndJourney(long userId, long journeyId, Tag tag);

    List<Tag> getTagAndJourneyByAudience(Long audienceId) throws AudienceNotFoundException;
}
