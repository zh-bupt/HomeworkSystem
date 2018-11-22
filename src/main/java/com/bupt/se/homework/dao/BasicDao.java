package com.bupt.se.homework.dao;

import com.bupt.se.homework.entity.AbstractEntity;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @Description: Basic class of DAO
 * @Author: zh
 * @Date: 2018/11/10
 **/
public interface BasicDao<M extends AbstractEntity, PK extends Serializable>{

    void save(M model);

    void save(List<M> list);

    void update(M model);

//    public void merge(M model);

    void delete(PK id) ;

    void deleteObject(M model) ;

    void deleteObjectList(List<M> list);

//    public void delete(Class<?> entityClass, LinkedHashMap<Object, Object> equalFields,
//                       String whereJpql);

    void deleteArray(PK id[]);

    boolean exists(PK id);

    M get(PK id);

    M load(PK id);

    M get(LinkedHashMap<Object, Object> equalFields,
          LinkedHashMap<Object, Object> notEqualFields,
          LinkedHashMap<String, String> LikeFields,
          LinkedHashMap<String, String> nullFields, String whereHql
    );
//
//
//    public List<M> findResultList(LinkedHashMap<Object, Object> equalFields,
//                                  LinkedHashMap<Object, Object> notEqualFields,
//                                  LinkedHashMap<String, String> LikeFields,
//                                  LinkedHashMap<String, String> nullFields,
//                                  LinkedHashMap<String, String> orderByFields, String whereHql);
//
//    public  Long getTotalCount(
//            LinkedHashMap<Object, Object> equalFields,
//            LinkedHashMap<Object, Object> notEqualFields,
//            LinkedHashMap<String, String> LikeFields,
//            LinkedHashMap<String, String> nullFields, String whereJpql) ;
//
    List<M> findResultList(
            LinkedHashMap<Object, Object> equalFields,
            LinkedHashMap<Object, Object> notEqualFields,
            LinkedHashMap<String, String> LikeFields,
            LinkedHashMap<String, String> nullFields,
            LinkedHashMap<String, String> orderByFields, String whereHql,
            int firstResult, int maxResult
    );

}

