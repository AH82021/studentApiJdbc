package dev.armancodeblcok.studentapi.service;

import dev.armancodeblcok.studentapi.entity.Student;
import dev.armancodeblcok.studentapi.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {
    @Mock
    private StudentRepository repository;
    @InjectMocks
    private StudentServiceImpl service;

    private final List<Student>   mockStudents = Arrays.asList(
            new Student( null,"Alice Smith", "alice.smith@example.com", 3.5),
                new Student(null,"Bob Johnson", "bob.johnson@example.com", 3.6),
                new Student(null,"Charlie Lee", "charlie.lee@example.com", 3.7),
                new Student(null,"Diana King", "diana.king@example.com", 3.8)
        );

    @Test
    void findAllStudents() {


        //Set expectations on mock
        when(repository.findAllStudents()).thenReturn(mockStudents);

        // call the method under test
        List<Student> students = service.findAllStudents();

        //Check the method underTest
        assertEquals(4, students.size());
        assertEquals("Alice Smith", students.get(0).getName());
        assertEquals("alice.smith@example.com", students.get(0).getEmail());
        assertEquals(3.5, students.get(0).getGpa());

        //verify the method underTest called
        verify(repository).findAllStudents();

    }

    @Test
    void testServiceUsingMockRepository() {
StudentRepository mockRepo = mock(StudentRepository.class);

when(mockRepo.findAllStudents()).thenReturn(mockStudents);

StudentService service = new StudentServiceImpl(mockRepo);

        List<Student> students = service.findAllStudents();

        assertEquals(4, students.size());
        verify(mockRepo).findAllStudents();





    }
}