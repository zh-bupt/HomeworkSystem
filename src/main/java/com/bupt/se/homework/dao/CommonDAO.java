package com.bupt.se.homework.dao;

public interface CommonDAO {
    <E> boolean add(E e);

    <E> boolean delete(E e);
}
