package dev.armancodeblcok.studentapi.service;

import dev.armancodeblcok.studentapi.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> findAllStudents();
    Optional<Student> findStudentById(Long id);
    Long addStudent(Student student);
    void updateStudent(Long id, Student student);
    void removeStudentById(Long id);
}
