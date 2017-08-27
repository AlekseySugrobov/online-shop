package ru.winzdoor.onlineshoppingbackend.dao;

import ru.winzdoor.onlineshoppingbackend.dto.Category;

import java.util.List;

public interface CategoryDAO {
    List<Category> list();
    Category get(int id);
}
