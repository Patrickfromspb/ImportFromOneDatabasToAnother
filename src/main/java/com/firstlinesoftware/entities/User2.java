package com.firstlinesoftware.entities;




public class User2 {

    private Integer id;

    private Integer oldId;

    private String topic;

    private Long partition;

    private Long offset;

    public User2(final String topic, final int id , final Long partition, final Long offset) {
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

