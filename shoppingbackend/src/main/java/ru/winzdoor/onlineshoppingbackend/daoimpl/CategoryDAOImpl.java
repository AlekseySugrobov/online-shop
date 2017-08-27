package ru.winzdoor.onlineshoppingbackend.daoimpl;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.winzdoor.onlineshoppingbackend.dao.CategoryDAO;
import ru.winzdoor.onlineshoppingbackend.dto.Category;
import ru.winzdoor.onlineshoppingbackend.helper.DatabaseHelper;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
    @Autowired
    private SessionFactory sessionFactory;
    private static List<Category> categories = new ArrayList<>();

    @Override
    public boolean add(Category category) {
        return DatabaseHelper.add(sessionFactory, category);
    }

    /**
     * Update a single category
     * @param category - category
     * @return true if success
     */
    @Override
    public boolean update(Category category) {
        return DatabaseHelper.update(sessionFactory, category);
    }

    @Override
    public boolean delete(Category category) {
        category.setActive(false);
        return update(category);
    }

    @Override
    public List<Category> list() {
        String selectActiveCategories = "FROM Category WHERE active = :active";
        Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategories);
        query.setParameter("active", true);
        return query.getResultList();
    }

    /**
     * Get single category by id
     * @param id - category id
     * @return category
     */
    @Override
    public Category get(long id) {
        return sessionFactory.getCurrentSession().get(Category.class, id);
    }
}
