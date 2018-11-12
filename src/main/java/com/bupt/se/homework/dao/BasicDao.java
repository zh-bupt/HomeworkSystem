package com.bupt.se.homework.dao;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by JiaLin on 2014/5/23.
 */
public interface BasicDao<M extends java.io.Serializable, PK extends java.io.Serializable>{
    //基本CRUD
    boolean save(M model);

    boolean save(List<M> list);

    public boolean update(M model);

//    public void merge(M model);

    public boolean delete(PK id) ;

//    public void deleteObject(M model) ;

    public void deleteObjectList(List<M> list);

//    public void delete(Class<?> entityClass, LinkedHashMap<Object, Object> equalFields,
//                       String whereJpql);

    boolean deleteArray(PK id[]) ;

    boolean exists(PK id);

    M get(PK id);

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

