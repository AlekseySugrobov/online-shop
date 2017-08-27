import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.winzdoor.onlineshoppingbackend.dao.CategoryDAO;
import ru.winzdoor.onlineshoppingbackend.dto.Category;

import java.sql.Connection;

import static org.junit.Assert.assertEquals;

public class CategoryTestCase {
    private static AnnotationConfigApplicationContext context;
    private static CategoryDAO categoryDAO;
    private Category category;
    @BeforeClass
    public static void init(){
        context = new AnnotationConfigApplicationContext();
        context.scan("ru.winzdoor.onlineshoppingbackend");
        context.refresh();

        categoryDAO = context.getBean(CategoryDAO.class);
    }

}
