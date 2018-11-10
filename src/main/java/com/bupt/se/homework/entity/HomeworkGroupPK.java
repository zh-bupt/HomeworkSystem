package com.bupt.se.homework.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class HomeworkGroupPK implements Serializable {
    private int groupId;
    private int homeworkId;

    @Column(name = "GROUP_ID")
    @Id
    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Column(name = "HOMEWORK_ID")
    @Id
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
        return groupId == that.groupId &&
                homeworkId == that.homeworkId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, homeworkId);
    }
}
