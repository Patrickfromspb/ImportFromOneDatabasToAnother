package com.company.entities;

import javax.persistence.*;

@Entity
@Table(name = User2.TABLE_NAME)
public class User2 {

    static final String TABLE_NAME = "users2";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "old_id", nullable = false)
    private Integer oldId;

    @Column(name = "topic", nullable = false)
    private String topic;

    @Column(name = "partition", nullable = false)
    private Long partition;

    @Column(name = "offses", nullable = false)
    private Long offset;

    public User2(TemporaryUser user) {
        this.oldId=user.getId();
        this.topic = user.getTopic();
        this.partition = user.getPartition();
        this.offset = user.getOffset();
    }
    public Integer getOldId() {
        return oldId;
    }

    public void setOldId(final Integer oldId) {
        this.oldId = oldId;
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