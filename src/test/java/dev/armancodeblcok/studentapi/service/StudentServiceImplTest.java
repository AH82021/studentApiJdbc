package dev.armancodeblcok.studentapi.service;

import dev.armancodeblcok.studentapi.entity.Student;
import dev.armancodeblcok.studentapi.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {
    @Mock
    private StudentRepository studentRepository;
    @InjectMocks
    private StudentServiceImpl studentService;
    private final List<Student> mockStudents = Arrays.asList(
            new Student( null,"Alice Smith", "alice.smith@example.com", 3.5),
            new Student(null,"Bob Johnson", "bob.johnson@example.com", 3.6),
            new Student(null,"Charlie Lee", "charlie.lee@example.com", 3.7),
            new Student(null,"Diana King", "diana.king@example.com", 3.8)
    );

    @Test
    void findAllStudents() {
        // set expectations on mock
        when(studentRepository.findAllStudents()).thenReturn(mockStudents);

        // call the method under test
       List<Student> students = studentService.findAllStudents();

       // check method underTest
        assertEquals(4,students.size());
        assertEquals("Alice Smith",students.get(0).getName());
        assertEquals("alice.smith@example.com",students.get(0).getEmail());
        assertEquals(3.5,students.get(0).getGpa());


        // verify the method underTest called
        verify(studentRepository).findAllStudents();

    }

    @Test
    void findStudentById() {
        Student s = new Student( 1L,"Alice Smith", "alice.smith@example.com", 3.5);
        when(studentRepository.findById(1L)).thenReturn(Optional.of(s));

        Optional<Student> student = studentService.findStudentById(1L);

        assertEquals("Alice Smith",student.get().getName());
        assertEquals("alice.smith@example.com",student.get().getEmail());
        assertEquals(3.5,student.get().getGpa());



    }

    @Test
    void addStudent() {
        Student s = new Student( null,"Alice Smith", "alice.smith@example.com", 3.5);
        // set expectations on mock
        when(studentRepository.createStudent(s)).thenReturn(1L);
        // call the method under test
       Long num =  studentService.addStudent(s);

       assertEquals(1L,num);

       verify(studentRepository).createStudent(s);

    }

    @Test
    void updateStudent() {
    Student s = new Student( 1L,null, null, 0);
        Student uS = new Student( null,"Alice Smith", "alice.smith@example.com", 3.5);
       doNothing().when(studentRepository).updateStudent(1L,uS);


        studentService.updateStudent(1L,uS);
        assertEquals("Alice Smith", uS.getName());
    }

    @Test
    void removeStudentById() {
    }
}