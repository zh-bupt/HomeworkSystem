package com.bupt.se.homework.bo.impl;

import com.bupt.se.homework.bo.BasicBo;
import com.bupt.se.homework.dao.BasicDao;
import com.bupt.se.homework.entity.AbstractEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @description: BasicBo 实现类
 * @author: zh
 * @create: 2018-11-13 15:12
 **/
@Transactional
@Service
public abstract class BasicBoImpl<M extends AbstractEntity, PK extends Serializable> implements BasicBo<M, PK> {

    protected BasicDao<M, PK> basicDao;

    protected HibernateTransactionManager transactionManager;

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    @Qualifier("transactionManager")
    public void setTransactionManager(HibernateTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public HibernateTransactionManager getTransactionManager() {
        return transactionManager;
    }

    public void setBasicDao(BasicDao<M, PK> basicDao) {
        this.basicDao = basicDao;
    }

    @Transactional
    @Override
    public void save(M model) {
//        TransactionStatus status = getTransactionStatus();
//        try {
            basicDao.save(model);
//            getTransactionManager().commit(status);
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
    }

    @Transactional
    @Override
    public boolean merge(M model) {
//        TransactionStatus status = getTransactionStatus();
//        try {
            basicDao.merge(model);
//            getTransactionManager().commit(status);
            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
    }

    @Transactional
    @Override
    public void delete(PK key) {
//        TransactionStatus status = getTransactionStatus();
//        try {
            basicDao.delete(key);
//            getTransactionManager().commit(status);
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
    }

    @Transactional
    @Override
    public boolean deleteArray(PK[] id) {
//        TransactionStatus status = getTransactionStatus();
//        try {
            basicDao.deleteArray(id);
//            getTransactionManager().commit(status);
            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
    }

    @Transactional
    @Override
    public boolean exists(PK key) {
        return basicDao.exists(key);
    }

    @Transactional
    @Override
    public boolean deleteObject(M model) {
//        TransactionStatus status = getTransactionStatus();
//        try {
            basicDao.deleteObject(model);
//            getTransactionManager().commit(status);
            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
    }

    @Transactional
    @Override
    public boolean deleteObjectList(List<M> list) {
//        TransactionStatus status = getTransactionStatus();
//        try {
            basicDao.deleteObjectList(list);
//            getTransactionManager().commit(status);
            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
    }

    @Transactional
    @Override
    public void update(M model) {
//        TransactionStatus status = getTransactionStatus();
//        try {
            basicDao.update(model);
//            getTransactionManager().commit(status);
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void save(List<M> models) {
//        TransactionStatus status = getTransactionStatus();
//        try {
            basicDao.save(models);
//            getTransactionManager().commit(status);
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
    }

    @Override
    @Transactional(readOnly = true)
    public M get(PK key) {
        return basicDao.get(key);
    }

    @Override
    @Transactional(readOnly = true)
    public M load(PK key) {
        return basicDao.load(key);
    }

    @Override
    @Transactional
    public List<M> getList (
            LinkedHashMap<Object, Object> equalFields,
            LinkedHashMap<Object, Object> notEqualFields,
            LinkedHashMap<String, String> LikeFields,
            LinkedHashMap<String, String> nullFields,
            LinkedHashMap<String, String> orderByFields,
            String whereHql,
            int firstResult, int maxResult) {
//        TransactionStatus status = getTransactionStatus();
        List<M> list = null;
//        try {
            list = basicDao.findResultList(
                    equalFields, notEqualFields, LikeFields, nullFields, orderByFields, whereHql, firstResult, maxResult);
//            getTransactionManager().commit(status);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return list;
    }

    @Transactional
    @Override
    public M get(
            LinkedHashMap<Object, Object> equalFields,
            LinkedHashMap<Object, Object> notEqualFields,
            LinkedHashMap<String, String> LikeFields,
            LinkedHashMap<String, String> nullFields,
            String whereHql
    ) {
//        TransactionStatus status = getTransactionStatus();
        M m = null;
//        try {
            m = basicDao.get(equalFields, notEqualFields, LikeFields, nullFields, whereHql);
//            getTransactionManager().commit(status);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return m;
    }

    protected TransactionStatus getTransactionStatus() {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        return getTransactionManager().getTransaction(def);
    }

    protected void commitSession() {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        TransactionStatus status = getTransactionManager().getTransaction(def);
        getTransactionManager().commit(status);
    }

    protected void rollbackSession() {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        TransactionStatus status = getTransactionManager().getTransaction(def);
        getTransactionManager().rollback(status);
    }
}
