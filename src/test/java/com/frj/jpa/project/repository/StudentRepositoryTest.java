package com.frj.jpa.project.repository;

import com.frj.jpa.project.entity.Guardian;
import com.frj.jpa.project.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;



@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){

        Student student = Student.builder()
                .emailId("faraaz@gmail.com")
                .firstName("Faraaz")
                .lastName("Rehan")
                //.guardianName("Umme")
                //.guardianEmail("umme@gmail.com")
                //.guardianMobile("231233211")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian = Guardian.builder()
                .name("Qutb")
                .email("qutb@gmail.com")
                .mobile("4343432119")
                .build();

        Student student = Student.builder()
                .firstName("Madhiha")
                .lastName("Ilaf")
                .emailId("madhiha@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);

    }

    @Test
    public void printAllStudent(){

        List<Student> studentList = 
                studentRepository.findAll();
        System.out.println("studentList = " + studentList);

    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students =
                studentRepository.findByFirstName("Madhiha");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> students =
                studentRepository.findByFirstNameContaining("a");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students =
                studentRepository.findByGuardianName("Qutb");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentBasedOnFirstNameAndLastName(){
        Student students =
                studentRepository.findByFirstNameAndLastName("Madhiha", "Ilaf");
        System.out.println("students = " + students);
    }
    
    @Test
    public void printStudentBasedOnEmailAddress(){
        Student student = 
                studentRepository.getStudentByEmailAddress("madhiha@gmail.com");
        System.out.println("student = " + student);
    }
    
    @Test
    public void printStudentFirstNameBasedOnEmailAddress(){
        String studentFirstName =
                studentRepository.getStudentFirstNameByEmailAddress("faraaz@gmail.com");
        System.out.println("studentFirstName = " + studentFirstName);
    }

    @Test
    public void printStudentBasedOnEmailAddressNative(){
        Student student =
                studentRepository.getStudentByEmailAddressNative("madhihailaf@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void printStudentBasedonEmailAddressNativeNamedParam(){
        Student student =
                studentRepository.getStudentByEmailAddressNativeNamedParam("faraaz@gamil.com");
        System.out.println("student = " + student);
    }

    @Test
    public void updateStudentLastNameBasedOnEmailAddress(){
        studentRepository.updateStudentLastNameByEmailAddress(
                "junaidi", "faraaz@gmail.com");
    }
    
}