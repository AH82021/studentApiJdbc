package dev.armancodeblcok.studentapi.service;

import dev.armancodeblcok.studentapi.entity.Student;
import dev.armancodeblcok.studentapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@Qualifier("impl")
public class StudentServiceImpl  implements StudentService{

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAllStudents();
    }

    @Override
    public Optional<Student> findStudentById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Long addStudent(Student student) {
        return studentRepository.createStudent(student);
    }

    @Override
    public void updateStudent(Long id, Student student) {
        studentRepository.updateStudent(id, student);
    }

    @Override
    public void removeStudentById(Long id) {
        studentRepository.deleteStudent(id);
    }
}
