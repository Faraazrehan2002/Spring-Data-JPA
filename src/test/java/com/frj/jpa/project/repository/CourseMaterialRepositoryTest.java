package com.frj.jpa.project.repository;

import com.frj.jpa.project.entity.Course;
import com.frj.jpa.project.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void SaveCourseMaterial(){

        Course course =
                Course.builder()
                        .title("DBMS")
                        .credit(3)
                        .build();

        CourseMaterial courseMaterial =
                CourseMaterial.builder()
                        .course(course)
                        .url("www.dbms.com")
                        .build();

        repository.save(courseMaterial);

    }

    @Test
    public void printAllCourseMaterials(){

        List<CourseMaterial> courseMaterials =
                repository.findAll();
        System.out.println("courseMaterials = " + courseMaterials);

    }

}