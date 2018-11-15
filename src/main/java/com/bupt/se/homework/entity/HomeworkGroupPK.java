package com.bupt.se.homework.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class HomeworkGroupPK implements Serializable {
    private String groupId;
    private int homeworkId;

    public HomeworkGroupPK() {
    }

    @Column(name = "groupId", length = 10)
    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Column(name = "homeworkId", length = 10)
    public int getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(int homeworkId) {
        this.homeworkId = homeworkId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomeworkGroupPK that = (HomeworkGroupPK) o;
        return homeworkId == that.homeworkId &&
                Objects.equals(groupId, that.groupId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(groupId, homeworkId);
    }
}
