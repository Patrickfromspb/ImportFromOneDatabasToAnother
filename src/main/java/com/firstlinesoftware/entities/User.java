package com.firstlinesoftware.entities;

import org.apache.commons.lang3.RandomStringUtils;
import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = User.TABLE_NAME)
public class User {

    static final String TABLE_NAME = "users";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "topic", nullable = false)
    private String topic;

    @Column(name = "partition", nullable = false)
    private Long partition;

    @Column(name = "offses", nullable = false)
    private Long offset;

    public User() {
        this.topic=RandomStringUtils.randomAlphabetic(10,20);
        this.partition= new Random(10000).nextLong();
        this.offset= new Random(100000).nextLong();
    }

    public User(final String topic, final Long partition, final Long offset) {
        this.topic = topic;
        this.partition = partition;
        this.offset = offset;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(final String topic) {
        this.topic = topic;
    }

    public Long getPartition() {
        return partition;
    }

    public void setPartition(final Long partition) {
        this.partition = partition;
    }

    public Long getOffset() {
        return offset;
    }

    public void setOffset(final Long offset) {
        this.offset = offset;
    }


}
