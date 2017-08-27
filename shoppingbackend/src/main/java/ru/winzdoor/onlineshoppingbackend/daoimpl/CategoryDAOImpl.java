package ru.winzdoor.onlineshoppingbackend.daoimpl;

import org.springframework.stereotype.Repository;
import ru.winzdoor.onlineshoppingbackend.dao.CategoryDAO;
import ru.winzdoor.onlineshoppingbackend.dto.Category;

import java.util.ArrayList;
import java.util.List;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
    private static List<Category> categories = new ArrayList<>();

    static{
        Category category = new Category();
        category.setId(1);
        category.setName("Television");
        category.setDescription("some desc for tv");
        category.setImageURL("CAT_1.png");
        categories.add(category);

        category = new Category();
        category.setId(2);
        category.setName("Mobile");
        category.setDescription("some desc for mob");
        category.setImageURL("CAT_2.png");
        categories.add(category);

        category = new Category();
        category.setId(3);
        category.setName("Laptop");
        category.setDescription("some desc for laptop");
        category.setImageURL("CAT_3.png");
        categories.add(category);
    }
    @Override
    public List<Category> list() {
        return categories;
    }

    @Override
    public Category get(int id) {
        for(Category category:categories){
            if(category.getId() == id){
                return category;
            }
        }
        return null;
    }
}
