package dev.armancodeblcok.studentapi.controller;

import dev.armancodeblcok.studentapi.entity.Student;

import dev.armancodeblcok.studentapi.repository.StudentRepository;
import dev.armancodeblcok.studentapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//
@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(@Qualifier("impl") StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/all")
    public List<Student> getStudents() {

return  studentService.findAllStudents();


    }

    @GetMapping("/{name}")
    public Student getStudentByName(@PathVariable String name) {


        return null;
    }

    @GetMapping("id/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id) {


        return studentService.findStudentById(id);

    }

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student) {

      if(  studentService.addStudent(student)>0){

        return "student added successfully";
      }

      return "Unable to add Student";

    }

    @PutMapping("/update/{id}")
    public void updateStudent(@PathVariable Long id, @RequestBody Student student) {

studentService.updateStudent(id,student);



        }



        @DeleteMapping("id/{id}")
        public void deleteStudentById (@PathVariable Long id){


   studentService.removeStudentById(id);

        }

        }





