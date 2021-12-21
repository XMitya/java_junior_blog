package ru.ifmo.blog.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    void save(T t) throws SQLException;
    Optional<T> get(Long id) throws SQLException;
    List<T> getAll() throws SQLException;
    boolean remove(Long id) throws SQLException;
    boolean removeAll() throws SQLException;
}
