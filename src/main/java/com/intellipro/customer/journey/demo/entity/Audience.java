package com.intellipro.customer.journey.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Audience {
    @Id
    @SequenceGenerator(
            name = "audience_sequence",
            sequenceName = "audience_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "audience_sequence"
    )
    private long audienceId;

    private String email;
    private String first_name;
    private String last_name;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "userId"
    )
    private User user;

    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "map",
            joinColumns = @JoinColumn(
                    name = "audience_id",
                    referencedColumnName = "audienceId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "tag_id",
                    referencedColumnName = "tagId"
            )
    )
    private List<Tag> tags;

    public void addTags(Tag tag){
        if(tags == null) tags = new ArrayList<>();
        tags.add(tag);
    }
}
