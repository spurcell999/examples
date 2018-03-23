package com.example.demo;


import com.example.demo.domain.Person;
import com.example.demo.domain.Student;
import com.example.demo.repo.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrudRepositoryDemo {

    @Autowired
    StudentRepository studentRepository;

    @Test
    public void simpleStudentCrudExample() {
        boolean fullTime = true;
        studentRepository.save(new Student(new Person("scott", "doe"), fullTime, 20));
        studentRepository.save(new Student(new Person("david", "eod"), fullTime, 22));
        studentRepository.save(new Student(new Person("mike", "ode"), fullTime, 18));
        studentRepository.save(new Student(new Person("rusty", "eed"), fullTime, 19));

        System.out.println("\n******************* original students *****************************");
        studentRepository.findAll().forEach(student -> {
            student.setAge(student.getAge() + 1);
            studentRepository.save(student);
        });

        System.out.println("\n*************Students a year older*************");
        studentRepository.findAll().forEach(System.out::println);

        studentRepository.deleteAll();
        System.out.println("\n*************Students removed*************");
        studentRepository.findAll().forEach(System.out::println);
    }
}
