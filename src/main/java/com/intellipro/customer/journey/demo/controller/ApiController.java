package com.intellipro.customer.journey.demo.controller;

import com.intellipro.customer.journey.demo.entity.CoreModuleTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    @Autowired
    private TaskController taskController;

    @PostMapping("/API_trigger")
    public CoreModuleTask redirect(@RequestBody CoreModuleTask task) {
        CoreModuleTask nullTask = new CoreModuleTask();
        nullTask.setName("nullTask");

        // {'tagId': XXX}

        String json_text = task.getName();

        if (json_text.contains("tagId")) {
//            String find = "tagId";
//            String substr = "";
//            int i  = json_text.indexOf(find);
//            substr = json_text.substring(i + find.length() + 3, json_text.length() - 1);
//            Long tagId =  Long.parseLong(substr);

            return taskController.createRelationBetweenAudienceAndTag(task);
        }
        return nullTask;
    }
}
