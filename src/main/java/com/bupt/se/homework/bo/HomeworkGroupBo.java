package com.bupt.se.homework.bo;

import com.bupt.se.homework.entity.HomeworkGroup;
import com.bupt.se.homework.entity.HomeworkGroupPK;

public interface HomeworkGroupBo extends BasicBo<HomeworkGroup, HomeworkGroupPK> {
    boolean setScore(int homeworkId, String groupId, int score);
}
