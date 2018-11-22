package com.bupt.se.homework.bo;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

public interface BasicBo<M extends Serializable, PK extends Serializable> {
    boolean save(M model);

    boolean save(List<M> models);

    boolean delete(PK key);

    boolean deleteArray(PK id[]);

    boolean update(M model);

    boolean merge(M model);

    M get(PK key);

    M load(PK key);



    M get(
            LinkedHashMap<Object, Object> equalFields,
            LinkedHashMap<Object, Object> notEqualFields,
            LinkedHashMap<String, String> LikeFields,
            LinkedHashMap<String, String> nullFields,
            String whereHql
    );

    List<M> getList(
            LinkedHashMap<Object, Object> equalFields,
            LinkedHashMap<Object, Object> notEqualFields,
            LinkedHashMap<String, String> LikeFields,
            LinkedHashMap<String, String> nullFields,
            LinkedHashMap<String, String> orderByFields, String whereHql,
            int firstResult, int maxResult
    );
}
