package dev.armancodeblcok.studentapi.service;

import dev.armancodeblcok.studentapi.entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Qualifier("jpa")
public class StudentServiceImplJpa implements StudentService{

    public String getStudent(){
        return "student is sleeping";
    }

    @Override
    public List<Student> findAllStudents() {
        return List.of();
    }

    @Override
    public Optional<Student> findStudentById(Long id) {
        return Optional.empty();
    }
}
