package ru.winzdoor.onlineshoppingbackend.dao;

import ru.winzdoor.onlineshoppingbackend.dto.Category;

import java.util.List;

public interface CategoryDAO {
    Category get(long id);
    List list();
    boolean add(Category category);
    boolean update(Category category);
    boolean delete(Category category);
}
