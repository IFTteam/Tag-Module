package com.intellipro.customer.journey.demo.controller;

import com.intellipro.customer.journey.demo.entity.CoreModuleTask;
import com.intellipro.customer.journey.demo.service.BackendTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BackendTaskController {

    @Autowired
    private BackendTaskService backendTaskService;

    @PostMapping("/coreTask")
    public CoreModuleTask createRelationBetweenAudienceAndTag(@RequestBody CoreModuleTask coreModuleTask) {
        return backendTaskService.createRelationBetweenAudienceAndTag(coreModuleTask);
    }
}
