package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Assertions;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.Optional;

public class CategoryRepositoryTest extends StudyApplicationTests {
    @Autowired
    private CategoryRepository categoryRepository;


    @Test
    public void create(){

        String type = "COMPUTER";
        String title = "컴퓨터";
        LocalDateTime createdAt = LocalDateTime.now();
        String createBy = "AdminServer";

        Category category = new Category();
        category.setType(type);
        category.setTitle(title);
        category.setCreatedAt(createdAt);
        category.setCreatedBy(createBy);


        Category newCategory = categoryRepository.save(category);

        Assertions.assertNotNull(newCategory);
        Assertions.assertEquals(newCategory.getType(),type);
        Assertions.assertEquals(newCategory.getTitle(),title);


        //categoryRepository

    }


    @Test
    public void read(){
        String type = "COMPUTER";
        Optional<Category> categoryOptional = categoryRepository.findByType(type);

        //select * from category where type = 'COMPUTER'



        System.out.println(categoryOptional.get());
        categoryOptional.ifPresent(c ->{
            Assertions.assertEquals(c.getType(),type);
            System.out.println(c.getId());
            System.out.println(c.getType());
            System.out.println(c.getTitle());
        });
    }
}
