package com.frj.jpa.project.repository;

import com.frj.jpa.project.entity.Course;
import com.frj.jpa.project.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;


    @Test
    public void saveTeacherDetails(){

        Course courseDS =
                Course.builder()
                        .title("DS")
                        .credit(4)
                        .build();

        Course courseOS =
                Course.builder()
                        .title("OS")
                        .credit(3)
                        .build();

        Teacher teacher =
                Teacher.builder()
                        .firstName("Maniza")
                        .lastName("Hijab")
                        //.courses(List.of(courseDS, courseOS))
                        .build();

        teacherRepository.save(teacher);

    }

}