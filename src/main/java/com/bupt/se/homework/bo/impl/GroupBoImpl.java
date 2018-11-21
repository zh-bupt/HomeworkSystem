package com.bupt.se.homework.bo.impl;

import com.bupt.se.homework.bo.GroupBo;
import com.bupt.se.homework.entity.Group_;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @author: zh
 * @create: 2018-11-16 15:07
 **/
@Service("groupBo")
@Transactional
public class GroupBoImpl extends BasicBoImpl<Group_, String> implements GroupBo {
}
