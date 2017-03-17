package com.dao.base.domain;


import com.dao.base.data.Page;

import java.util.List;

/**
 * Created by dzx on 2016/10/25.
 */
public interface EntityDao<T> {
    List<T> findByPage(Page<T> t);
    Long getTotal(Page<T> t);
    void insert(T t);
    T findById(T t);
    List<T> findAll();
    void update(T t);
}
