package com.intellipro.customer.journey.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CoreModuleTask {

    @Id
    @SequenceGenerator(
            name = "task_sequence",
            sequenceName = "task_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "task_sequence"
    )
    private long taskId;

    private String type;
    private String name;
    private Long nodeId;
    private Long journeyId;
    private Long userId;
    private Long targetNodeId;
    @ElementCollection
    private List<Integer> ActiveAudienceId1;
    @ElementCollection
    private List<Long> AudienceID1;
    @ElementCollection
    private List<Long> AudienceID2;
    private int makenext = 1;
    private int callapi = 1;
    private int taskType;
}