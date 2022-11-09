package com.intellipro.customer.journey.demo.service;

import com.intellipro.customer.journey.demo.entity.Audience;
import com.intellipro.customer.journey.demo.error.AudienceNotFoundException;
import com.intellipro.customer.journey.demo.error.TagNotFoundException;
import com.intellipro.customer.journey.demo.error.UserNotFoundException;

import java.util.List;

public interface FrontendAudienceService {
    List<Audience> getAudienceAndTagByUser(Long userId) throws UserNotFoundException;

    Audience createRelationBetweenAudienceAndTag(Long audienceId, Long tagId) throws AudienceNotFoundException, TagNotFoundException;
}
