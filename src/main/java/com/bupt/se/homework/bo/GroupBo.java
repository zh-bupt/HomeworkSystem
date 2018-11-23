package com.bupt.se.homework.bo;

import com.bupt.se.homework.entity.Group_;

public interface GroupBo extends BasicBo<Group_, String> {
    void calculateScore(Group_ group_);
}
