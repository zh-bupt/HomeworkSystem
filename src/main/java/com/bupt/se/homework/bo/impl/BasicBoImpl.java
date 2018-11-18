package com.bupt.se.homework.bo.impl;

import com.bupt.se.homework.bo.BasicBo;
import com.bupt.se.homework.dao.BasicDao;
import java.io.Serializable;
import java.util.LinkedHashMap;
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

    @Override
    public M get(PK key) {
        return basicDao.get(key);
    }

    @Override
    public M load(PK key) {
        return basicDao.load(key);
    }

    @Override
    public List<M> getList (
            LinkedHashMap<Object, Object> equalFields,
            LinkedHashMap<Object, Object> notEqualFields,
            LinkedHashMap<String, String> LikeFields,
            LinkedHashMap<String, String> nullFields,
            LinkedHashMap<String, String> orderByFields,
            String whereHql,
            int firstResult, int maxResult) {
        return basicDao.findResultList(
                equalFields, notEqualFields, LikeFields, nullFields, orderByFields, whereHql, firstResult, maxResult
        );
    }

    @Override
    public M get(
            LinkedHashMap<Object, Object> equalFields,
            LinkedHashMap<Object, Object> notEqualFields,
            LinkedHashMap<String, String> LikeFields,
            LinkedHashMap<String, String> nullFields,
            String whereHql
    ) {
        return basicDao.get(equalFields, notEqualFields, LikeFields, nullFields, whereHql);
    }
}
