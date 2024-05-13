package dev.armancodeblcok.studentapi;

import dev.armancodeblcok.studentapi.entity.Student;
import dev.armancodeblcok.studentapi.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = StudentApiApplication.class)


class StudentApiApplicationTest {
    private static final Logger logger = LoggerFactory.getLogger(StudentApiApplicationTest.class);
    @Autowired
private StudentRepository repository;
    @Autowired
    private StudentRepository studentRepository;
@Test
    void givenStudentRepository_getAllStudent(){
        logger.info("test invoked successfully");
      assertEquals(4,studentRepository.findAllStudents().size());
    }
}