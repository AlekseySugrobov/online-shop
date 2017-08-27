package ru.winzdoor.onlineshoppingbackend.daoimpl;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.winzdoor.onlineshoppingbackend.dao.ProductDAO;
import ru.winzdoor.onlineshoppingbackend.dto.Product;
import ru.winzdoor.onlineshoppingbackend.helper.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {
    @Autowired
    private SessionFactory sessionFactory;
    private List<Product> products = new ArrayList<>();

    @Override
    public Product get(long productId) {
        return sessionFactory.getCurrentSession().get(Product.class, productId);
    }

    @Override
    public List<Product> list() {
        String selectProducts = "FROM product";
        Query query = sessionFactory.getCurrentSession().createQuery(selectProducts);
        return query.getResultList();
    }

    @Override
    public boolean add(Product product) {
        return DatabaseHelper.add(sessionFactory, product);
    }

    @Override
    public boolean update(Product product) {
        return DatabaseHelper.update(sessionFactory, product);
    }

    @Override
    public boolean delete(Product product) {
        product.setActive(false);
        return update(product);
    }

    @Override
    public List<Product> listActiveProducts() {
        String selectActiveProducts = "FROM Product WHERE active=:active";
        return sessionFactory.getCurrentSession()
                .createQuery(selectActiveProducts, Product.class)
                .setParameter("active", true)
                .getResultList();
    }

    @Override
    public List<Product> listActiveProductsByCategory(long categoryId) {
        String selectActiveProductsByCategory = "FROM Product WHERE active=:active AND categoryId=:categoryId";
        return sessionFactory.getCurrentSession()
                .createQuery(selectActiveProductsByCategory, Product.class)
                .setParameter("active", true)
                .setParameter("categoryId", categoryId)
                .getResultList();
    }

    @Override
    public List<Product> getLatestActiveProducts(int count) {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Product active=:active ORDER BY id", Product.class)
                .setParameter("active", true)
                .setFirstResult(0)
                .setMaxResults(count)
                .getResultList();
    }
}
