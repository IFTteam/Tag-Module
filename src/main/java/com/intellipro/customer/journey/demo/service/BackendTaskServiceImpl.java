package com.intellipro.customer.journey.demo.service;

import com.intellipro.customer.journey.demo.entity.Audience;
import com.intellipro.customer.journey.demo.entity.CoreModuleTask;
import com.intellipro.customer.journey.demo.entity.Tag;
import com.intellipro.customer.journey.demo.repository.AudienceRepository;
import com.intellipro.customer.journey.demo.repository.TagRepository;
import com.intellipro.customer.journey.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BackendTaskServiceImpl implements BackendTaskService {

    @Autowired
    private AudienceRepository audienceRepository;
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TagRepository tagRepository;

    @Override
    public CoreModuleTask createRelationBetweenAudienceAndTag(CoreModuleTask coreModuleTask) {
        String json_text = coreModuleTask.getName();
        String find = "tagId";
        String substr = "";
        int i  = json_text.indexOf(find);
        substr = json_text.substring(i + find.length() + 3, json_text.length() - 1);
        Long tagId =  Long.parseLong(substr);
        Optional<Tag> tag = tagRepository.findById(tagId);



        Tag real_tag = tag.get();


        List<Integer> audienceIds = coreModuleTask.getActiveAudienceId1();
        for (Integer audienceId : audienceIds) {
            Long l = new Long(audienceId);
            Optional<Audience> audience = audienceRepository.findById(l);


            Audience real_audience = audience.get();


            // Audience audience = audienceRepository.findById(audienceId).get();
            // Tag tag = tagRepository.findById(tagId).get();
            real_audience.addTags(real_tag);
            audienceRepository.save(real_audience);
        }
        CoreModuleTask newTask = coreModuleTask;
        List a = newTask.getAudienceID1();
        List b = newTask.getAudienceID2();
        newTask.setAudienceID1(a);
        newTask.setAudienceID2(b);
        //jiaqi:这里为了确保task的状态，还是要手动的set一下makenext为1来确保return之后下一个task会被task coordinator的CMTexecutor制作
        newTask.setMakenext(1);
        newTask.setTaskType(1);
        return newTask;
    }
}
