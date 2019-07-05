package com.dharbor.set.dummy.hashtag.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author rvasquez
 */
public class HashtagDTO {

    @JsonProperty("Tag")
    private String tag;

    private Integer usage;

    private String keyword;

    @JsonProperty("EntityID")
    private String entityId;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getUsage() {
        return usage;
    }

    public void setUsage(Integer usage) {
        this.usage = usage;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }
}
