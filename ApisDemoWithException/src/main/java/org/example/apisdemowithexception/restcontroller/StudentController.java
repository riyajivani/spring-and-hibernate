package org.example.apisdemowithexception.restcontroller;

import jakarta.annotation.PostConstruct;
import org.example.apisdemowithexception.dto.StudentErrorResponse;
import org.example.apisdemowithexception.entity.Student;
import org.example.apisdemowithexception.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private List<Student> allStudent;

    @PostConstruct
    public void loadStudents(){
        allStudent = new ArrayList<>();
        allStudent.add(new Student(1,"riya","riyajivani@gmail.com",6,"Nadiad","Female","B.tech IT"));
        allStudent.add(new Student(2,"priya","priya@gmail.com",7,"Junagdh","Female","B.tech CE"));
        allStudent.add(new Student(3,"shreya","shreya@gmail.com",2,"Upleta","Female","B.tech EC"));
    }

    @GetMapping("/students")
    public List<Student> getAllStudent(){
        return allStudent;
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable int id){
        Student matchStudent = allStudent.stream()
                .filter(student -> student.getId()==id)
                .findFirst()
                .orElse(null);
        if(matchStudent==null)
            throw new StudentNotFoundException("Student not founf with id = "+id);
        return matchStudent;
    }

    @PostMapping("/students")
    public Student addNewStudent(@RequestBody Student student){
        if(student.getId()==0){
            student.setId(allStudent.size()+1);
        }
        allStudent.add(student);
        return student;
    }

    @DeleteMapping("/students/{id}")
    public String deleteStudentById(@PathVariable int id){
        Student matchStudent = allStudent.stream()
                .filter(student -> student.getId()==id)
                .findFirst()
                .orElse(null);
        allStudent.remove(matchStudent);
        return "Student with id = " + id + " removed successfully";
    }

    @PatchMapping("/students/{id}")
    public Student updateStudent(@RequestBody Student updateStudent, @PathVariable int id){
        Student matchStudent = allStudent.stream()
                .filter(student -> student.getId()==id)
                .findFirst()
                .orElse(null);

        if(matchStudent!=null) {
            if (updateStudent.getName() != null)
                matchStudent.setName(updateStudent.getName());

            if (updateStudent.getCity() != null)
                matchStudent.setCity(updateStudent.getCity());

            if (updateStudent.getEmail() != null)
                matchStudent.setEmail(updateStudent.getEmail());

            if (updateStudent.getGender() != null)
                matchStudent.setGender(updateStudent.getGender());

            if (updateStudent.getSemester() != 0)
                matchStudent.setSemester(updateStudent.getSemester());

            if (updateStudent.getProgram() != null)
                matchStudent.setProgram(updateStudent.getProgram());
        }
        return matchStudent;
    }
}
