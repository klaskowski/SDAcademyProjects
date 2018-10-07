package ro.sda.hypermarket.core.service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ro.sda.hypermarket.core.entity.Category;
import ro.sda.hypermarket.core.service.CategoryService;

import static junit.framework.TestCase.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring-config/spring-root.xml")
public class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void testCreate(){
        Category category = new Category();
        category.setName("Food");
        category.setDescription("Food and stuff");
        categoryService.create(category);
        System.out.println(category.toString());
        categoryService.delete(category);
    }

    @Test
    public void testUpdate(){
        Category category = new Category();
        category.setName("Category1");
        category.setDescription("Description11");
        categoryService.create(category);
        System.out.println(category.toString());

        category.setDescription("DescriptionUpdated");
        categoryService.update(category);
        System.out.println(category.toString());

        categoryService.delete(category);
    }

    @Test
    public void testGetCategory(){
        Category categoryTest = new Category();
        categoryTest.setName("TestCategory");
        categoryTest.setDescription("Test Category Description");
        categoryService.create(categoryTest);
        categoryService.getCategory(categoryTest.getId());
        System.out.println(categoryTest.toString());
        categoryService.delete(categoryTest);
    }

    @Test
    public void testFindAll(){
        Category category = new Category();
        category.setName("Category1");
        category.setDescription("Description11");
        categoryService.create(category);
        System.out.println(category.toString());

        Category categoryTest = new Category();
        categoryTest.setName("TestCategory");
        categoryTest.setDescription("Test Category Description");
        categoryService.create(categoryTest);
        System.out.println(categoryTest.toString());

        categoryService.findAll();
        categoryService.delete(category);
        categoryService.delete(categoryTest);
    }

    @Test
    public void testDelete(){
        Category categoryTest = new Category();
        categoryTest.setName("TestCategory");
        categoryTest.setDescription("Test Category Description");
        categoryService.create(categoryTest);
        System.out.println(categoryTest.toString());

        categoryService.delete(categoryTest);

        assertNull(categoryService.getCategory(categoryTest.getId()));

    }
}
