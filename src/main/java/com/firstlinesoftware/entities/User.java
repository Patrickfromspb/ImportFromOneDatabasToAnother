package com.firstlinesoftware.entities;


import javax.persistence.*;

@Entity
@Table(name = User.TABLE_NAME)
public class User {

    static final String TABLE_NAME = "users";
    private static final String SEQ_NAME = "seq_" + TABLE_NAME;

    @Id
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    @GeneratedValue(generator = SEQ_NAME, strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "topic", nullable = false)
    private String topic;

    @Column(name = "partition", nullable = false)
    private Long partition;

    @Column(name = "esb_offset", nullable = false)
    private Long offset;

    public User() {
    }

    public User(final String topic, final Long partition, final Long offset) {
        this.topic = topic;
        this.partition = partition;
        this.offset = offset;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
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
