package com.intellipro.customer.journey.demo.controller;

import com.intellipro.customer.journey.demo.entity.Tag;
import com.intellipro.customer.journey.demo.error.AudienceNotFoundException;
import com.intellipro.customer.journey.demo.error.UserNotFoundException;
import com.intellipro.customer.journey.demo.service.FrontendTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FrontendTagController {

    @Autowired
    private FrontendTagService frontendTagService;


    // Task 2, input is user_id, change return to Tag object
    @GetMapping("/tag/{id}")
    public List<Tag> getDistinctTagByUser(@PathVariable("id") Long userId) throws UserNotFoundException {
        return frontendTagService.getDistinctTagByUser(userId);
    }


    // Task 3 and 4, create/select tag, input user_id, journey_id, tag_name, no output
    @PostMapping("/tags/{user}/{journey}")
    public Tag saveTagWithUserAndJourney(@PathVariable("user")long userId, @PathVariable("journey")long journeyId, @RequestBody Tag tag) {
        return frontendTagService.saveTagWithUserAndJourney(userId, journeyId, tag);
    }


    // Task 5, input is audience_id, change to return Tag Object
    @GetMapping("/tags/audiences/{id}")
    public List<Tag> getTagAndJourneyByAudience(@PathVariable("id") Long audienceId) throws AudienceNotFoundException {
        return frontendTagService.getTagAndJourneyByAudience(audienceId);
    }
}
