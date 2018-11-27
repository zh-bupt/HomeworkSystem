package com.bupt.se.homework.bo;

import com.bupt.se.homework.entity.Homework;

public interface HomeworkBo extends BasicBo<Homework, Integer> {
//    void addHomework(Homework homework) throws Exception;

    void updateHomework(Homework homework) throws Exception;

    Homework getHomework(int homeworkId);
}
