package com.bupt.se.homework.dao.impl;

import com.bupt.se.homework.dao.HibernateDaoUtil;
import com.bupt.se.homework.dao.BasicDao;
import com.bupt.se.homework.entity.AbstractEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @description: basic dao 实现类
 * @author: zh
 * @create: 2018-11-10 16:36
 **/
@Repository
public abstract class BasicDAOImpl<M extends AbstractEntity, PK extends Serializable> implements BasicDao<M, PK> {

    private SessionFactory sessionFactory;

    protected Logger logger = LogManager.getLogger(getClass());

    @Autowired
    @Qualifier("sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    private final Class<Serializable> entityClass;

    public BasicDAOImpl() {
        this.entityClass = (Class<Serializable>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * @Description: 保存一个entity 对象
     * @param model
     * @return: boolean
     * @Author: zh
     * @Date: 2018/11/10
     **/
    @Override
    public void save(M model) {
        getSession().save(model);
//        Session session = getSession();
//        Transaction transaction = null;
//        try{
//            transaction = session.beginTransaction();
//            session.save(model);
//            transaction.commit();
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            transaction.rollback();
//            return false;
//        }
    }

    /**
     * @Description: 批量添加
     * @param list
     * @return: boolean
     * @Author: zh
     * @Date: 2018/11/11
     **/
    @Override
    public void save(List<M> list) {
        Session session = getSession();
        int count = 1;
        for (M model:list) {
            session.save(model);
            count++;
            if (count % 20 == 0) {
                session.flush();
                session.clear();
            }
        }
//        Session session = getSession();
//        Transaction transaction = null;
//        try {
//            transaction = session.beginTransaction();
//            int count = 1;
//            for (M model:list) {
//                session.save(model);
//                count ++;
//                if (count % 20 == 0) {
//                    session.flush();
//                    session.clear();
//                }
//            }
//            transaction.commit();
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            transaction.rollback();
//            return false;
//        }
    }

    /**
     * @Description: 更新
     * @param model
     * @return: void
     * @Author: zh
     * @Date: 2018/11/10
     **/
    @Override
    public void update(M model) {
        getSession().update(model);
//        Session session = getSession();
//        Transaction transaction = null;
//        try{
//            transaction = session.beginTransaction();
//            session.update(model);
//            transaction.commit();
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            transaction.rollback();
//            return false;
//        }
    }

    @Override
    public void saveOrUpdate(M model) {
        getSession().saveOrUpdate(model);
    }

    @Override
    public void merge(M model) {
        getSession().merge(model);
    }

    /**
     * @Description: 通过主键删除对象信息
     * @param id
     * @return: boolean
     * @Author: zh
     * @Date: 2018/11/10
     **/
    @Override
    public void delete(PK id) {
        Session session = getSession();
        M entity = (M) session.get(this.entityClass, id);
        entity.preRemove();
        session.delete(entity);
//        Session session = getSession();
//        Transaction transaction = null;
//        try{
//            transaction = session.beginTransaction();
//            M entity = (M) session.get(this.entityClass,id);
//            session.delete(entity);
//            transaction.commit();
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            transaction.rollback();
//            return false;
//        }
    }

    /**
     * @Description: 批量删除
     * @param id
     * @return: boolean
     * @Author: zh
     * @Date: 2018/11/11
     **/
    @Override
    public void deleteArray(PK[] id) {
        if (id != null && id.length >0) {
            Session session = getSession();
            for (int i = 0; i < id.length; i++) {
                M m = (M) session.get(this.entityClass, id[i]);
                if (m == null) continue;
                m.preRemove();
                session.delete(m);
                if (i % 20 == 0) session.flush();
            }
        }
    }

    @Override
    public boolean exists(PK id) {
        return get(id) != null;
    }

    /**
     * @Description: 根据主键获取对象实例
     * @param id
     * @return: M
     * @Author: zh
     * @Date: 2018/11/10
     **/
    @Override
    public M get(PK id) {
        return (M) getSession().get(this.entityClass, id);
//        Session session = getSession();
//        Transaction transaction = null;
//        M entity = null;
//        try{
//            transaction = session.beginTransaction();
//            entity = (M) getSession().get(this.entityClass,id);
//            transaction.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            transaction.rollback();
//        }
//        return entity;
    }

    @Override
    public M load(PK id) {
        return (M) getSession().load(this.entityClass, id);
//        Session session = getSession();
//        Transaction transaction = null;
//        M entity = null;
//        try{
//            transaction = session.beginTransaction();
//            entity = (M) session.load(this.entityClass, id);
//            transaction.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            transaction.rollback();
//        }
//        return entity;
    }


    @Override
    public M get(LinkedHashMap<Object, Object> equalFields, LinkedHashMap<Object, Object> notEqualFields, LinkedHashMap<String, String> LikeFields, LinkedHashMap<String, String> nullFields, String whereHql) {
        // 获取实体名
        String entityName = entityClass.getSimpleName();
        Session session = getSession();
        M entity = null;
//        Transaction transaction = session.beginTransaction();
        String hql = "select o from "
                + entityName
                + " as o "
                + HibernateDaoUtil.
                buildWhereHql(equalFields, notEqualFields, LikeFields, nullFields, null, whereHql);
        logger.info(hql);
        Query query = session.createQuery(hql);

        // 给查询参数赋值
        query = HibernateDaoUtil.SetQueryParameter(query, equalFields, notEqualFields, LikeFields);

        //query.setHint("org.hibernate.cacheable", true);
        List list= query.list();
        if(list != null && list.size()>0) {
            entity = (M) query.list().get(0);
        }
//        transaction.commit();
        return entity;
    }

    @Override
    public void deleteObject(M model) {
        model.preRemove();
        getSession().delete(model);
    }

    @Override
    public void deleteObjectList(List<M> list) {
        Session session = getSession();
        int count = 0;
        for (M m:list) {
            m.preRemove();
            session.delete(m);
            count ++;
            if (count % 20 == 0) session.flush();
        }
    }

//    @Override
//    public void delete(Class entityClass, LinkedHashMap equalFields, String whereJpql) {
//        Query query = getSession().createQuery("delete from " + entityClass.getSimpleName()
//                + " as o "
//                + HibernateDaoUtil.buildWhereHql(equalFields, null, null, null, null, whereJpql));
//        query = HibernateDaoUtil.SetQueryParameter(query, equalFields, null, null);
//        query.executeUpdate();
//    }

    /**
     * @Description: 获取满足条件的所有对象
     * @param equalFields equal条件
     * @param notEqualFields not equal 条件
     * @param LikeFields like 条件
     * @param nullFields
     * @param orderByFields 排序依据
     * @param whereHql where语句
     * @param firstResult
     * @param maxResult
     * @return: java.util.List<M>
     * @Author: zh
     * @Date: 2018/11/10
     **/
    @Override
    public List<M> findResultList(
            LinkedHashMap<Object, Object> equalFields,
            LinkedHashMap<Object, Object> notEqualFields,
            LinkedHashMap<String, String> LikeFields,
            LinkedHashMap<String, String> nullFields,
            LinkedHashMap<String, String> orderByFields, String whereHql,
            int firstResult, int maxResult) {
        // 获取实体名
        String entityName = entityClass.getSimpleName();
        Session session = getSession();
//        Transaction transaction = session.beginTransaction();
        List<M> list = null;
        // 获得query，并构建查询条件，排序条件
        Query query = session.createQuery("select o from "
                + entityName
                + " as o "
                + HibernateDaoUtil.buildWhereHql(equalFields, notEqualFields, LikeFields, nullFields,
                orderByFields, whereHql));

        // 给查询参数赋值
        query = HibernateDaoUtil.SetQueryParameter(query, equalFields, notEqualFields, LikeFields);

        //query.setHint("org.hibernate.cacheable", true);

        // 分页条件
        if (maxResult != 0) {
            query.setMaxResults(maxResult).setFirstResult(firstResult);
        }

        // 查询，返回list
        list = query.list();
//        transaction.commit();
        return list;
    }

}
