package ru.winzdoor.onlineshoppingbackend.dao;

import ru.winzdoor.onlineshoppingbackend.dto.Product;

import java.util.List;

public interface ProductDAO {
    Product get(long productId);
    List<Product> list();
    boolean add(Product product);
    boolean update(Product product);
    boolean delete(Product product);

    List<Product> listActiveProducts();
    List<Product> listActiveProductsByCategory(long categoryId);
    List<Product> getLatestActiveProducts(int count);
}
