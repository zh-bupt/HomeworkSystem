package com.bupt.se.homework.dao.impl;

import com.bupt.se.homework.dao.BasicDao;
import com.bupt.se.homework.dao.GroupDAO;
import com.bupt.se.homework.entity.Group_;
import org.springframework.stereotype.Repository;

/**
 * @ClassName: GroupDAOImpl
 * @Description: TODO
 * @Author: kwong
 * @Create: 2018/11/22 21:29
 **/
@Repository("groupDAO")
public class GroupDAOImpl extends BasicDAOImpl<Group_, String> implements GroupDAO {
}
