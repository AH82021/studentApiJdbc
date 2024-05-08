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

        return "student added successfully";
    }

    @PutMapping("/update/{id}")
    public void updateStudent(@PathVariable Long id, @RequestBody Student student) {


            System.out.println("student is already exist ");


        }



        @DeleteMapping("id/{id}")
        public String deleteStudentById (@PathVariable Long id){

return  "student deleted successfully";

        }

        }


// Client-Sever Architecture


// REST : Representational State Transfer
//1- Uniform Interface  : json/ html / xml formatted Resource(Representation)
//2- Statelessness
        //3- Cacheability:
        // 4- -> layered System
        //5-Client-Sever (HTTP)
        //6- -> Code on  Demand

        // 🤦 ->www.sombasa.com/zevar post ✉️ http ->  💃


