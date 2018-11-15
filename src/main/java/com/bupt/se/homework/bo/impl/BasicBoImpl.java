package com.bupt.se.homework.bo.impl;

import com.bupt.se.homework.bo.BasicBo;
import com.bupt.se.homework.dao.BasicDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * @description: BasicBo 实现类
 * @author: zh
 * @create: 2018-11-13 15:12
 **/
public abstract class BasicBoImpl<M extends Serializable, PK extends Serializable> implements BasicBo<M, PK> {

    protected BasicDao<M, PK> basicDao;

    public void setBasicDao(BasicDao<M, PK> basicDao) {
        this.basicDao = basicDao;
    }

    @Override
    public boolean save(M model) {
        return basicDao.save(model);
    }

    @Override
    public boolean delete(PK key) {
        return basicDao.delete(key);
    }

    @Override
    public boolean update(M model) {
        return basicDao.update(model);
    }

    @Override
    public boolean save(List<M> models) {
        return basicDao.save(models);
    }
}
