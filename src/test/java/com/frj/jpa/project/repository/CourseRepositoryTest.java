package com.frj.jpa.project.repository;

import com.frj.jpa.project.entity.Course;
import com.frj.jpa.project.entity.Guardian;
import com.frj.jpa.project.entity.Student;
import com.frj.jpa.project.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;
    
    @Test
    public void printAllCourses(){

        List<Course> courses =
                courseRepository.findAll();
        System.out.println("courses = " + courses);
        
    }

    @Test
    public void saveCourseWithTeacher(){

        Teacher teacher =
                Teacher.builder()
                        .firstName("Syed")
                        .lastName("Mohiuddin")
                        .build();

        Course course =
                Course.builder()
                        .title("DAA")
                        .credit(3)
                        .teacher(teacher)
                        .build();

        courseRepository.save(course);

    }

    @Test
    public void findAllPagination(){

        Pageable firstPageWithThreeRecords =
                PageRequest.of(0,3);
        Pageable secondPageWithTwoRecords =
                PageRequest.of(1,2);

        List<Course> courses =
                courseRepository.findAll(secondPageWithTwoRecords)
                        .getContent();

        Long totalElements =
                courseRepository.findAll(secondPageWithTwoRecords)
                        .getTotalElements();

        int totalPages =
                courseRepository.findAll(secondPageWithTwoRecords)
                                .getTotalPages();

        System.out.println("totalPages = " + totalPages);

        System.out.println("totalElements = " + totalElements);

        System.out.println("courses = " + courses);

    }

    @Test
    public void findAllSort(){

        Pageable sortByTitle =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("title")
                );

        Pageable sortByCreditDesc =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("credit").descending()
                );

        Pageable sortByTitleAndCreditDesc =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("title")
                                .descending()
                                .and(Sort.by("credit"))
                );

        List<Course> courses
                = courseRepository.findAll(sortByTitle)
                                   .getContent();

        System.out.println("courses = " + courses);

    }

    @Test
    public void printBasedOnTitleContaining(){

        Pageable firstPageTenRecords =
                PageRequest.of(0, 10);

        List<Course> courses =
                courseRepository.findByTitleContaining(
                        "D", firstPageTenRecords
                ).getContent();

        System.out.println("courses = " + courses);

    }

    @Test
    public void saveCourseWithStudentAndTeacher(){

        Teacher teacher =
                Teacher.builder()
                        .firstName("Khaja")
                        .lastName("Zahooruddin")
                        .build();

        Guardian guardian =
                Guardian.builder()
                        .name("Abrar")
                        .mobile("1233211234")
                        .email("abrar@gmail.com")
                        .build();

        Student student =
                Student.builder()
                        .firstName("Afraz")
                        .lastName("Hussain")
                        .emailId("afraz@gmail.com")
                        .guardian(guardian)
                        .build();

        Course course =
                Course.builder()
                        .title("CN")
                        .credit(3)
                        .teacher(teacher)
                        .build();

        course.addStudent(student);

        courseRepository.save(course);

    }
    
}