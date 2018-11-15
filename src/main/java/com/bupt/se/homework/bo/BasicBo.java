package com.bupt.se.homework.bo;

import java.io.Serializable;
import java.util.List;

public interface BasicBo<M extends Serializable, PK extends Serializable> {
    boolean save(M model);

    boolean save(List<M> models);

    boolean delete(PK key);

    boolean update(M model);
}
