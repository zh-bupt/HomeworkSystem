package com.bupt.se.homework.dao.impl;

import com.bupt.se.homework.dao.GroupDAO;
import com.bupt.se.homework.entity.Group_;
import org.springframework.stereotype.Repository;

/**
 * @description: groupDao 实现类
 * @author: zh
 * @create: 2018-11-22 16:08
 **/
@Repository("groupDAO")
public class GroupDAOImpl extends BasicDAOImpl<Group_, String> implements GroupDAO {
}
