package ru.winzdoor.OnlineShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.winzdoor.onlineshoppingbackend.dao.ProductDAO;
import ru.winzdoor.onlineshoppingbackend.dto.Product;

import java.util.List;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {
    @Autowired
    private ProductDAO productDAO;

    @RequestMapping("/all/products")
    @ResponseBody
    public List<Product> getAllProducts(){
        return productDAO.listActiveProducts();
    }

    @RequestMapping("/category/{id}/products")
    @ResponseBody
    public List<Product> getProductsByCategory(@PathVariable long id){
        return productDAO.listActiveProductsByCategory(id);
    }
}
