package com.example.SecurityImpl.restcontroller;

import com.example.SecurityImpl.entity.Student;
import com.example.SecurityImpl.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getAllStudent(){
        return studentService.findAll();
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable int id){
        return studentService.findById(id);
    }

    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student){
        return studentService.save(student);
    }

    @PatchMapping("/students/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable int id){
        return studentService.update(id,student);
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id){
        studentService.deleteById(id);
        return "Student with id: "+id+" was deleted successfully";
    }
}
