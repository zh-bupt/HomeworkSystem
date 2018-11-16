package com.bupt.se.homework.bo;

import com.bupt.se.homework.entity.Homework;

public interface HomeworkBo extends BasicBo<Homework, Integer> {
    boolean addHomework(Homework homework);
}
